/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 */
package com.qt.sales.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigQueryRequest;
import com.alipay.api.request.AlipayEcoMycarParkingEnterinfoSyncRequest;
import com.alipay.api.request.AlipayEcoMycarParkingExitinfoSyncRequest;
import com.alipay.api.request.AlipayEcoMycarParkingOrderPayRequest;
import com.alipay.api.request.AlipayEcoMycarParkingOrderRefundRequest;
import com.alipay.api.request.AlipayEcoMycarParkingOrderSyncRequest;
import com.alipay.api.request.AlipayEcoMycarParkingOrderUpdateRequest;
import com.alipay.api.request.AlipayEcoMycarParkingVehicleQueryRequest;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigQueryResponse;
import com.alipay.api.response.AlipayEcoMycarParkingEnterinfoSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingExitinfoSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingOrderPayResponse;
import com.alipay.api.response.AlipayEcoMycarParkingOrderRefundResponse;
import com.alipay.api.response.AlipayEcoMycarParkingOrderSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingOrderUpdateResponse;
import com.alipay.api.response.AlipayEcoMycarParkingVehicleQueryResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.qt.sales.common.AliPayUtil;
import com.qt.sales.common.PropertiesUtil;
import com.qt.sales.common.RSConsts;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBean.AgreementStatus;
import com.qt.sales.model.OrderBean.OrderPayStatus;
import com.qt.sales.model.OrderBean.OrderStatus;
import com.qt.sales.model.OrderBean.OrderSynStatus;
import com.qt.sales.model.OrderBean.PayTypeStatus;
import com.qt.sales.model.OrderBean.billingTyper;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.model.ParkBean;
import com.qt.sales.service.OrderBeanService;
import com.qt.sales.service.ParkService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.HttpRequestUtil;
import com.qt.sales.utils.LogPay;

/**
 * 类名: AlipayParkController <br/>
 * 作用：停车支付<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2017年10月14日 下午4:39:40 <br/>
 * 版本： JDK 1.6 sharpPark 1.0
 */
@Controller
@RequestMapping("/alipayPark")
public class AlipayParkController {

    protected final Logger   logger        = LoggerFactory.getLogger(this.getClass());

    static String            VEHICLE_URL   = "https%3a%2f%2fwww.kangguole.com.cn%2fparkAlipayTrade%2falipayPark%2fgetVehicleToken";
    public static String     INTERFACE_URL = "https%3a%2f%2fwww.kangguole.com.cn%2fparkAlipayTrade%2falipayPark%2fnotify";
    public static String     NOTIFY_URL    = "https://www.kangguole.com.cn/parkAlipayTrade/parkAlipayTrade/notifyUrl";
    public static String     PARKPRICE_URL    = "https://www.kangguole.com.cn/sharpPark/qeryParkPrice.do";
    
    
    @Resource
    private ParkService      parkService;

    @Resource
    private OrderBeanService orderBeanService;

    @Resource(name = "aliPayUtil")
    private AliPayUtil       aliPayUtil;

    @Resource(name = "propertiesUtil")
    private PropertiesUtil   propertiesUtil;

