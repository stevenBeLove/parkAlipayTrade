/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月29日 下午4:20:02 <br/> 
 */
package com.qt.sales.web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingVehicleQueryRequest;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipayEcoMycarParkingVehicleQueryResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.qt.sales.common.RSConsts;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;
import com.qt.sales.model.OrderBean.OrderSynStatus;
import com.qt.sales.service.OrderBeanService;
import com.qt.sales.service.ParkService;
import com.qt.sales.service.impl.ParkServiceImpl;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;

/** 
 * 类名: ParkController <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月29日 下午4:20:02 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
@Controller
@RequestMapping("/park")
public class ParkController {
    
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ParkService parkService;
	
	
	@Resource
	private OrderBeanService orderBeanService;


    /**
     * 跳转到列表页
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/parkList", method = RequestMethod.GET)
    public String showList(Model model) {
        return "park/parkList";
    }
    
    /**
     * 跳转到列表页
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/showCarControl/{outParkingId}", method = RequestMethod.GET)
    public String showCarControl(@PathVariable("outParkingId") String outParkingId, Model model) {
        ParkBean bean = parkService.selectByPrimaryKey(outParkingId);
        model.addAttribute("outParkingId",bean.getOutParkingId());
        return "park/parkControl";
    }
    
    /**
     * 跳转到唤醒页
     * @return 页面路径
     */
    @RequestMapping(value = "/orderView/{tradeNO}", method = RequestMethod.GET)
    public String orderView(@PathVariable("tradeNO") String tradeNO, Model model) {
        model.addAttribute("tradeNO",tradeNO);
        return "alipayPark/orderView";
    }
    
	/**
	 * 【方法名】 : (车牌查询). <br/>
	 * 【作者】: yinghui zhang .<br/>
	 * 【时间】： 2017年10月28日 下午9:00:28 .<br/>
	 * 【参数】： .<br/>
	 * 
	 * @param code
	 * @param app_auth_token
	 * @param car_id
	 *            .<br/>
	 *            <p>
	 *            修改记录.<br/>
	 *            修改人: yinghui zhang 修改描述： .<br/>
	 *            <p/>
	 */
	@RequestMapping(value = "/vehicleQuery", method = RequestMethod.GET)
	public String ecoMycarParkingVehicleQueryRequest(Model model) {
			String path ="alipayPark/orderView";
		
			String car_id = "10202";
			String userid = "2088702384663522";
			String parking_id = "PI1511448042667331021";
			String car_number = "沪A6B521";
			// 调用成功
			String uid = "2088702384663522";
			ParkBean parkBean = parkService.selectByPrimaryParkingId(parking_id);
			// 授权设置
			model.addAttribute(RSConsts.car_number, car_number);
			//显示订单信息
			BigDecimal money =getPayMoney(car_number,parking_id);//调用接口查询费用
			//创建订单
			OrderBeanExample example = new OrderBeanExample();
			OrderBeanExample.Criteria cr = example.createCriteria();
			cr.andCarNumberEqualTo(car_number);
			cr.andParkingIdEqualTo(parking_id);
			//cr.andOrderSynStatusEqualTo(OrderSynStatus.create.getVal());
			List<OrderBean> orderList = orderBeanService.selectByExample(example);
			if(orderList==null || orderList.size()==0){
				model.addAttribute("msg", "无订单生成！");
				model.addAttribute("status", false);
				return path;
			}
			
			//首先查询是否存在未付款的订单
			OrderBean order = null;
			for (OrderBean orderBean : orderList) {
				//有未付款的订单
				if(OrderSynStatus.create.getVal().equals(orderBean.getOrderSynStatus())){
					order = orderBean;
				}
			}
			//没有找到未付款的订单，找下已经付款的订单
			if(StringUtils.isEmpty(order)){
				boolean haveOrder = false;
				for (OrderBean orderBean : orderList) {
					//找到已经付款的订单
					if(OrderSynStatus.paysucess.getVal().equals(orderBean.getOrderSynStatus())){
						order = orderBean;
						haveOrder = true;
					}
				}
				if(haveOrder){
					//判断订单的金额是否已经超时产生费用
					String paidMoney =orderBeanService.queryTempPaidWithOrderTrade(order.getOrderTrade());
					BigDecimal tradePaidMoney = new BigDecimal(paidMoney);
					if(money.compareTo(tradePaidMoney) == 1){
						//创建未支付订单
						ParkBean bean = parkService.selectByPrimaryParkingId(parking_id);
						String in_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
						String outOrderNo = parkService.enterinfoSyncEnter(bean, order.getOrderTrade(), car_number, in_time, order.getCarType(), order.getCarColor(), order.getAgreementStatus(),
								order.getBillingTyper(),order.getCarNumberColor(),order.getLane());
						OrderBean noPaidOrder = orderBeanService.selectByPrimaryKey(outOrderNo);
						order = noPaidOrder;
					}
				}
			}
			
			if(StringUtils.isEmpty(order)){
				model.addAttribute("msg", "无订单生成！");
				model.addAttribute("status", false);
				return path;
			}
			//更新订单信息
			order.setUserId(uid);
			order.setCarId(car_id);
			orderBeanService.updateByPrimaryKey(order);
			model.addAttribute("outOrderNo", order.getOutOrderNo());
			//查询已付金额
			String paidMoney = orderBeanService.queryTempPaidWithOrderTrade(order.getOrderTrade());
			if(!"0".equals(paidMoney)){
				BigDecimal paid = new BigDecimal(paidMoney);
				if (money.compareTo(paid) == 1) {
					String payResult = money.subtract(paid).floatValue() + "";
					BigDecimal setScale = new BigDecimal(payResult).setScale(2, BigDecimal.ROUND_HALF_DOWN);
					model.addAttribute(RSConsts.payMoney, setScale);
					model.addAttribute(RSConsts.paidMoney, paid.setScale(2, BigDecimal.ROUND_HALF_DOWN));
				}else if(money.compareTo(paid) == 0){
					model.addAttribute(RSConsts.payMoney, RSConsts.zero);
					model.addAttribute(RSConsts.paidMoney, paid.setScale(2, BigDecimal.ROUND_HALF_DOWN));
					model.addAttribute(RSConsts.payBtn, false);
				}
			}else{
				BigDecimal setScale = money.setScale(2,BigDecimal.ROUND_HALF_DOWN);
				model.addAttribute(RSConsts.payMoney, setScale);
				model.addAttribute(RSConsts.paidMoney, RSConsts.zero);
			}
			model.addAttribute(RSConsts.parkingName, parkBean.getParkingName());
			model.addAttribute(RSConsts.merchantLogo, parkBean.getMerchantLogo());
			model.addAttribute(RSConsts.discountMoney, getDiscountMoney(car_number,order.getOutParkingId()));//优惠金额
			model.addAttribute(RSConsts.inTime, order.getInTime());
			String nowTime =DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
			try {
				model.addAttribute(RSConsts.timeDiffer, DateUtil.getTimeDiffer(order.getInTime(), nowTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				model.addAttribute(RSConsts.inDuration, DateUtil.getTimeDifferMin(order.getInTime(), nowTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute(RSConsts.orderTime, DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT));

			return path;
	}

	public BigDecimal getPayMoney(String carNumber, String outParkingId) {
		String conate = parkService.selectByPrimaryParkingId("10002").getContactName();
		return new BigDecimal(conate);
	}

	public String getDiscountMoney(String carNumber, String outParkingId) {
		return "0.00";
	}
    
    /**
     * 查询人员列表
     * 
     * @param pageSize
     *            页数
     * @param offset
     *            每页多少条
     * @param user
     *           用户信息
     * @param response
     *            response
     * @throws Exception
     *             异常
     */
    @RequestMapping(value = "/parkPagelist")
    @ResponseBody
    public ResultList list(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, HttpServletResponse response)
        throws Exception {
        ParkBeanExample example = new ParkBeanExample();
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        ParkBeanExample.Criteria cr = example.createCriteria();
//        if (!StringUtils.isEmpty(fansAgency.getAgencyId())) {
//            cr.andAgencyIdEqualTo(fansAgency.getAgencyId().trim());
//        }

//        if (!StringUtils.isEmpty(fansAgency.getAgencyName())) {
//            cr.andAgencyNameLike("%"+fansAgency.getAgencyName()+"%");
//        }
//        if (!StringUtils.isEmpty(fansAgency.getStatus())) {
//            cr.andStatusEqualTo(fansAgency.getStatus());
//        }
        example.setOrderByClause(" CREATE_DATETIME desc");
        int totalRowCount = parkService.countByExample(example);
        List<ParkBean> list = parkService.selectByExample(example);
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        return res;
    }
    
    
    
}

