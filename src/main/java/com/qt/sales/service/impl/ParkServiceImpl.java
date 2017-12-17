/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2017年10月29日 下午2:10:48 <br/> 
 */
package com.qt.sales.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingAgreementQueryRequest;
import com.alipay.api.request.AlipayEcoMycarParkingConfigSetRequest;
import com.alipay.api.request.AlipayEcoMycarParkingOrderSyncRequest;
import com.alipay.api.request.AlipayEcoMycarParkingParkinglotinfoCreateRequest;
import com.alipay.api.request.AlipayEcoMycarParkingParkinglotinfoUpdateRequest;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayEcoMycarParkingAgreementQueryResponse;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.alipay.api.response.AlipayEcoMycarParkingOrderSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoCreateResponse;
import com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoUpdateResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.qt.sales.common.AliPayUtil;
import com.qt.sales.common.PropertiesUtil;
import com.qt.sales.common.RSConsts;
import com.qt.sales.dao.OrderBeanMapper;
import com.qt.sales.dao.ParkBeanMapper;
import com.qt.sales.dao.VehicleBeanMapper;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.model.OrderBean.OrderStatus;
import com.qt.sales.model.OrderBean.OrderSynStatus;
import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;
import com.qt.sales.model.VehicleBean;
import com.qt.sales.service.OrderBeanService;
import com.qt.sales.service.ParkService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.web.AlipayParkController;