    /**
     * 跳转到列表页
     * 
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/notify", method = RequestMethod.GET)
    public String showList(HttpServletRequest request, Model model) {
        String auth_code = request.getParameter("auth_code");
        String car_id = request.getParameter("car_id");
        String parking_id = request.getParameter("parking_id");
        String source = request.getParameter("source");
        if (!StringUtils.isEmpty(source)) {
            getAPPToken(request, model);
            return "redirect:/park/parkList";
        } else {
            logger.debug("parking_id=" + parking_id);
            String rand = request.getParameter("rand");
            ecoMycarParkingVehicleQueryRequest(auth_code, car_id, parking_id, model);
        }
        return "alipayPark/orderView";
    }

    public void getAPPToken(HttpServletRequest request, Model model) {
        String source = request.getParameter("source");
        String scope = request.getParameter("scope");
        String auth_code = request.getParameter("app_auth_code");
        String outParkingId = request.getParameter("state");
        AlipayOpenAuthTokenAppRequest tokenRequest = new AlipayOpenAuthTokenAppRequest();
        JSONObject data = new JSONObject();
        data.put("grant_type", "authorization_code");
        data.put("code", auth_code);
        // 授权设置
        tokenRequest.setBizContent(data.toJSONString());
        try {
            // 换取调用
            AlipayClient alipayClient = aliPayUtil.getInstance();
            AlipayOpenAuthTokenAppResponse response = alipayClient.execute(tokenRequest);
            logger.info(response.getBody());
            if (response.isSuccess()) {
                // 调用成功
                ParkBean park = parkService.selectByPrimaryKey(outParkingId);
                if (!StringUtils.isEmpty(park)) {
                    park.setAppAuthToken(response.getAppAuthToken());
                    String expiredate = DateUtil.currentDateAddSeconds(Integer.parseInt(response.getExpiresIn()));
                    park.setExpiresIn(expiredate);
                    String reExpiresIn = DateUtil.currentDateAddSeconds(Integer.parseInt(response.getReExpiresIn()));
                    park.setReExpiresIn(reExpiresIn);
                    park.setRefreshToken(response.getAppRefreshToken());
                    park.setAlipayUserId(response.getUserId());
                    parkService.updateByPrimaryKeySelective(park);
                    model.addAttribute("msg", "授权成功!");
                    System.out.println("授权成功!");
                }
            } else {
                // 换取令牌失败逻辑处理
                model.addAttribute("danger", "授权失败，请重试！错误信息：" + response.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
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
    public void ecoMycarParkingVehicleQueryRequest(String code, String car_id, String parking_id, Model model) {
        AlipaySystemOauthTokenRequest tokenRequest = new AlipaySystemOauthTokenRequest();
        tokenRequest.setGrantType("authorization_code");
        ParkBean parkBean = parkService.selectByPrimaryParkingId(parking_id);
        if(parkBean == null){
        	return;
        }
        String app_auth_token = parkBean.getAppAuthToken();
        logger.debug("store.token = " + app_auth_token);
        // 授权设置
        tokenRequest.setCode(code);
        try {
            // 换取调用
            AlipayClient alipayClient = aliPayUtil.getInstance();
            AlipaySystemOauthTokenResponse response = alipayClient.execute(tokenRequest);
            if (response.isSuccess()) {
                logger.debug("response=" + response.getBody());
                // 调用成功
                String uid = response.getUserId();
                logger.debug("uid=" + uid);
                // 取得令牌
                String access_token = response.getAccessToken();
                logger.debug("获取token=" + access_token);
                // 通过授权令牌调用获取用户车牌信息接口
                AlipayEcoMycarParkingVehicleQueryRequest requestBiz = new AlipayEcoMycarParkingVehicleQueryRequest();
                JSONObject data = new JSONObject();
                data.put(RSConsts.car_id, car_id);
                requestBiz.setBizContent(JSON.toJSONString(data));// 业务数据
                AlipayEcoMycarParkingVehicleQueryResponse responseBiz = alipayClient.execute(requestBiz, access_token);
                // 判断调用是否成功
                if (responseBiz.isSuccess()) {
                    logger.debug("responseBiz=" + responseBiz.getBody());
                    // 获取相应数据
                    Map<String, String> responseParams = responseBiz.getParams();
                    logger.info(responseParams.toString());
                    String car_number = responseBiz.getCarNumber();
                    model.addAttribute(RSConsts.car_number, car_number);

                    // 查询订单
                    OrderBeanExample example = new OrderBeanExample();
                    OrderBeanExample.Criteria cr = example.createCriteria();
                    cr.andCarNumberEqualTo(car_number);
                    cr.andParkingIdEqualTo(parking_id);
                    cr.andStatusEqualTo("0");
                    List<OrderBean> orderList = orderBeanService.selectByExample(example);
                    if (orderList == null || orderList.size() == 0) {
                        model.addAttribute("msg", "无订单生成！");
                        model.addAttribute("status", false);
                        return;
                    }

                    // 首先查询是否存在未付款的订单
                    OrderBean order = null;
                    for (OrderBean orderBean : orderList) {
                        // 有未付款的订单
                        if (OrderSynStatus.create.getVal().equals(orderBean.getOrderSynStatus())) {
                            order = orderBean;
                        }
                    }
                    // 显示订单信息
                    BigDecimal money = getPayMoney(car_number, parkBean.getOutParkingId(), order.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),order.getCarType());// 调用接口查询费用
                    model.addAttribute(RSConsts.orderMoney, money.setScale(2, BigDecimal.ROUND_HALF_DOWN));
                    // 没有找到未付款的订单，找下已经付款的订单
                    if (StringUtils.isEmpty(order)) {
                        boolean haveOrder = false;
                        for (OrderBean orderBean : orderList) {
                            // 找到已经付款的订单
                            if (OrderSynStatus.paysucess.getVal().equals(orderBean.getOrderSynStatus())) {
                                order = orderBean;
                                haveOrder = true;
                            }
                        }
                        if (haveOrder) {
                            // 判断订单的金额是否已经超时产生费用
                            String paidMoney = orderBeanService.queryPaidWithCarNumber(order.getCarNumber());
                            BigDecimal tradePaidMoney = new BigDecimal(paidMoney);
                            if (money.compareTo(tradePaidMoney) == 1) {
                                // 创建未支付订单
                                ParkBean bean = parkService.selectByPrimaryParkingId(parking_id);
                                String in_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
                                String outOrderNo = parkService.enterinfoSyncEnter(bean, order.getOrderTrade(), car_number, in_time, order.getCarType(), order.getCarColor(),
                                        order.getAgreementStatus(), order.getBillingTyper(), order.getCarNumberColor(), order.getLane());
                                OrderBean noPaidOrder = orderBeanService.selectByPrimaryKey(outOrderNo);
                                order = noPaidOrder;
                            }
                        }
                    }

                    if (StringUtils.isEmpty(order)) {
                        model.addAttribute("msg", "无订单生成！");
                        model.addAttribute("status", false);
                        return;
                    }
                    // 更新订单信息
                    order.setUserId(uid);
                    order.setCarId(car_id);
                    orderBeanService.updateByPrimaryKey(order);
                    model.addAttribute("outOrderNo", order.getOutOrderNo());
                    String paidMoney = orderBeanService.queryPaidWithCarNumber(order.getCarNumber());
                    if (!"0".equals(paidMoney)) {
                        BigDecimal paid = new BigDecimal(paidMoney);
                        if (money.compareTo(paid) == 1) {
                            String payResult = money.subtract(paid).floatValue() + "";
                            BigDecimal setScale = new BigDecimal(payResult).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                            model.addAttribute(RSConsts.payMoney, setScale);
                            model.addAttribute(RSConsts.paidMoney, paid.setScale(2, BigDecimal.ROUND_HALF_DOWN));
                        } else if (money.compareTo(paid) == 0) {
                            model.addAttribute(RSConsts.payMoney, RSConsts.zero);
                            model.addAttribute(RSConsts.paidMoney, paid.setScale(2, BigDecimal.ROUND_HALF_DOWN));
                            model.addAttribute(RSConsts.payBtn, false);
                        }
                    } else {
                        BigDecimal setScale = money.setScale(2, BigDecimal.ROUND_HALF_DOWN);
                        model.addAttribute(RSConsts.payMoney, setScale);
                        model.addAttribute(RSConsts.paidMoney, RSConsts.zero);
                    }
                    model.addAttribute(RSConsts.parkingName, parkBean.getParkingName());
                    model.addAttribute(RSConsts.merchantLogo, parkBean.getMerchantLogo());
                    model.addAttribute(RSConsts.discountMoney, getDiscountMoney(car_number, order.getOutParkingId()));// 优惠金额
                    model.addAttribute(RSConsts.inTime, order.getInTime());
                    String nowTime = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
                    model.addAttribute(RSConsts.timeDiffer, DateUtil.getTimeDiffer(order.getInTime(), nowTime));
                    model.addAttribute(RSConsts.inDuration, DateUtil.getTimeDifferMin(order.getInTime(), nowTime));
                    model.addAttribute(RSConsts.orderTime, DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT));
                    model.addAttribute(RSConsts.isvPhone, propertiesUtil.readValue("alipay.isvPhone"));
                    model.addAttribute(RSConsts.isvName, propertiesUtil.readValue("alipay.isvName"));

                } else {
                    // 调用失败处理逻辑
                    logger.error(responseBiz.getBody());
                    model.addAttribute(RSConsts.msg, responseBiz.getSubMsg());
                }
            } else {
                // 换取令牌失败逻辑处理
                model.addAttribute(RSConsts.msg, response.getSubMsg());// "查询车牌异常，请联系管理员！"
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 计费
     * 
     * @param carNumber
     * @param parkingId
     * @return
     */
    public BigDecimal getPayMoney(String carNumber, String parkingId,String inTime, String outTime, String vehicleType) {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("outParkingId", parkingId);//停车场Id
		paramMap.put("inTime", inTime);//进场时间
		paramMap.put("outTime", outTime);//出场时间
		paramMap.put("carNumber", carNumber);//车牌
		paramMap.put("vehicleType", vehicleType);//车类型 车辆类型0.全部 1.小型车2.
		logger.debug("计算车费参数="+paramMap.toString());
        String data = HttpRequestUtil.urlPost(PARKPRICE_URL, paramMap,"utf-8");
        JSONObject json = JSONObject.parseObject(data);
        return new BigDecimal(json.getString("totalPrice"));
    }

    public String getDiscountMoney(String carNumber, String outParkingId) {
        return "0.00";
    }

    @RequestMapping(value = "/responseParkAuth/{outParkingId}", method = RequestMethod.GET)
    public String responseParkAuth(HttpServletRequest request, @PathVariable("outParkingId") String outParkingId) throws IOException {
        String url = "https://openauth.alipay.com/oauth2/appToAppAuth.htm?app_id=" + propertiesUtil.readValue("alipay.app_id") + "&redirect_uri=" + INTERFACE_URL + "&state=" + outParkingId;
        logger.debug(url);
        return "redirect:" + url;
    }

