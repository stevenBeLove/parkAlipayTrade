/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 */
package com.qt.sales.web;

import java.util.Map;

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
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipayEcoMycarParkingEnterinfoSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingExitinfoSyncResponse;
import com.alipay.api.response.AlipayEcoMycarParkingVehicleQueryResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.qt.sales.common.RSConsts;
import com.qt.sales.model.ParkBean;
import com.qt.sales.service.ParkService;
import com.qt.sales.service.impl.ParkServiceImpl;
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
		String rand = request.getParameter("rand");
		ecoMycarParkingVehicleQueryRequest(auth_code, car_id, parking_id, model);
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
	public void ecoMycarParkingVehicleQueryRequest(String code, String car_id,String parking_id, Model model) {
		AlipaySystemOauthTokenRequest tokenRequest = new AlipaySystemOauthTokenRequest();
		tokenRequest.setGrantType("authorization_code");
		String app_auth_token = (String) ParkServiceImpl.parkingStore.get(parking_id);
		if (StringUtils.isEmpty(app_auth_token)) {
			model.addAttribute("danger", "请先获得访问授权！");
			return;
		}
		tokenRequest.putOtherTextParam("app_auth_token", app_auth_token);
		// 授权设置
		tokenRequest.setCode(code);
		try {
			// 换取调用
			AlipaySystemOauthTokenResponse response = alipayClient.execute(tokenRequest);
			if (response.isSuccess()) {
				// 调用成功
				String uid = response.getUserId();
				// 取得令牌
				String access_token = response.getAccessToken();
				System.out.println(access_token);
				// 通过授权令牌调用获取用户车牌信息接口
				AlipayEcoMycarParkingVehicleQueryRequest requestBiz = new AlipayEcoMycarParkingVehicleQueryRequest();
				
				JSONObject data = new JSONObject();
				data.put("car_id", car_id);
				requestBiz.setBizContent(JSON.toJSONString(data));// 业务数据
				AlipayEcoMycarParkingVehicleQueryResponse responseBiz = alipayClient.execute(requestBiz, access_token);
				// 判断调用是否成功
				if (responseBiz.isSuccess()) {
					System.out.println(responseBiz.toString());
					// 获取相应数据
					Map<String, String> responseParams = responseBiz.getParams();
					System.out.println(responseParams.toString());
					String car_number = responseBiz.getCarNumber();
					model.addAttribute("car_number", car_number);
					
					//获得车牌业务逻辑
					parkService.ecoMycarParkingVehicleQuery(car_id,parking_id,car_number,access_token);
					
				} else {
					// 调用失败处理逻辑
					System.out.println(responseBiz.getBody());
				}
			} else {
				// 换取令牌失败逻辑处理
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}


	@RequestMapping(value = "/responseCarAuth/{outParkingId}", method = RequestMethod.GET)
	public String responseCarAuth(HttpServletRequest request, @PathVariable("outParkingId") String outParkingId) {
		String url = "https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?app_id=" + APP_ID
				+ "&scope=auth_user&redirect_uri=" + VEHICLE_URL + "&state=" + outParkingId;
		logger.debug(url);
		return "redirect:" + url;
	}

	/**
	 * 获取停车场令牌
	 */
	@RequestMapping(value = "/getVehicleToken", method = RequestMethod.GET)
	public String getVehicleToken(HttpServletRequest request, Model model) {
		String source = request.getParameter("source");
		String scope = request.getParameter("scope");
		String auth_code = request.getParameter("auth_code");
		String outParkingId = request.getParameter("state");
		AlipaySystemOauthTokenRequest tokenRequest = new AlipaySystemOauthTokenRequest();
		tokenRequest.setGrantType("authorization_code");
		// 授权设置
		tokenRequest.setCode(auth_code);
		try {
			// 换取调用
			AlipaySystemOauthTokenResponse response = alipayClient.execute(tokenRequest);
			System.out.println(response.getBody());
			if (response.isSuccess()) {
				// 调用成功
				ParkBean park = parkService.selectByPrimaryKey(outParkingId);
				if (!StringUtils.isEmpty(park)) {
					park.setAppAuthToken(response.getAccessToken());
					park.setExpiresIn(response.getExpiresIn());
					park.setReExpiresIn(response.getReExpiresIn());
					park.setRefreshToken(response.getRefreshToken());
					park.setAlipayUserId(response.getUserId());
					parkService.updateByPrimaryKeySelective(park);
					model.addAttribute("msg", "授权成功!");
					;
				}
			} else {
				// 换取令牌失败逻辑处理
				model.addAttribute("danger", "授权失败，请重试！错误信息：" + response.getBody());
				;

			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return "redirect:/park/parkList";
	}

	/**
	 * 添加停车场
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
	 * 车辆驶入接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/enterinfoSync", method = { RequestMethod.GET, RequestMethod.POST })
	public AjaxReturnInfo enterinfoSync(@RequestParam(value = "parkingId") String parkingId,
			@RequestParam(value = "carNumber") String carNumber, @RequestParam(value = "in_time") String in_time) {
		AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
		String token = (String) ParkServiceImpl.parkingStore.get(parkingId);
		if (StringUtils.isEmpty(token)) {
			ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
			ajaxinfo.setMessage("未授权！");
			return ajaxinfo;
		}
		AlipayEcoMycarParkingEnterinfoSyncRequest request = new AlipayEcoMycarParkingEnterinfoSyncRequest();
		request.setBizContent(enterinfoSyncGetBizContent(parkingId, carNumber, in_time));// 业务数据
		request.putOtherTextParam("app_auth_token", token);
		AlipayEcoMycarParkingEnterinfoSyncResponse response;
		try {
			response = alipayClient.execute(request, APP_AUTH_TOKEN);
			if (response.isSuccess()) {
				parkService.enterinfoSync(parkingId, carNumber, in_time);
				ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
				ajaxinfo.setMessage("调用成功！");
				System.out.println(response.getBody());
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

	// 车辆驶入接口
	public String enterinfoSyncGetBizContent(String parking_id, String car_number, String in_time) {
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
	public AjaxReturnInfo ecoMycarParkingExitinfoSync(@RequestParam(value = "parkingId") String parkingId,
			@RequestParam(value = "carNumber") String carNumber, @RequestParam(value = "out_time") String out_time) {
		AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
		String token = (String) ParkServiceImpl.parkingStore.get(parkingId);
		if (StringUtils.isEmpty(token)) {
			ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
			ajaxinfo.setMessage("未授权！");
			return ajaxinfo;
		}
		AlipayEcoMycarParkingExitinfoSyncRequest request = new AlipayEcoMycarParkingExitinfoSyncRequest();
		request.putOtherTextParam("app_auth_token", token);
		request.setBizContent(ecoMycarParkingExitinfoSyncContent(parkingId, carNumber, out_time));// 业务数据
		AlipayEcoMycarParkingExitinfoSyncResponse response;
		try {
			response = alipayClient.execute(request, APP_AUTH_TOKEN);
			if (response.isSuccess()) {
				ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
				ajaxinfo.setMessage("调用成功！");
				// 车辆驶出
				parkService.ecoMycarParkingExitinfoSync(parkingId, carNumber, out_time);
				System.out.println(response.getBody());
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

	// 车辆驶入接口
	private String ecoMycarParkingExitinfoSyncContent(String parking_id, String car_number, String in_time) {
			JSONObject data = new JSONObject();
			data.put(RSConsts.parking_id, parking_id);
			data.put(RSConsts.car_number, car_number);
			data.put(RSConsts.out_time, in_time);
			String jsonStr = JSON.toJSONString(data);
			return jsonStr;
	}
	
	
	
	
	

}