/** 
 * 类名: ParkServiceImpl <br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月29日 下午2:10:48 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
@Service("parkService")
public class ParkServiceImpl implements ParkService {

    
    protected final Logger       logger = LoggerFactory.getLogger(this.getClass());  
    
    public static Map<String,Object> parkingStore = new HashMap<String,Object>();
    
    @Resource
    private ParkBeanMapper parkBeanMapper;
    
    @Resource
    private VehicleBeanMapper vehicleBeanMapper;
    
    @Resource
    private OrderBeanMapper orderBeanMapper;
    
  	@Resource(name = "aliPayUtil")
  	private AliPayUtil aliPayUtil;
  	
    @Resource(name = "propertiesUtil")
    private PropertiesUtil propertiesUtil;
    
    @Resource
    private ServletContext servletContext;
    
    
    @Override
    public ParkBean selectByPrimaryKey(String outParkingId){
        return parkBeanMapper.selectByPrimaryKey(outParkingId);
    }

    @Override
    public ParkBean selectByPrimaryParkingId(String parkingId){
        return parkBeanMapper.selectByPrimaryParkingId(parkingId);
    }

    @Override
    public int updateByPrimaryKey(ParkBean record) {
        return parkBeanMapper.updateByPrimaryKey(record);
    }


    @Override
    public int insert(ParkBean record) {
        return parkBeanMapper.insert(record);
    }


    @Override
    public int countByExample(ParkBeanExample example) {
        return parkBeanMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(ParkBeanExample example) {
        return parkBeanMapper.deleteByExample(example);
    }


    @Override
    public int deleteByPrimaryKey(String outParkingId) {
        return parkBeanMapper.deleteByPrimaryKey(outParkingId);
    }


    @Override
    public int insertSelective(ParkBean record) {
        return parkBeanMapper.insertSelective(record);
    }


    @Override
    public List<ParkBean> selectByExample(ParkBeanExample example) {
        // TODO Auto-generated method stub
        return parkBeanMapper.selectByExample(example);
    }
    

    @Override
    public int updateByPrimaryKeySelective(ParkBean record) {
        return parkBeanMapper.updateByPrimaryKeySelective(record);
    }
    
    
    /**
     * 【方法名】    : (停车ISV系统配置接口). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年10月29日 下午8:16:30 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * @throws QTException 
     * @throws IOException 
     */
    public boolean parkingConfigSetRequest(String outParkingId) throws Exception{
        ParkBean park = this.selectByPrimaryKey(outParkingId);
        AlipayClient alipayClient = aliPayUtil.getInstance();
        AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
        request.setBizContent(getBizContent(park));//业务数据
        request.putOtherTextParam("app_auth_token",park.getAppAuthToken());
        AlipayEcoMycarParkingConfigSetResponse  response;
        try {
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                logger.debug("调用成功");
                return true;
            } else {
                throw new QTException(response.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            throw new QTException(e.getErrMsg());
        }
    }
    
    /**
     * 
     * 【方法名】    : (业务数据). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年10月29日 下午8:43:57 .<br/>
     * 【参数】： .<br/>
     * @param park
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * @throws IOException 
     */
    private String getBizContent(ParkBean park) throws IOException{
        JSONObject data = new JSONObject();
        data.put(RSConsts.MERCHANT_NAME, propertiesUtil.readValue("alipay.isvName"));
        data.put(RSConsts.MERCHANT_SERVICE_PHONE, park.getMerchantServicePhone());
        data.put(RSConsts.ACCOUNT_NO, propertiesUtil.readValue("alipay.isvAccount"));
        data.put(RSConsts.MERCHANT_LOGO, getImageStr());
        List<JSONObject> listJson = new ArrayList<JSONObject>();
        JSONObject list = new JSONObject();
        list.put(RSConsts.INTERFACE_NAME, "alipay.eco.mycar.parking.userpage.query");
        list.put(RSConsts.INTERFACE_TYPE, "interface_page");
        list.put(RSConsts.INTERFACE_URL, AlipayParkController.INTERFACE_URL);
        listJson.add(list);
        data.put(RSConsts.INTERFACE_INFO_LIST, JSON.toJSON(listJson));
        String jsonStr = JSON.toJSONString(data);
        logger.debug(jsonStr);
        return jsonStr;
    }
    
    
    public String getImageStr() {
        // 待处理的本地图片
        try {
            String path = servletContext.getRealPath("/") + File.separator + "images" + File.separator + "logo.png";
            File file = new File(path);
            InputStream in = null;
            byte[] data = null;
            // 读取图片字节数组
            try {
                in = new FileInputStream(file);
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            // 返回Base64编码过的字节数组字符串
            return "data:image/png;base64," + encoder.encode(data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String parkingCreate(String outParkingId) {
        ParkBean park = this.selectByPrimaryKey(outParkingId);
        JSONObject returnjson = new JSONObject();
        AlipayEcoMycarParkingParkinglotinfoCreateRequest request = new AlipayEcoMycarParkingParkinglotinfoCreateRequest();
        request.setBizContent(getParkingCreateBizContent(park));
        request.putOtherTextParam("app_auth_token", park.getAppAuthToken());
        AlipayEcoMycarParkingParkinglotinfoCreateResponse response;
        try {
        	AlipayClient alipayClient = aliPayUtil.getInstance();
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                park.setParkingId(response.getParkingId());
                updateByPrimaryKeySelective(park);
                ParkServiceImpl.parkingStore.put(outParkingId,park.getAppAuthToken());
                ParkServiceImpl.parkingStore.put(response.getParkingId(),park.getAppAuthToken());
                returnjson.put(RSConsts.STATUS, RSConsts.SUCCESS_CODE);
                returnjson.put(RSConsts.MESSAGE, "同步创建停车场成功!");
                logger.debug("同步创建停车场成功!");
            } else {
                returnjson.put(RSConsts.STATUS, RSConsts.FAILE_CODE);
                returnjson.put(RSConsts.MESSAGE, response.getSubMsg());
                returnjson.put(RSConsts.BODY, response.getBody());
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return JSON.toJSONString(returnjson);
    }
	
	
	
    //封装业务数据
	private String getParkingCreateBizContent(ParkBean park){
        JSONObject data = new JSONObject();
        data.put(RSConsts.city_id, park.getCityId());
        data.put(RSConsts.equipment_name, park.getEquipmentName());
        data.put(RSConsts.out_parking_id, park.getOutParkingId());
        data.put(RSConsts.parking_address, park.getParkingAddress());
        data.put(RSConsts.longitude, park.getLongitude());
        data.put(RSConsts.latitude, park.getLatitude());
        data.put(RSConsts.parking_start_time, park.getParkingStartTime());
        data.put(RSConsts.parking_end_time, park.getParkingEndTime());
        data.put(RSConsts.parking_number, park.getParkingNumber());
        data.put(RSConsts.parking_lot_type,park.getParkingLotType());
        data.put(RSConsts.parking_type,park.getParkingType());
        data.put(RSConsts.payment_mode,park.getPaymentMode());
        data.put(RSConsts.pay_type,park.getPayType());
        data.put(RSConsts.shopingmall_id,park.getShopingmallId());
        data.put(RSConsts.parking_fee_description,park.getParkingFeeDescription());
        data.put(RSConsts.contact_name,park.getContactName());
        data.put(RSConsts.contact_mobile,park.getContactMobile());
        data.put(RSConsts.contact_tel,park.getContactTel());
        data.put(RSConsts.contact_emali,park.getContactEmali());
        data.put(RSConsts.contact_weixin,park.getContactWeixin());
        data.put(RSConsts.contact_alipay,park.getContactAlipay());
        data.put(RSConsts.parking_name,park.getParkingName());
        data.put(RSConsts.time_out,park.getTimeOut());
        String jsonStr = JSON.toJSONString(data);
        return jsonStr;
	}


	@Override
	public String parkinglotinfoUpdate(String outParkingId) {
		ParkBean park = this.selectByPrimaryKey(outParkingId);
		JSONObject returnjson = new JSONObject();
		AlipayEcoMycarParkingParkinglotinfoUpdateRequest request = new AlipayEcoMycarParkingParkinglotinfoUpdateRequest();
		request.setBizContent(getParkingCreateBizContent(park));
		request.putOtherTextParam("app_auth_token", park.getAppAuthToken());
		AlipayEcoMycarParkingParkinglotinfoUpdateResponse response;
		AlipayClient alipayClient = aliPayUtil.getInstance();
		try {
			response = alipayClient.execute(request);
			if (response.isSuccess()) {
				returnjson.put(RSConsts.STATUS, RSConsts.SUCCESS_CODE);
				returnjson.put(RSConsts.MESSAGE, "更新停车场成功!");
			} else {
				returnjson.put(RSConsts.STATUS, RSConsts.FAILE_CODE);
				returnjson.put(RSConsts.MESSAGE, response.getMsg());
				returnjson.put(RSConsts.BODY, response.getBody());
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSON.toJSONString(returnjson);
	}
	
	
	@PostConstruct
	public void initParkingCache(){
		 ParkBeanExample example = new ParkBeanExample();
		 ParkBeanExample.Criteria cr = example.createCriteria();
		 cr.andAppAuthTokenIsNotNull();
		 List<ParkBean> parks = this.selectAllParkBean(example);
		 for (ParkBean parkBean : parks) {
			if(parkBean!=null && !StringUtils.isEmpty(parkBean.getAppAuthToken())){
				logger.debug("---装入park---"+parkBean.getOutParkingId() + "|" + parkBean.getAppAuthToken());
				parkingStore.put(parkBean.getOutParkingId(), parkBean.getAppAuthToken());
				if(!StringUtils.isEmpty(parkBean.getParkingId())){
				    logger.debug("---装入park---"+parkBean.getParkingId() + "|" + parkBean.getAppAuthToken());
				    parkingStore.put(parkBean.getParkingId(), parkBean.getAppAuthToken());
				}
				
			}
			
		}
	}

	public static Random random1 = new Random();
	@Override
	public String enterinfoSyncEnter(ParkBean park,String orderTrade, String carNumber, String in_time,
			String carType,String carColor,String agreementStatus,String billingType,String carNumberColor,String lane) {
		OrderBean bean = new OrderBean();//创建订单
		bean.setParkingName(park.getParkingName());
		bean.setSellerId(park.getAlipayUserId());
		bean.setParkingId(park.getParkingId());
		bean.setCarNumber(carNumber);
		bean.setInTime(in_time);
		bean.setOrderNo("0");//未同步
		String outOrderNo = DateUtil.getCurrDateAndTime()+random1.nextInt(1000);
		bean.setOutOrderNo(outOrderNo);//订单号
		bean.setOutParkingId(park.getOutParkingId());
		bean.setCarColor(carColor);
		bean.setCarType(carType);
		if(StringUtils.isEmpty(agreementStatus)){
	        try {
	         String   agreement = agreementQueryRequest(carNumber,park.getAppAuthToken());
	         bean.setAgreementStatus(agreement);
	        } catch (AlipayApiException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (QTException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}else{
		    bean.setAgreementStatus(agreementStatus); 
		}
		bean.setPayType("1");
		bean.setUpdateTime(in_time);
		bean.setOrderStatus(OrderStatus.sucess.getVal());
		bean.setPaidMoney(new BigDecimal("0.00"));
		bean.setOrderSynStatus(OrderSynStatus.create.getVal());
		if(StringUtils.isEmpty(orderTrade)){
			//新入场
			bean.setOrderTrade(outOrderNo);
			//问题数据
			updateOrderBeanStatus(carNumber, park.getOutParkingId());
		}else{
			bean.setOrderTrade(orderTrade);
		}
		bean.setBillingTyper(billingType);
		bean.setCarNumberColor(carNumberColor);
		bean.setLane(lane);
		bean.setStatus("0");
    orderBeanMapper.insert(bean);
    return outOrderNo;
	}
	
	private void updateOrderBeanStatus(String carNumber,String outParkingId){
		OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo(carNumber);
        cr.andOutParkingIdEqualTo(outParkingId);
        cr.andStatusEqualTo("0");
        List<OrderBean> orderList = orderBeanMapper.selectByExample(example);
		if(orderList!=null && orderList.size()>0){
			for (OrderBean orderBean : orderList) {
				orderBeanMapper.updateOrderStauts(orderBean);
			}
		}
	}
	
    /**
     * 查询是否开通免密支付
     * 
     * @throws AlipayApiException
     * @throws QTException
     */
    public String agreementQueryRequest(String carNumber, String appToken) throws AlipayApiException, QTException {
        AlipayEcoMycarParkingAgreementQueryRequest request = new AlipayEcoMycarParkingAgreementQueryRequest();
        JSONObject data = new JSONObject();
        data.put(RSConsts.car_number, carNumber);
        request.setBizContent(JSON.toJSONString(data));
        request.putOtherTextParam(RSConsts.app_auth_token, appToken);
        AlipayClient alipayClient = aliPayUtil.getInstance();
        AlipayEcoMycarParkingAgreementQueryResponse response = alipayClient.execute(request);
        String agreementStatus = "1";// 车牌代扣状态，0：为支持代扣，1：为不支持代扣
        if (response.isSuccess()) {
            agreementStatus = response.getAgreementStatus();
            logger.info("调用免密状态成功");
        } else {
            logger.error("调用免密状态失败");
            throw new QTException("调用失败，请重试!");
        }
        return agreementStatus;
    }


	@Override
	public String ecoMycarParkingExitinfoSync(ParkBean park,String carNumber,String out_time) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String ecoMycarParkingVehicleQuery(VehicleBean bean) {
		 vehicleBeanMapper.insert(bean);
		 return "success";
	}


	@Override
	public String ecoMycarParkingOrderSyn() {
		try {
			AlipayEcoMycarParkingOrderSyncRequest request = new AlipayEcoMycarParkingOrderSyncRequest();
			String token = (String) ParkServiceImpl.parkingStore.get("");
			OrderBean order = new OrderBean();
			
			AlipayClient alipayClient = aliPayUtil.getInstance();
			request.setBizContent(orderSynBiz(order));
			request.putOtherTextParam("app_auth_token", token);
			AlipayEcoMycarParkingOrderSyncResponse response = alipayClient.execute(request);
			if(response.isSuccess()){
			System.out.println("调用成功");
			} else {
			System.out.println("调用失败");
			}
			
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String orderSynBiz(OrderBean order){
	    JSONObject data = new JSONObject();
	    data.put(RSConsts.user_id, order.getUserId());
	    data.put(RSConsts.out_parking_id, order.getOutParkingId());
	    data.put(RSConsts.parking_name, order.getParkingName());
	    data.put(RSConsts.car_number, order.getCarNumber());
	    data.put(RSConsts.out_order_no, order.getOrderNo());
	    data.put(RSConsts.order_status, order.getOrderStatus());
	    data.put(RSConsts.order_time, order.getOrderTime());
	    data.put(RSConsts.order_no, order.getOrderNo());
	    data.put(RSConsts.pay_time, order.getPayTime());
	    data.put(RSConsts.pay_type, order.getPayType());
	    data.put(RSConsts.pay_money, order.getPayMoney());
	    data.put(RSConsts.in_time, order.getInTime());
	    data.put(RSConsts.parking_id, order.getParkingId());
	    data.put(RSConsts.in_duration, order.getInDuration());
	    data.put(RSConsts.card_number, order.getCardNumber());
	    String jsonStr = JSON.toJSONString(data);
      return jsonStr; 
	}


    @Override
    public List<ParkBean> selectAllParkBean(ParkBeanExample example) {
        return parkBeanMapper.selectAllParkBean(example);
    }
	
    
//    public void　updateAppToken(String outParkingId){
//        ParkBean parkBean = this.selectByPrimaryKey(outParkingId);
//        AlipayClient alipayClient = aliPayUtil.getInstance();
//        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
//        request.setBizContent("{" +
//        "    \"grant_type\":\"authorization_code\"," +
//        "    \"refresh_token\":\"1cc19911172e4f8aaa509c8fb5d12F56\"" +
//        "  }");
//        request.putOtherTextParam("app_auth_token", parkBean.getAppAuthToken());
//        AlipayOpenAuthTokenAppResponse response = alipayClient.execute(request);
//    }
    
}