    /**
     * 【方法名】 : (停车场授权). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月4日 下午9:30:49 .<br/>
     * 【参数】： .<br/>
     * 
     * @param request
     * @param model
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/getVehicleToken", method = RequestMethod.GET)
    public String getVehicleToken(HttpServletRequest request, Model model) {
        String source = request.getParameter("source");
        String scope = request.getParameter("scope");
        String auth_code = request.getParameter("auth_code");
        String outParkingId = request.getParameter("state");
        AlipayOpenAuthTokenAppRequest tokenRequest = new AlipayOpenAuthTokenAppRequest();
        JSONObject data = new JSONObject();
        data.put("grant_type", "authorization_code");
        data.put("code", auth_code);
        // 授权设置
        tokenRequest.setBizContent(data.toJSONString());
        try {
            // 换取调用
            AlipayClient alipayClient = aliPayUtil.getInstance();
            AlipayOpenAuthTokenAppResponse response = alipayClient.execute(tokenRequest);
            logger.debug(response.getBody());
            if (response.isSuccess()) {
                // 调用成功
                ParkBean park = parkService.selectByPrimaryKey(outParkingId);
                if (!StringUtils.isEmpty(park)) {
                    park.setAppAuthToken(response.getAppAuthToken());
                    String expiredate = DateUtil.currentDateAddSeconds(Integer.parseInt(response.getExpiresIn()));
                    park.setExpiresIn(expiredate);
                    String reExpiresIn = DateUtil.currentDateAddSeconds(Integer.parseInt(response.getReExpiresIn()));
                    park.setReExpiresIn(reExpiresIn);
                    park.setRefreshToken(response.getAppRefreshToken());
                    park.setAlipayUserId(response.getUserId());
                    parkService.updateByPrimaryKeySelective(park);
                    model.addAttribute("msg", "授权成功!");
                }
            } else {
                // 换取令牌失败逻辑处理
                model.addAttribute("danger", "授权失败，请重试！错误信息：" + response.getBody());

            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "redirect:/park/parkList";
    }

    /**
     * 【方法名】 : (停车场设置). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月4日 下午9:39:36 .<br/>
     * 【参数】： .<br/>
     * 
     * @param outParkingId
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/parkingConfigSet/{outParkingId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxReturnInfo parkingConfigSet(@PathVariable("outParkingId") String outParkingId) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            boolean result = parkService.parkingConfigSetRequest(outParkingId);
            if (result) {
                parkingConfigQuery(outParkingId);
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("设置成功！");
            } else {
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("设置失败！");
            }
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return ajaxinfo;
    }

    /**
     * 更新停车场信息
     * 
     * @return
     */
    @RequestMapping(value = "/parkingConfigQuery", method = { RequestMethod.POST })
    @ResponseBody
    public AjaxReturnInfo parkingConfigQuery(String outParkingId) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        ParkBean parkBean = parkService.selectByPrimaryKey(outParkingId);
        AlipayEcoMycarParkingConfigQueryRequest request = new AlipayEcoMycarParkingConfigQueryRequest();
        request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
        request.setBizContent(getConfigQueryBizContent());// 业务数据
        AlipayEcoMycarParkingConfigQueryResponse response;
        try {
            // 换取调用
            AlipayClient alipayClient = aliPayUtil.getInstance();
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                parkBean.setMerchantLogo(response.getMerchantLogo());
                parkService.updateByPrimaryKeySelective(parkBean);
                logger.debug("调用成功");
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("更新成功！");
            } else {
                logger.debug(response.getBody());
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage(response.getSubMsg());
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("调用失败!");
        }
        return ajaxinfo;
    }

    private String getConfigQueryBizContent() {
        JSONObject data = new JSONObject();
        data.put("interface_name", "alipay.eco.mycar.parking.userpage.query");
        data.put("interface_type", "interface_page");
        String jsonStr = JSON.toJSONString(data);
        System.out.println(jsonStr);
        return jsonStr;
    }

    /**
     * 【方法名】 : (添加停车场). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月4日 下午9:39:36 .<br/>
     * 【参数】： .<br/>
     * 
     * @param outParkingId
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/parkingCreate/{outParkingId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxReturnInfo parkingCreate(@PathVariable("outParkingId") String outParkingId) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            String result = parkService.parkingCreate(outParkingId);
            ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
            ajaxinfo.setMessage(result);
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return ajaxinfo;
    }

    /**
     * 车辆驶入接口-入场-进场
     * 
     * @param outParkingId
     * @param carNumber
     * @param billingType
     *            M：月卡。F:免费。L：临时
     * @param carType
     *            1.小型车2.中型车 3.大型车 4.摩托车 5.其他
     * @param carNumberColor
     *            车牌颜色
     * @param carColor
     *            车辆颜色
     * @param lane
     *            车道
     * @return
     */
    @RequestMapping(value = "/enterinfoSync", method = { RequestMethod.POST })
    @ResponseBody
    public AjaxReturnInfo enterinfoSync(String outParkingId, String carNumber, String billingType, String carType, String carNumberColor, String carColor, String lane) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        String in_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
        ParkBean bean = parkService.selectByPrimaryKey(outParkingId);
        if (!StringUtils.isEmpty(billingType)) {
            if (billingTyper.M.toString().equals(billingType.trim()) || billingTyper.F.toString().equals(billingType.trim())) {
                parkService.enterinfoSyncEnter(bean, "", carNumber, in_time, carType, carColor, "", billingType, carNumberColor, lane);
                ajaxinfo.setCarNumber(carNumber);
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("驶入成功！");
                return ajaxinfo;
            }
        }
        if (StringUtils.isEmpty(bean.getAppAuthToken())) {
            ajaxinfo.setCarNumber(carNumber);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("未授权！");
            return ajaxinfo;
        }

        AlipayEcoMycarParkingEnterinfoSyncRequest request = new AlipayEcoMycarParkingEnterinfoSyncRequest();
        request.setBizContent(enterinfoSyncGetBizContent(bean.getParkingId(), carNumber, in_time));// 业务数据
        request.putOtherTextParam(RSConsts.app_auth_token, bean.getAppAuthToken());
        AlipayEcoMycarParkingEnterinfoSyncResponse response;
        try {
            AlipayClient alipayClient = aliPayUtil.getInstance();
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                parkService.enterinfoSyncEnter(bean, "", carNumber, in_time, carType, carColor, "", billingType, carNumberColor, lane);
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setCarNumber(carNumber);
                ajaxinfo.setMessage("驶入成功");
            } else {
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage(response.getSubMsg());
                logger.debug(response.getBody());
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage(e.getErrMsg());
        }
        return ajaxinfo;
    }

    // 车辆驶入接口
    private String enterinfoSyncGetBizContent(String parking_id, String car_number, String in_time) {
        JSONObject data = new JSONObject();
        data.put(RSConsts.parking_id, parking_id);
        data.put(RSConsts.car_number, car_number);
        data.put(RSConsts.in_time, in_time);
        String jsonStr = JSON.toJSONString(data);
        return jsonStr;
    }

    /**
     * 查询费用（代扣结算） 
     * 
     * @return
     */
    @RequestMapping(value = "/queryCarFee", method = { RequestMethod.POST })
    @ResponseBody
    public AjaxReturnInfo queryCarFee(String outParkingId, String carNumber) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        ajaxinfo.setCarNumber(carNumber);
        ParkBean parkBean = parkService.selectByPrimaryKey(outParkingId);
        if (StringUtils.isEmpty(parkBean.getAppAuthToken())) {
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("未授权！");
            return ajaxinfo;
        }
        OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo(carNumber);
        cr.andOutParkingIdEqualTo(outParkingId);
        cr.andStatusEqualTo("0");
        List<OrderBean> orderList = orderBeanService.selectByExample(example);
        if (orderList == null || orderList.size() == 0) {
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("无该车入场记录，请人工处理！");
            return ajaxinfo;
        }
        // 首先查询是否存在未付款的订单
        OrderBean order = null;
        OrderBean tempOrder = null;
        boolean haveNoPaid = false;
        for (OrderBean orderBean : orderList) {
            // 有未付款的订单
            if (OrderSynStatus.create.getVal().equals(orderBean.getOrderSynStatus())) {
                order = orderBean;
                haveNoPaid = true;
            } else {
                tempOrder = orderBean;
            }
        }
        // 查询的未付款订单为空，已经自助缴费成功的
        if (order == null) {
            // 是否开启免密支付功能
            if (AgreementStatus.agree.getVal().equals(tempOrder.getAgreementStatus())) {
                // 如果查询的订单为空，计算已付费用是否超出已缴纳费用
                BigDecimal money = getPayMoney(carNumber, tempOrder.getOutParkingId(), tempOrder.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),tempOrder.getCarType());// 调用接口查询费用
                // 查询已经付款的车费
                String paidMoney = orderBeanService.queryPaidWithCarNumber(tempOrder.getCarNumber());
                BigDecimal paid = new BigDecimal(paidMoney);
                // 超时订单
                if (money.compareTo(paid) == 1) {
                    // 创建未付款的订单
                    String in_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
                    String outOrderNo = parkService.enterinfoSyncEnter(parkBean, tempOrder.getOrderTrade(), tempOrder.getCarNumber(), in_time, tempOrder.getCarType(), tempOrder.getCarColor(),
                            tempOrder.getAgreementStatus(), tempOrder.getBillingTyper(), tempOrder.getCarNumberColor(), tempOrder.getLane());
                    OrderBean noPaidOrder = orderBeanService.selectByPrimaryKey(outOrderNo);
                    order = noPaidOrder;
                    String payResult = money.subtract(paid).floatValue() + "";
                    BigDecimal payMoneyScale = new BigDecimal(payResult).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    order.setPayMoney(payMoneyScale);
                    String result = autoPay(order, parkBean);
                    if ("0".equals(result)) {
                        ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                        ajaxinfo.setPayMoney(money.toString());
                        ajaxinfo.setOrderNo(order.getOrderNo());
                        ajaxinfo.setMessage("代扣付款成功！");
                        return ajaxinfo;
                    } else {
                        ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                        ajaxinfo.setMessage("代扣失败，请扫码到缴费页面支付！");
                        return ajaxinfo;
                    }
                }
            }
            // 查询已经付款的车费
            String paidMoney = orderBeanService.queryPaidWithCarNumber(carNumber);
            ajaxinfo.setOrderNo(tempOrder.getOrderNo());
            ajaxinfo.setPayMoney(paidMoney);
            ajaxinfo.setPaidMoney(paidMoney);
            ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
            ajaxinfo.setMessage("已支付成功！");
            return ajaxinfo;
        }

        // 月卡或免费用户
        if (haveNoPaid) {
            String billType = order.getBillingTyper();
            if (billingTyper.M.toString().equals(billType)) {
            	ajaxinfo.setPayMoney("0.00");
            	ajaxinfo.setPaidMoney("0.00");
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("月卡车牌！");
                return ajaxinfo;
            } else if (billingTyper.F.toString().equals(billType)) {
            	ajaxinfo.setPayMoney("0.00");
            	ajaxinfo.setPaidMoney("0.00");
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("免费车牌！");
                return ajaxinfo;
            }
        }
        //计算费用为0元的情况
        if (haveNoPaid) {
        	 BigDecimal money = getPayMoney(carNumber, order.getOutParkingId(), order.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),order.getCarType());// 调用接口查询费用
        	 if("0.00".equals(money.toString())|| "0".equals(money.toString()) ){
        		 order.setPayMoney(money);
                 order.setPaidMoney(money);
                 order.setOrderStatus(OrderStatus.sucess.getVal());
                 order.setCardNumber("*");
                 String nowTime = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
                 order.setOrderTime(nowTime);
                 order.setPayType(PayTypeStatus.insteadAlipay.getVal());
                 order.setOrderSynStatus(OrderSynStatus.paysucess.getVal());
                 try {
                     order.setInDuration(DateUtil.getTimeDifferMin(order.getInTime(), nowTime));
                 } catch (ParseException e) {
                     logger.error(e.getMessage(), e);
                 }
                 orderBeanService.updateByPrimaryKeySelective(order);
                 orderBeanService.insertFromOrder(order);
                 ajaxinfo.setPayMoney("0.00");
                 ajaxinfo.setPaidMoney("0.00");
                 ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                 ajaxinfo.setMessage("限时免费车辆！");
                 return ajaxinfo;
        	 }
        }
        // 是否开启免密支付功能
        if (AgreementStatus.agree.getVal().equals(order.getAgreementStatus()) && haveNoPaid) {
            // 使用免密支付自动扣款
            String result = autoOrderPay(order, parkBean, carNumber);
            // 查询已经付款的车费
            String paidMoney = orderBeanService.queryPaidWithCarNumber(carNumber);
            if ("0".equals(result)) {
                ajaxinfo.setPayMoney(paidMoney);
                ajaxinfo.setPaidMoney(paidMoney);
                ajaxinfo.setOrderNo(order.getOrderNo());
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("代扣付款成功！");
                return ajaxinfo;
            } else {
            	 // 如果查询的订单为空，计算已付费用是否超出已缴纳费用
                BigDecimal money = getPayMoney(carNumber, tempOrder.getOutParkingId(), tempOrder.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),tempOrder.getCarType());// 调用接口查询费用
                ajaxinfo.setPayMoney(money.toString());
                ajaxinfo.setPaidMoney(paidMoney);
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("代扣失败，请扫码到缴费页面支付！");
                return ajaxinfo;
            }
        }
        // 手动付款
        if (haveNoPaid) {
        	BigDecimal money = getPayMoney(carNumber, tempOrder.getOutParkingId(), tempOrder.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),tempOrder.getCarType());// 调用接口查询费用
        	// 查询已经付款的车费
            String paidMoney = orderBeanService.queryPaidWithCarNumber(carNumber);
        	ajaxinfo.setPayMoney(money.toString());
            ajaxinfo.setPaidMoney(paidMoney);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("代扣状态未开启,请扫码到缴费页面支付！");
            return ajaxinfo;
        } else {
            // 显示订单信息
            BigDecimal money = getPayMoney(carNumber, order.getOutParkingId(), order.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),order.getCarType());// 调用接口查询费用;// 调用接口查询费用
            // 判断订单的金额是否已经超时产生费用
            String paidMoney = orderBeanService.queryPaidWithCarNumber(order.getCarNumber());
            BigDecimal tradePaidMoney = new BigDecimal(paidMoney);
            if (money.compareTo(tradePaidMoney) == 1) {
                // 创建未支付订单
                ParkBean bean = parkService.selectByPrimaryParkingId(order.getParkingId());
                String in_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
                parkService.enterinfoSyncEnter(bean, order.getOrderTrade(), order.getCarNumber(), in_time, order.getCarType(), order.getCarColor(), order.getAgreementStatus(),
                        order.getBillingTyper(), order.getCarNumberColor(), order.getLane());
                ajaxinfo.setPayMoney(money.toString());
                ajaxinfo.setPaidMoney(paidMoney);
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("存在超时订单未付款，请付款！");
                return ajaxinfo;
            }
        }
        // 查询已经付款的车费
        String paidMoney = orderBeanService.queryPaidWithCarNumber(carNumber);
        ajaxinfo.setPayMoney(paidMoney);
        ajaxinfo.setPaidMoney(paidMoney);
        ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
        ajaxinfo.setMessage("已支付成功！");
        return ajaxinfo;
    }

    /**
     * 车辆驶出接口
     * 
     * @return
     */
    @RequestMapping(value = "/ecoMycarParkingExitinfoSync", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public AjaxReturnInfo ecoMycarParkingExitinfoSync(String outParkingId, String carNumber) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        ParkBean parkBean = parkService.selectByPrimaryKey(outParkingId);
        OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo(carNumber);
        cr.andOutParkingIdEqualTo(outParkingId);
        cr.andStatusEqualTo("0");
        List<OrderBean> orderList = orderBeanService.selectByExample(example);
        // 驶出时间
        String out_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
        for (OrderBean orderBean : orderList) {
            String billType = orderBean.getBillingTyper();
            boolean bill = false;
            // 判断是否为免费车辆
            if (billingTyper.M.toString().equals(billType) || billingTyper.F.toString().equals(billType)) {
                // 更新车辆驶出订单
                orderBean.setOutTime(out_time);
                // 更新订单
                orderBeanService.updateOrderPayByOrderNo(orderBean);
                // 添加订单
                orderBean.setBillingTyper(billType);
                orderBeanService.insertFromOrder(orderBean);
                // 删除订单
                orderBeanService.deleteWithOrderTrade(orderBean.getOrderTrade());
                bill = true;
            }
            //限时免费车辆
            if ("0.00".equals(orderBean.getPaidMoney().toString())||"0".equals(orderBean.getPaidMoney().toString())) {
                // 更新车辆驶出订单
                orderBean.setOutTime(out_time);
                // 更新订单
                orderBeanService.updateOrderPayByOrderNo(orderBean);
                // 添加订单
                orderBean.setBillingTyper(billingTyper.F.toString());
                orderBeanService.insertFromOrder(orderBean);
                // 删除订单
                orderBeanService.deleteWithOrderTrade(orderBean.getOrderTrade());
                bill = true;
            }
            if (bill) {
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("驶出成功！");
                return ajaxinfo;
            }
            if (OrderSynStatus.create.getVal().equals(orderBean.getOrderSynStatus())) {
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("亲！您还有未付款的订单！");
                return ajaxinfo;
            }
        }
        AlipayEcoMycarParkingExitinfoSyncRequest request = new AlipayEcoMycarParkingExitinfoSyncRequest();
        request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
        request.setBizContent(ecoMycarParkingExitinfoSyncContent(parkBean.getParkingId(), carNumber, out_time));// 业务数据
        AlipayEcoMycarParkingExitinfoSyncResponse response;
        try {
            AlipayClient alipayClient = aliPayUtil.getInstance();
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                for (OrderBean orderBean : orderList) {
                    // 更新车辆驶出订单
                    orderBean.setOutTime(out_time);
                    // 同步订单
                    oderSyncSuccess(orderBean);
                    // 更新订单
                    orderBeanService.updateOrderPayByOrderNo(orderBean);
                    // 删除订单
                    orderBeanService.deleteWithOrderTrade(orderBean.getOrderTrade());
                }
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("驶出成功");
            } else {
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage(response.getSubMsg());
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("调用失败！");
        } catch (QTException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage(e.getRespMsg());
        }
        return ajaxinfo;
    }

    /**
     * 无感支付
     * 
     * @param order
     * @param parkBean
     * @return
     */
    public String autoPay(OrderBean order, ParkBean parkBean) {
        String result = "1";
        try {
            AlipayEcoMycarParkingOrderPayRequest request = new AlipayEcoMycarParkingOrderPayRequest();
            request.setBizContent(orderPayBiz(order));
            request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
            AlipayClient alipayClient = aliPayUtil.getInstance();
            AlipayEcoMycarParkingOrderPayResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                String trade_no = response.getTradeNo();
                String user_id = response.getUserId();
                // 该笔交易的买家付款时间
                String gmt_payment = response.getGmtPayment();
                order.setOrderNo(trade_no);
                order.setUserId(user_id);
                order.setPayTime(gmt_payment);
                order.setPaidMoney(order.getPayMoney());
                order.setOrderStatus(OrderStatus.sucess.getVal());
                order.setCardNumber("*");
                order.setOrderTime(gmt_payment);
                order.setPayType(PayTypeStatus.insteadAlipay.getVal());
                order.setOrderSynStatus(OrderSynStatus.paysucess.getVal());
                try {
                    order.setInDuration(DateUtil.getTimeDifferMin(order.getInTime(), gmt_payment));
                } catch (ParseException e) {
                    logger.error(e.getMessage(), e);
                }
                orderBeanService.updateByPrimaryKeySelective(order);
                orderBeanService.insertFromOrder(order);
                logger.debug("调用自动扣款成功");
                result = "0";
            } else {
                logger.debug(response.getBody());
                result = response.getSubMsg();
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            result = "1";
        } catch (IOException e1) {
            logger.error(e1.getMessage(), e1);
            result = "1";
        }
        return result;
    }

    /**
     * 无感支付
     * 
     * @param order
     * @param parkBean
     * @param carNumber
     * @return
     */
    public String autoOrderPay(OrderBean order, ParkBean parkBean, String carNumber) {
        String result = "1";
        // 计算停车费用
        BigDecimal money = getPayMoney(carNumber, order.getOutParkingId(), order.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),order.getCarType());// 调用接口查询费用;// 调用接口查询费用
        // 查询已经付款的车费
        String paidMoney = orderBeanService.queryPaidWithCarNumber(order.getCarNumber());
        BigDecimal paid = new BigDecimal(paidMoney);
        if ("0".equals(paidMoney)) {
            order.setPayMoney(money);
        } else {
            if (money.compareTo(paid) == 1) {// 计算的停车费用大于已经付款的费用
                String payResult = money.subtract(paid).floatValue() + "";
                BigDecimal setScale = new BigDecimal(payResult).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                order.setPayMoney(setScale);
            } else {
                order.setPayMoney(money);
            }
        }
        try {
            AlipayEcoMycarParkingOrderPayRequest request = new AlipayEcoMycarParkingOrderPayRequest();
            request.setBizContent(orderPayBiz(order));
            request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
            AlipayClient alipayClient = aliPayUtil.getInstance();
            AlipayEcoMycarParkingOrderPayResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                String trade_no = response.getTradeNo();
                String user_id = response.getUserId();
                // 该笔交易的买家付款时间
                String gmt_payment = response.getGmtPayment();
                order.setOrderNo(trade_no);
                order.setUserId(user_id);
                order.setPayTime(gmt_payment);
                order.setPaidMoney(order.getPayMoney());
                order.setOrderStatus(OrderStatus.sucess.getVal());
                order.setCardNumber("*");
                order.setOrderTime(gmt_payment);
                order.setPayType(PayTypeStatus.insteadAlipay.getVal());
                order.setOrderSynStatus(OrderSynStatus.paysucess.getVal());
                try {
                    order.setInDuration(DateUtil.getTimeDifferMin(order.getInTime(), gmt_payment));
                } catch (ParseException e) {
                    logger.error(e.getMessage(), e);
                }
                orderBeanService.updateByPrimaryKeySelective(order);
                orderBeanService.insertFromOrder(order);
                logger.debug("调用自动扣款成功");
                result = "0";
            } else {
                logger.debug(response.getBody());
                result = response.getSubMsg();
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            result = "1";
        } catch (IOException e1) {
            logger.error(e1.getMessage(), e1);
            result = "1";
        }
        return result;
    }

    /**
     * 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月24日 下午1:37:04 .<br/>
     * 【参数】： .<br/>
     * 
     * @param order
     * @return .<br/>
     *         <p>
     *         1 selle_id 改为必填项 2 parking_id 改为必填项 3 out_parking_id 改为必填项 4
     *         修改out_trade_no字段长度为32（原值64，但是超人只支持32） 5 出参增加user_id 修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     * @throws IOException
     */
    // 自动扣款业务参数
    public String orderPayBiz(OrderBean order) throws IOException {
        JSONObject data = new JSONObject();
        data.put(RSConsts.car_number, order.getCarNumber());
        data.put(RSConsts.out_trade_no, order.getOutOrderNo());
        data.put(RSConsts.subject, propertiesUtil.readValue("alipay.isvName") + "代扣缴费");
        data.put(RSConsts.total_fee, order.getPayMoney().setScale(2, BigDecimal.ROUND_HALF_DOWN));// 交易金额保留小数点后两位
        // data.put(RSConsts.seller_logon_id,);
        data.put(RSConsts.seller_id, order.getSellerId());
        data.put(RSConsts.parking_id, order.getParkingId());
        data.put(RSConsts.out_parking_id, order.getOutParkingId());
        data.put(RSConsts.agent_id, propertiesUtil.readValue("alipay.isvPid"));// 代扣
        data.put(RSConsts.car_number_color, order.getCarNumberColor());// 车牌颜色
        return data.toJSONString();
    }

    private void oderSyncSuccess(OrderBean orderBean) throws QTException, AlipayApiException {
        AlipayEcoMycarParkingOrderSyncRequest request = new AlipayEcoMycarParkingOrderSyncRequest();
        request.setBizContent(getEcoMycarParkingOrderBizContent(orderBean));
        ParkBean parkBean = parkService.selectByPrimaryParkingId(orderBean.getParkingId());
        request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());

        AlipayClient alipayClient = aliPayUtil.getInstance();
        AlipayEcoMycarParkingOrderSyncResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            logger.debug("调用成功");
            orderBeanService.updateByPrimaryKeySelective(orderBean);
        } else {
            logger.debug("同步订单失败");
            throw new QTException(response.getSubMsg());
        }
    }

    // 同步订单业务数据
    public String getEcoMycarParkingOrderBizContent(OrderBean order) {
        JSONObject data = new JSONObject();
        data.put(RSConsts.user_id, order.getUserId());
        data.put(RSConsts.out_parking_id, order.getOutParkingId());
        try {
            data.put(RSConsts.parking_name, propertiesUtil.readValue("alipay.isvName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        data.put(RSConsts.car_number, order.getCarNumber());
        data.put(RSConsts.out_order_no, order.getOutOrderNo());
        data.put(RSConsts.order_status, order.getOrderStatus());
        data.put(RSConsts.order_time, order.getOrderTime());
        data.put(RSConsts.order_no, order.getOrderNo());
        data.put(RSConsts.pay_time, order.getPayTime());
        data.put(RSConsts.pay_type, order.getPayType());
        data.put(RSConsts.pay_money, order.getPaidMoney());
        data.put(RSConsts.in_time, order.getInTime());
        data.put(RSConsts.parking_id, order.getParkingId());
        data.put(RSConsts.in_duration, order.getInDuration());
        data.put(RSConsts.card_number, order.getCardNumber());
        logger.debug("同步订单：" + data.toJSONString());
        return data.toJSONString();
    }

    /**
     * 车辆驶出
     * 
     * @param parking_id
     * @param car_number
     * @param in_time
     * @return
     */
    private String ecoMycarParkingExitinfoSyncContent(String parking_id, String car_number, String in_time) {
        JSONObject data = new JSONObject();
        data.put(RSConsts.parking_id, parking_id);
        data.put(RSConsts.car_number, car_number);
        data.put(RSConsts.out_time, in_time);
        String jsonStr = JSON.toJSONString(data);
        return jsonStr;
    }

    /**
     * 跳转到列表页
     * 
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/orderView", method = { RequestMethod.GET, RequestMethod.POST })
    public String orderView(Model model) {
        return "alipayPark/orderView";
    }

    /**
     * 跳转到列表页
     * 
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/alipayapi", method = { RequestMethod.GET, RequestMethod.POST })
    public String alipayapi(Model model) {
        return "alipayPark/alipayapi";
    }

    /**
     * 创建订单
     * 
     * @throws ParseException
     * 
     */
    @RequestMapping(value = "/tradeCreate", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public AjaxReturnInfo tradeCreate(String outOrderNo, String payMoney, String inDuration, String orderTime, String discountMoney) throws ParseException {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
            OrderBean orderBean = orderBeanService.selectByPrimaryKey(outOrderNo);
            if (orderBean == null) {
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("订单流程有错！");
                return ajaxinfo;
            }
            orderBean.setOrderTime(orderTime);
            orderBean.setPayType(PayTypeStatus.onlinePay.getVal());// 支付类型
            request.setBizContent(getTradeCreateBizContent(orderBean, payMoney));
            ParkBean parkBean = parkService.selectByPrimaryParkingId(orderBean.getParkingId());
            request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
            request.putOtherTextParam(RSConsts.notify_url, NOTIFY_URL);
            request.setNotifyUrl(NOTIFY_URL);
            AlipayClient alipayClient = aliPayUtil.getInstance();
            AlipayTradeCreateResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage(response.getTradeNo());
                // 更新订单状态
                BigDecimal pay = new BigDecimal(payMoney);
                BigDecimal setScale = pay.setScale(2, BigDecimal.ROUND_HALF_DOWN);
                orderBean.setPayMoney(setScale);
                orderBean.setInDuration(inDuration);// 停车时长
                orderBean.setOrderNo(response.getTradeNo());// 支付宝流水号
                orderBean.setOrderSynStatus(OrderSynStatus.create.getVal());// 同步创建
                orderBean.setDiscountMoney(new BigDecimal(discountMoney));// 优惠金额
                orderBeanService.updateByPrimaryKeySelective(orderBean);
                logger.debug("调用成功");
            } else {
                if (RSConsts.TRADE_HAS_SUCCESS.equals(response.getSubCode())) {// 订单已经支付
                    logger.debug("--订单已经支付---");
                	String nowTime = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
                    orderBean.setPayTime(nowTime);
                    orderBean.setOrderStatus(OrderStatus.sucess.getVal());
                    orderBean.setCardNumber("*");
                    orderBean.setOrderSynStatus(OrderSynStatus.paysucess.getVal());
                    orderBean.setInDuration(DateUtil.getTimeDifferMin(orderBean.getInTime(), nowTime));
                    orderBean.setPaidMoney(orderBean.getPayMoney());// 已支付
                    int payOrderCount = orderBeanService.queryOrderPayCountByOrderNo(outOrderNo).intValue();
                    if(payOrderCount == 0){
                    	 orderBeanService.updateByPrimaryKeySelective(orderBean);
                         orderBeanService.insertFromOrder(orderBean);
                    }
                }
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage(response.getSubMsg());
                return ajaxinfo;
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("创建同步创建失败!");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("创建同步创建失败!");
        }
        return ajaxinfo;
    }

    // 创建订单业务数据
    public String getTradeCreateBizContent(OrderBean order, String payMoney) throws IOException {
        JSONObject data = new JSONObject();
        data.put(RSConsts.out_trade_no, order.getOutOrderNo());// 商户订单号
        data.put(RSConsts.seller_id, order.getSellerId());// 卖家支付宝用户ID
        data.put(RSConsts.total_amount, payMoney);
        // data.put("discountable_amount", "");// 可打折金额.!
        // data.put(RSConsts.subject, order.getParkingName()+"停车费");
        data.put(RSConsts.subject, propertiesUtil.readValue("alipay.isvName") + "停车费");
        data.put(RSConsts.body, "车牌号码：" + order.getCarNumber());
        data.put(RSConsts.buyer_id, order.getUserId());
        // data.put("operator_id", "0001");//商户操作员编号 !
        // data.put("store_id", "10002");//商户门店编号!
        // data.put("terminal_id", "10000");// 商户机具终端编号 !

        JSONObject goodsDetail = new JSONObject();
        goodsDetail.put("goods_id", "park01"); // 商品的编号
        goodsDetail.put("goods_name", "停车费");// 商品名称
        goodsDetail.put("quantity", "1");// 商品数量
        goodsDetail.put("price", "2000");// 商品单价，单位为元
        // goodsDetail.put("goods_category", "");//商品类目 !
        // goodsDetail.put("body", ""); //商品描述信息 !
        // goodsDetail.put("show_url", "");//商品的展示地址 !
        // data.put("goods_detail", goodsDetail.toJSONString());

        JSONObject extend_params = new JSONObject();
        extend_params.put(RSConsts.sys_service_provider_id, propertiesUtil.readValue("alipay.isvPid"));// 系统商编号
        data.put(RSConsts.extend_params, JSONObject.toJSON(extend_params));
        data.put(RSConsts.timeout_express, "90m");
        // data.put(RSConsts.business_params, "");
        logger.debug("创建订单数据：" + data.toJSONString());
        return data.toJSONString();
    }

    /**
     * 订单退款
     * 
     * @return 页面路径
     */
    @RequestMapping(value = "/tradeRefund", method = RequestMethod.POST)
    @ResponseBody
    public AjaxReturnInfo tradeRefund(String tradeNO) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            OrderBean orderBean = orderBeanService.selectPayOrderByOrderNo(tradeNO);
            if (orderBean == null) {
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("无此订单");
                return ajaxinfo;
            }
            if (PayTypeStatus.onlinePay.getVal().equals(orderBean.getPayType())) {
                ajaxinfo = tradeRefundRequest(orderBean);
            } else {
                ajaxinfo = tradeOrderRefund(orderBean);
            }
        } catch (QTException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage(e.getMessage());
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage(e.getMessage());
        }
        return ajaxinfo;
    }

    /**
     * 【方法名】 : (普通退款). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月24日 下午10:35:13 .<br/>
     * 【参数】： .<br/>
     * 
     * @param orderBean
     * @throws AlipayApiException
     * @throws QTException .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    private AjaxReturnInfo tradeRefundRequest(OrderBean orderBean) throws AlipayApiException, QTException {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(getTradeRefundBizContent(orderBean));
        ParkBean parkBean = parkService.selectByPrimaryParkingId(orderBean.getParkingId());
        request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
        AlipayClient alipayClient = aliPayUtil.getInstance();
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            orderBean.setOrderStatus(OrderStatus.refund.getVal());
            orderBean.setOrderPayStatus(OrderPayStatus.refund.getVal());
            orderUpdate(orderBean);
            orderBeanService.updateOrderPayByOrderNo(orderBean);
            ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
            ajaxinfo.setMessage("退款成功!");
        } else {
            orderBean.setOrderPayStatus(OrderPayStatus.refundFailed.getVal());
            orderBeanService.updateOrderPayByOrderNo(orderBean);
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage(response.getSubMsg());
        }
        return ajaxinfo;
    }

    /**
     * 更新订单状态
     * 
     * @param order
     * @throws AlipayApiException
     * @throws QTException
     */
    public void orderUpdate(OrderBean order) throws AlipayApiException, QTException {
        AlipayEcoMycarParkingOrderUpdateRequest request = new AlipayEcoMycarParkingOrderUpdateRequest();
        ParkBean parkBean = parkService.selectByPrimaryParkingId(order.getParkingId());
        request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
        request.setBizContent(getOrderUpdateBiz(order));
        AlipayClient alipayClient = aliPayUtil.getInstance();
        AlipayEcoMycarParkingOrderUpdateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            logger.info("调用更新订单成功");
            // order.setOrderPayStatus(OrderPayStatus.refund.getVal());
            // orderBeanService.updateByPrimaryKeySelective(order);
        } else {
            // order.setOrderPayStatus(OrderPayStatus.refundFailed.getVal());
            // orderBeanService.updateByPrimaryKeySelective(order);
            throw new QTException("调用更新订单失败");
        }
    }

    public String getOrderUpdateBiz(OrderBean order) {
        JSONObject data = new JSONObject();
        data.put(RSConsts.user_id, order.getUserId());
        data.put(RSConsts.order_no, order.getOrderNo());
        data.put(RSConsts.order_status, OrderStatus.failed.getVal());
        return data.toJSONString();
    }

    /***
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月24日 下午8:42:22 .<br/>
     * 【参数】： .<br/>
     * .<br/>
     * <p>
     * 无感支付退款 修改记录.<br/>
     * 修改人: yinghui zhang 修改描述： .<br/>
     * <p/>
     * 
     * @throws QTException
     */
    private AjaxReturnInfo tradeOrderRefund(OrderBean order) throws QTException {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            AlipayEcoMycarParkingOrderRefundRequest request = new AlipayEcoMycarParkingOrderRefundRequest();
            String out_refund_no = "T" + DateUtil.getCurrDateAndTime() + new Random().nextInt(100);
            order.setOutRefundNo(out_refund_no);
            request.setBizContent(getTradeOrderRefundBiz(order));
            ParkBean parkBean = parkService.selectByPrimaryParkingId(order.getParkingId());
            request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
            AlipayClient alipayClient = aliPayUtil.getInstance();
            AlipayEcoMycarParkingOrderRefundResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                logger.info("调用成功");
                order.setOrderStatus(OrderStatus.refund.getVal());
                order.setOutRefundNo(response.getOutRefundNo());
                order.setOrderPayStatus(OrderPayStatus.refund.getVal());
                orderBeanService.updateOrderPayByOrderNo(order);
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("退款成功");
            } else {
                logger.debug(response.getSubMsg());
                logger.info("调用失败");
                order.setOutRefundNo(response.getOutRefundNo());
                order.setOrderPayStatus(OrderPayStatus.refundFailed.getVal());
                orderBeanService.updateOrderPayByOrderNo(order);
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage(response.getSubMsg());
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
            throw new QTException(e.getMessage());
        }
        return ajaxinfo;
    }

    private String getTradeOrderRefundBiz(OrderBean order) {
        JSONObject data = new JSONObject();
        data.put(RSConsts.order_no, order.getOrderNo());
        data.put(RSConsts.out_order_no, order.getOutOrderNo());
        data.put(RSConsts.out_refund_no, order.getOutRefundNo());
        data.put(RSConsts.refund_fee, order.getPaidMoney().setScale(2, BigDecimal.ROUND_HALF_DOWN));
        // data.put(RSConsts.refund_reason, "");
        return data.toJSONString();
    }

    // 创建订单业务数据
    public String getTradeRefundBizContent(OrderBean order) {
        JSONObject data = new JSONObject();
        // data.put(RSConsts.out_trade_no, order.getOutOrderNo());//商户订单号
        // 订单支付时传入的商户订单号,不能和 trade_no同时为空
        data.put(RSConsts.trade_no, order.getOrderNo());
        data.put(RSConsts.refund_amount, order.getPaidMoney());
        data.put(RSConsts.refund_reason, RSConsts.refund_reason_des);
        // data.put(RSConsts.out_request_no, "");
        // //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
        // data.put(RSConsts.operator_id, );//商户的操作员编号
        // data.put(RSConsts.store_id, );//商户的门店编号
        // data.put(RSConsts.terminal_id, );//商户的终端编号
        return data.toJSONString();
    }


    // 展现页
    @RequestMapping(value = "/payView", method = RequestMethod.GET)
    public String payView(Model model) {
        return "alipayPark/orderView_ali";
    }

    // 结果页面
    @RequestMapping(value = "/payResultDemo", method = RequestMethod.GET)
    public String payResultDemo(Model model) {
        return "alipayPark/payResultDemo";
    }

    /**
     * 【方法名】 : (更改订单|纠正车牌). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年12月6日 下午5:01:15 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/modifyCarNumber", method = { RequestMethod.POST })
    @ResponseBody
    public AjaxReturnInfo modifyCarNumber(String outParkingId, String mistakeCarNumber, String correctCarNumber, String billingType) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo(mistakeCarNumber);
        cr.andOutParkingIdEqualTo(outParkingId);
        List<OrderBean> orderList = orderBeanService.selectByExample(example);
        if (orderList == null || orderList.size() == 0) {
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("无该车入场记录，无法修正！");
            return ajaxinfo;
        }
        if (orderList.size() > 1) {
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("入场记录大于1条，请人工处理！");
            return ajaxinfo;
        }
        // 重新驶入
        OrderBean orderBean = orderList.get(0);
        if (billingTyper.M.toString().equals(billingType) || billingTyper.F.toString().equals(billingType)) {
            orderBean.setCarNumber(correctCarNumber);
            orderBeanService.updateByPrimaryKey(orderBean);
            ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
            ajaxinfo.setMessage("矫正车牌成功");
            return ajaxinfo;
        }

        if (OrderSynStatus.create.getVal().equals(orderBean.getOrderSynStatus())) {
            ParkBean parkBean = parkService.selectByPrimaryParkingId(orderBean.getParkingId());
            String app_auth_token = parkBean.getAppAuthToken();
            logger.debug("store.token = " + app_auth_token);
            AlipayEcoMycarParkingEnterinfoSyncRequest request = new AlipayEcoMycarParkingEnterinfoSyncRequest();
            request.setBizContent(enterinfoSyncGetBizContent(orderBean.getParkingId(), correctCarNumber, orderBean.getInTime()));
            request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
            AlipayEcoMycarParkingEnterinfoSyncResponse response;
            try {
                AlipayClient alipayClient = aliPayUtil.getInstance();
                response = alipayClient.execute(request);
                if (response.isSuccess()) {
                    String agreement = parkService.agreementQueryRequest(correctCarNumber, parkBean.getAppAuthToken());
                    orderBean.setAgreementStatus(agreement);
                    orderBean.setCarNumber(correctCarNumber);
                    orderBeanService.updateByPrimaryKey(orderBean);
                    exitAliPark(parkBean, mistakeCarNumber);
                    ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                    ajaxinfo.setMessage("矫正车牌成功");
                } else {
                    ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                    ajaxinfo.setMessage(response.getSubMsg());
                    logger.debug(response.getBody());
                }
            } catch (AlipayApiException e) {
                logger.error(e.getMessage(), e);
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage(e.getErrMsg());
            } catch (QTException e) {
                logger.error(e.getMessage(), e);
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("纠正出错，请联系后台人员!");
            }

        }
        return ajaxinfo;
    }

    /*
     * 驶出阿里停车场 出场
     */
    public void exitAliPark(ParkBean parkBean, String odlCarNumber) {
        AlipayEcoMycarParkingExitinfoSyncRequest request = new AlipayEcoMycarParkingExitinfoSyncRequest();
        request.putOtherTextParam(RSConsts.app_auth_token, parkBean.getAppAuthToken());
        String out_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
        request.setBizContent(ecoMycarParkingExitinfoSyncContent(parkBean.getParkingId(), odlCarNumber, out_time));// 业务数据
        AlipayEcoMycarParkingExitinfoSyncResponse response;
        try {
            AlipayClient alipayClient = aliPayUtil.getInstance();
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                logger.debug("识别出错车牌驶出成功!");
            } else {
                logger.debug(response.getSubMsg());
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(), e);
        }

    }

}
