/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 */
package com.qt.sales.web;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingEnterinfoSyncRequest;
import com.alipay.api.request.AlipayEcoMycarParkingExitinfoSyncRequest;
import com.alipay.api.request.AlipayEcoMycarParkingVehicleQueryRequest;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayEcoMycarParkingEnterinfoSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingExitinfoSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingVehicleQueryResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.qt.sales.common.RSConsts;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBean.PayTypeStatus;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.model.ParkBean;
import com.qt.sales.model.VehicleBean;
import com.qt.sales.model.OrderBean.OrderStatus;
import com.qt.sales.service.OrderBeanService;
import com.qt.sales.service.ParkService;
import com.qt.sales.service.impl.ParkServiceImpl;
import com.qt.sales.utils.DateUtil;
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

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static AlipayClient alipayClient;
	private static final String APP_ID = "2016080700191244";
	private static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbqs+RfKI6CDpQBp87XpBQyrDX/9Rl4hZ0EJncJS0pa0Q+b4k/MHQRR9gNj8nuyBesla1plGPKo8/7Br95MFPNfMUaTd+P6x+1fb3xRn2LFzvQGzt9VgpNuIEDIgGfSJkB8eXFUzpDCacqJiwP6yV9JpfVIqBg2iqMAreeBAs7p53ElmqxIOdvHNPn4mYVl0jnUonYZ6vndN/D74YqgnX/bzvnjoFYhiQ6WjhhBS6/jxFQ2z58KztJSmtRgHPuCcp7es2CVUmHVHtPKdB5TM+3MLaOnZ3VIN9pQFHNzmfK8mFy7QQv7vSibMySsogzW7s4T0bVb64SCaDj1qUOicn5AgMBAAECggEANBu/k+H2pBpw+qzczJDhGkpfXE7FGL3P6lZMSscfEQhZNdU8Siy8DbTQ++kwHYBZfGo2PGtx5Dllu5AMtFKbGuQzTpTWy2RXnvdSh9ui1taWLRmQlmog1Nd4SEYv6NPydBY3ZhBwJlSq4o8YnNOIHxa2KKCIsyMUrv2R3ZFY+USirb1mKGNeg6kfyJZBr2CiHmOObCXddCywjdS07ePqB1NY8XnPGV4rfMGww4We6zDHLRz1eA7k4wsQZyIrHib/GnDsyjT64mrV01BTofN+HcqirhePmGJwoO6CO9OJnzbdzdjEGDmSxoFLPtukIW9opwyaboMB/qP70kbp48cJoQKBgQDWPj/2Ih3M5EZkj/7q77ArjyJYC8lmyJxPbIhwlkiJw50CjmB+Lbfy0iEdOPQG8nqaEc7cMQfOCc7RwcrXfXL6LUsc9lLzr7oY7SqxpepNohkEzXnSQDkgsGgWTxRHkPzSV6BikXCm3AZkDcqtXdK6jW+10N4fCN0CdB2a+bmFPQKBgQC6AeQNGf+XpeQkIG+UMc089MsbJBxlWboxIzn2TGdjGwO4ylDlj20eQjzSj0PvVfa6cGhgpd/N2MVJNGETfFmy58zKQLLO7er+Hm4Jiasu9YG9LoxDE05gO1ccN6/07Ln2xJcU8khPaGRJkg7pdG3V5+99SKdN5vXWigRH36M7bQKBgQDFHDCsu2a/g6ZgDztx22QyL1ZhuzZpIljtmeVN8HZ8iUSDfYq5jEaZWUquICAj5CN4bLntTA7qOYvW4H1HFVwbYGCjHN3k5eBJ3qpRF10iX+i0yncyQXRN5v9cxxTZY0O4InalOTpzyir3EtlN9+xRRp9on+o8k2MDRuGWG/vb4QKBgBVgmkEXN9TJ8Apm3+v8PUZALAeWgtzzDv8OuV6hMVCmjirytZFshnHv0uWwKXKcQpryyEwzRCF4RFRBfNasd/KjyVmFTgeSOGu0O5lFBTOEa8C+VMhws5VDvKM1kzdm7Yh615JEtiLKMJxz+NrD0su+uDuB2hiN7rsVaaCJB02RAoGBAJGgzEsyzaV6YPHb0JIXioBflaBBX+VrGsUZMfb2lCCvpKGFleiD3VfXg4EeBfYnfa0OD0kwiJyhqj6CmugTJr0Yzqv4CrazKTnxc9uqA26OFzqrGkJuHA/cP8GsbQ5oHUj3FslcRnJzFabiq3pNdp+yURevXk73Dg6lJAWVm4ok";
	private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtyoGBcNgmEzskZx8BN8LHTaeH65HHac3g7lsqS2N06Tk1oDpuMw4GMTBEMtDDbycUu76vfOifpf4vco3dyRijEpMAcEObhPR/6XylNf1d1ZHPmyCI8QBX0B6p32kh0KU2G0l//fuPUYyvjkb59kD44OQGmNcdt64ENzL7/HSZjP+DvcvOidwPoOg5xEC9nOJM8/c2Esb2Gn3nq+yrEx5w6Wr3aJyxt39ydcg+4MNxcG0uTveEYBbJuU8WY9euYXB+WjiDMFwmHBL1Td/OlxZfjK78XwwBk+ZI5L9v1K8aP1BWBpgnBFIDJz/Hk3Qq32zgAOkcmHWZHCiFJ/bLu9S5wIDAQAB";
	private static final String sign_type = "RSA2";
	private static final String APP_AUTH_TOKEN = "201710BBb26773c515324b6fb642004cab7d1X63";
	private static final String charset = "UTF-8";
	private static final String SYS_SERVICE_PROVIDER_ID = "2088102170404632";
	// 支付宝沙箱网关
	private static final String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	static String VEHICLE_URL = "https%3a%2f%2fwww.kangguole.com.cn%2fparkAlipayTrade%2falipayPark%2fgetVehicleToken";
	public static String INTERFACE_URL = "https%3a%2f%2fwww.kangguole.com.cn%2fparkAlipayTrade%2falipayPark%2fnotify";
	
	static {
		alipayClient = new DefaultAlipayClient(gatewayUrl, APP_ID, APP_PRIVATE_KEY, "json", charset, ALIPAY_PUBLIC_KEY,
				sign_type);
	}

	
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
	@RequestMapping(value = "/notify", method = RequestMethod.GET)
	public String showList(HttpServletRequest request, Model model) {
		String auth_code = request.getParameter("auth_code");
		String car_id = request.getParameter("car_id");
		String parking_id = request.getParameter("parking_id");
		String source = request.getParameter("source");
		if(!StringUtils.isEmpty(source)){
		    getAPPToken(request,model);
		}else{
		    logger.debug("parking_id="+parking_id);
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
	        AlipayOpenAuthTokenAppResponse response = alipayClient.execute(tokenRequest);
	        System.out.println(response.getBody());
	        if (response.isSuccess()) {
	          // 调用成功
	          ParkBean park = parkService.selectByPrimaryKey(outParkingId);
	          if (!StringUtils.isEmpty(park)) {
	            park.setAppAuthToken(response.getAppAuthToken());
	            park.setExpiresIn(response.getExpiresIn());
	            park.setReExpiresIn(response.getReExpiresIn());
	            park.setRefreshToken(response.getReExpiresIn());
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
	    }
	
	/**
	 * 【方法名】 : (车牌查询). <br/>
	 * 【作者】: yinghui zhang .<br/>
	 * 【时间】： 2017年10月28日 下午9:00:28 .<br/>
	 * 【参数】： .<br/>
	 * @param code
	 * @param app_auth_token
	 * @param car_id
	 *            .<br/>
	 *            <p>
	 *            修改记录.<br/>
	 *            修改人: yinghui zhang 修改描述： .<br/>
	 *            <p/>
	 */
	public void ecoMycarParkingVehicleQueryRequest(String code, String car_id,String parking_id, Model model) {
		AlipaySystemOauthTokenRequest tokenRequest = new AlipaySystemOauthTokenRequest();
		tokenRequest.setGrantType("authorization_code");
		String app_auth_token = (String) ParkServiceImpl.parkingStore.get(parking_id);
		logger.debug("----------store.token = "+app_auth_token);
		//tokenRequest.putOtherTextParam("app_auth_token", app_auth_token);
		// 授权设置
		tokenRequest.setCode(code);
		try {
			// 换取调用
			AlipaySystemOauthTokenResponse response = alipayClient.execute(tokenRequest);
			if (response.isSuccess()) {
			   System.out.println("response="+response.getBody());
				// 调用成功
				String uid = response.getUserId();
				logger.debug("uid="+uid);
				// 取得令牌
				String access_token = response.getAccessToken();
				System.out.println("获取token="+access_token);
				// 通过授权令牌调用获取用户车牌信息接口
				AlipayEcoMycarParkingVehicleQueryRequest requestBiz = new AlipayEcoMycarParkingVehicleQueryRequest();
				
				JSONObject data = new JSONObject();
				data.put("car_id", car_id);
				requestBiz.setBizContent(JSON.toJSONString(data));// 业务数据
				AlipayEcoMycarParkingVehicleQueryResponse responseBiz = alipayClient.execute(requestBiz, access_token);
				// 判断调用是否成功
				if (responseBiz.isSuccess()) {
					System.out.println("responseBiz="+responseBiz.getBody());
					// 获取相应数据
					Map<String, String> responseParams = responseBiz.getParams();
					System.out.println(responseParams.toString());
					String car_number = responseBiz.getCarNumber();
					model.addAttribute("car_number", car_number);
					VehicleBean bean = new VehicleBean();
					bean.setCarId(car_id);
					bean.setParkingId(parking_id);
					bean.setCarNumber(car_number);
					bean.setAuthToken(access_token);
					bean.setUserId(uid);
					//车牌信息进行保存
					parkService.ecoMycarParkingVehicleQuery(bean);
					//创建订单
					OrderBeanExample example = new OrderBeanExample();
					OrderBeanExample.Criteria cr = example.createCriteria();
					cr.andCarNumberEqualTo(car_number);
					cr.andParkingIdEqualTo(parking_id);
					cr.andOrderStatusEqualTo("0");
					List<OrderBean> orderList = orderBeanService.selectByExample(example);
					OrderBean order = null;
					if(orderList!=null && orderList.size()>0){
						order = orderList.get(0);
					}
					if(StringUtils.isEmpty(order)){
						  model.addAttribute("msg", "无此车牌入场记录，请联系管理员！");
					}
					String money = getPayMoney();//调用接口查询费用
					model.addAttribute("outOrderNo", order.getOutOrderNo());
					model.addAttribute("payMoney", money);
					model.addAttribute("parkingName", order.getParkingName());
					String paidMoney = orderBeanService.queryPaidMoneyWithOrderNo(order.getOutOrderNo());
					model.addAttribute("paidMoney", paidMoney);//已付款
					model.addAttribute("discountMoney", order.getDiscountMoney());//优惠金额
					model.addAttribute("inTime", order.getInTime());
					String nowTime =DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
					model.addAttribute("timeDiffer", DateUtil.getTimeDiffer(order.getInTime(), nowTime));
				} else {
					// 调用失败处理逻辑
					System.out.println(responseBiz.getBody());
					 model.addAttribute("msg", "查询车牌异常，请联系管理员！");
				}
			} else {
				// 换取令牌失败逻辑处理
			    model.addAttribute("msg", "查询车牌异常，请联系管理员！");
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	

  public String getPayMoney(){
	  return "20";
  }
	
	
  @RequestMapping(value = "/responseParkAuth/{outParkingId}", method = RequestMethod.GET)
  public String responseParkAuth(HttpServletRequest request, @PathVariable("outParkingId") String outParkingId) {
	    String url = "https://openauth.alipaydev.com/oauth2/appToAppAuth.htm?app_id=" + APP_ID
	            + "&redirect_uri=" + INTERFACE_URL + "&state=" + outParkingId;
    logger.debug(url);
    return "redirect:" + url;
  }
	    
	

	/**
	 * 【方法名】    : (停车场授权). <br/> 
	 * 【作者】: yinghui zhang .<br/>
	 * 【时间】： 2017年11月4日 下午9:30:49 .<br/>
	 * 【参数】： .<br/>
	 * @param request
	 * @param model
	 * @return .<br/>
	 * <p>
	 * 修改记录.<br/>
	 * 修改人:  yinghui zhang 修改描述： .<br/>
	 * <p/>
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
		  AlipayOpenAuthTokenAppResponse response = alipayClient.execute(tokenRequest);
			System.out.println(response.getBody());
			if (response.isSuccess()) {
				// 调用成功
				ParkBean park = parkService.selectByPrimaryKey(outParkingId);
				if (!StringUtils.isEmpty(park)) {
					park.setAppAuthToken(response.getAppAuthToken());
					park.setExpiresIn(response.getExpiresIn());
					park.setReExpiresIn(response.getReExpiresIn());
					park.setRefreshToken(response.getReExpiresIn());
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
	 * 【方法名】    : (停车场设置). <br/> 
	 * 【作者】: yinghui zhang .<br/>
	 * 【时间】： 2017年11月4日 下午9:39:36 .<br/>
	 * 【参数】： .<br/>
	 * @param outParkingId
	 * @return .<br/>
	 * <p>
	 * 修改记录.<br/>
	 * 修改人:  yinghui zhang 修改描述： .<br/>
	 * <p/>
	 */
	@RequestMapping(value = "/parkingConfigSet/{outParkingId}", method = RequestMethod.GET)
	@ResponseBody
	public AjaxReturnInfo parkingConfigSet(@PathVariable("outParkingId") String outParkingId) {
		AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
		try {
			boolean result = parkService.parkingConfigSetRequest(outParkingId);
			if (result) {
				ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
				ajaxinfo.setMessage("添加成功！");
			} else {
				ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
				ajaxinfo.setMessage("添加失败！");
			}
		} catch (Exception e) {
			LogPay.error(e.getMessage(), e);
		}
		return ajaxinfo;
	}

	 /**
   * 【方法名】    : (添加停车场). <br/> 
   * 【作者】: yinghui zhang .<br/>
   * 【时间】： 2017年11月4日 下午9:39:36 .<br/>
   * 【参数】： .<br/>
   * @param outParkingId
   * @return .<br/>
   * <p>
   * 修改记录.<br/>
   * 修改人:  yinghui zhang 修改描述： .<br/>
   * <p/>
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
	 * @return
	 */
    @RequestMapping(value = "/enterinfoSync", method = { RequestMethod.POST })
    @ResponseBody
    public AjaxReturnInfo enterinfoSync(String outParkingId, String carNumber, String carType, String carColor) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        String in_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
        ParkBean bean = parkService.selectByPrimaryKey(outParkingId);
        if (StringUtils.isEmpty(bean.getAppAuthToken())) {
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("未授权！");
            return ajaxinfo;
        }

        OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo(carNumber);
        cr.andOutParkingIdEqualTo(outParkingId);
        cr.andOrderStatusEqualTo("0");
        int count = orderBeanService.countByExample(example);
        if (count > 0) {
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("已有该车辆入场记录，不允许重复入场！");
            return ajaxinfo;
        }

        AlipayEcoMycarParkingEnterinfoSyncRequest request = new AlipayEcoMycarParkingEnterinfoSyncRequest();
        request.setBizContent(enterinfoSyncGetBizContent(bean.getParkingId(), carNumber, in_time));// 业务数据
        request.putOtherTextParam("app_auth_token", bean.getAppAuthToken());
        AlipayEcoMycarParkingEnterinfoSyncResponse response;
        try {
            response = alipayClient.execute(request, APP_AUTH_TOKEN);
            if (response.isSuccess()) {
                parkService.enterinfoSyncEnter(bean, carNumber, in_time, carType, carColor);
                ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
                ajaxinfo.setMessage("调用成功！");
            } else {
                ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
                ajaxinfo.setMessage("调用失败！");
                System.out.println("调用失败");
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
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
	 * 车辆驶出接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ecoMycarParkingExitinfoSync", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxReturnInfo ecoMycarParkingExitinfoSync(@RequestParam(value = "outParkingId") String outParkingId,
			@RequestParam(value = "carNumber") String carNumber) {
		AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
		String out_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
		ParkBean bean = parkService.selectByPrimaryKey(outParkingId);
		if (StringUtils.isEmpty(bean.getAppAuthToken())) {
			ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
			ajaxinfo.setMessage("未授权！");
			return ajaxinfo;
		}
		AlipayEcoMycarParkingExitinfoSyncRequest request = new AlipayEcoMycarParkingExitinfoSyncRequest();
		request.putOtherTextParam("app_auth_token", bean.getAppAuthToken());
		request.setBizContent(ecoMycarParkingExitinfoSyncContent(bean.getParkingId(), carNumber, out_time));// 业务数据
		AlipayEcoMycarParkingExitinfoSyncResponse response;
		try {
			response = alipayClient.execute(request);
			if (response.isSuccess()) {
				ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
				ajaxinfo.setMessage("调用成功！");
				// 车辆驶出
				parkService.ecoMycarParkingExitinfoSync(bean, carNumber, out_time);
				System.out.println("调用成功");
			} else {
				ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
				ajaxinfo.setMessage("调用失败！");
				System.out.println("调用失败");
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return ajaxinfo;
	}

	/**
	 *车辆驶出
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
  * @param model
  *            实体类
  * @return 页面路径
  */
 @RequestMapping(value = "/alipayapi",  method = { RequestMethod.GET, RequestMethod.POST })
 public String alipayapi(Model model) {
     return "alipayPark/alipayapi";
 }
	
  /**
   * 创建订单
   */
  @RequestMapping(value = "/tradeCreate", method = {RequestMethod.POST, RequestMethod.GET})
  @ResponseBody
  public AjaxReturnInfo tradeCreate(String outOrderNo,String payMoney) {
      AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
      try {
          AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
          OrderBean orderBean = orderBeanService.selectByPrimaryKey(outOrderNo);
          if(orderBean==null){
              ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
              ajaxinfo.setMessage("订单流程有错！");
          }
          orderBean.setOrderTime(DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT));
          orderBean.setPayType(PayTypeStatus.onlinePay.getVal());//支付类型
          request.setBizContent(getTradeCreateBizContent(orderBean));
          String app_auth_token = (String) ParkServiceImpl.parkingStore.get(orderBean.getParkingId());
          request.putOtherTextParam("app_auth_token", app_auth_token);
          AlipayTradeCreateResponse response = alipayClient.execute(request);
          if (response.isSuccess()) {
              ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
              ajaxinfo.setMessage(response.getTradeNo());
              //更新订单状态
              orderBean.setOrderNo(response.getTradeNo());
              orderBean.setOrderStatus(OrderStatus.sync.getVal());//同步创建
              orderBeanService.updateByPrimaryKey(orderBean);
              System.out.println("调用成功");
          } else {
              ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
              ajaxinfo.setMessage("订单流程有错！");
              logger.debug("调用失败");
          }
      } catch (AlipayApiException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      return ajaxinfo;
  }

 //创建订单业务数据
 public String getTradeCreateBizContent(OrderBean order){
     JSONObject data = new JSONObject();
     data.put(RSConsts.out_trade_no, order.getOutOrderNo());//商户订单号
     data.put(RSConsts.seller_id, order.getSellerId());//卖家支付宝用户ID
     data.put(RSConsts.total_amount, order.getPayMoney());
//     data.put("discountable_amount", "");// 可打折金额.!
     data.put(RSConsts.subject, order.getParkingName()+"停车费");
     data.put(RSConsts.body, "车牌号码："+order.getCarNumber());
     data.put("buyer_id", order.getUserId());
//     data.put("operator_id", "0001");//商户操作员编号 !
//     data.put("store_id", "10002");//商户门店编号!
//     data.put("terminal_id", "10000");// 商户机具终端编号  !
     
     JSONObject goodsDetail = new JSONObject();
     goodsDetail.put("goods_id", "park01");  //商品的编号
     goodsDetail.put("goods_name", "停车费");//商品名称 
     goodsDetail.put("quantity", "1");//商品数量 
     goodsDetail.put("price", "2000");//商品单价，单位为元 
//     goodsDetail.put("goods_category", "");//商品类目  !
//     goodsDetail.put("body", ""); //商品描述信息 !
//     goodsDetail.put("show_url", "");//商品的展示地址  !
//     data.put("goods_detail", goodsDetail.toJSONString());
     
     JSONObject extend_params = new JSONObject();
     extend_params.put("sys_service_provider_id", SYS_SERVICE_PROVIDER_ID);//系统商编号 
//     extend_params.put("timeout_express", "");!
//     extend_params.put("business_params", "");!
//     data.put("extend_params", extend_params.toJSONString());
     return data.toJSONString();
 }
 
}
