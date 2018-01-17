/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 */
package com.qt.sales.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.qt.sales.common.AliPayUtil;
import com.qt.sales.common.PropertiesUtil;
import com.qt.sales.common.RSConsts;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBean.OrderPayStatus;
import com.qt.sales.model.OrderBean.OrderStatus;
import com.qt.sales.model.OrderBean.OrderSynStatus;
import com.qt.sales.model.OrderBean.billingTyper;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.model.ParkBean;
import com.qt.sales.service.OrderBeanService;
import com.qt.sales.service.ParkService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.HttpRequestUtil;
import com.qt.sales.utils.LogUtil;
import com.qt.sales.utils.RequestUtil;

/**
 * 类名: AlipayParkController <br/>
 * 作用：停车支付<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2017年10月14日 下午4:39:40 <br/>
 * 版本： JDK 1.6 sharpPark 1.0
 */
@Controller
@RequestMapping("/parkAlipayTrade")
public class AlipayNotifyController {

    @Resource
    private OrderBeanService orderBeanService;

    @Resource(name = "aliPayUtil")
    private AliPayUtil       aliPayUtil;

    @Resource(name = "propertiesUtil")
    private PropertiesUtil   propertiesUtil;
    
    @Resource
    private ParkService      parkService;
    
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 自动代扣关闭
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/agreementNotify", method = { RequestMethod.POST, RequestMethod.GET })
    public void agreementNotify(HttpServletRequest request, HttpServletResponse response) {
		// 支付宝响应消息
		String responseMsg = "";
		// 1. 解析请求参数
		Map<String, String> params = RequestUtil.getRequestParams(request);
		try {
			if (params == null || "".equals(params.toString()) || params.isEmpty()) {
				String code = "10000";
				String msg = "success";
				String econotify = "success";
				responseMsg = buildBaseAckMsg(code, msg, econotify);
			} else {
				// 打印本次请求日志，开发者自行决定是否需要
				logger.debug("支付宝请求串:" + params.toString());

				// 2. 验证签名
				this.verifySign(params);
				orderBeanService.updateAgreementNotify(params);
				String code = "10000";
				String msg = "success";
				String econotify = "success";
				responseMsg = buildBaseAckMsg(code, msg, econotify);
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5. 响应结果加签及返回
			try {
				// http 内容应答
				response.reset();
				response.setContentType("text/xml;charset=GBK");
				PrintWriter printWriter = response.getWriter();
				printWriter.print(responseMsg);
				logger.debug("响应请求串:" + responseMsg.toString());
				response.flushBuffer();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
    }

    /**
     * 支付成功回调地址
     * 参考地址：
     * https://doc.open.alipay.com/docs/doc.htm?&docType=1&articleId=105672
     * @param request
     * @return
     */
    @RequestMapping(value = "/notifyUrl", method = { RequestMethod.POST, RequestMethod.GET })
    public void notifyUrl(HttpServletRequest request, HttpServletResponse response) {
        // 1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        logger.debug("支付成功回调:"+params.toString());
        String  responseMsg ="";
        try {
	        if(params == null || "".equals(params.toString())|| params.isEmpty()){
	        	  responseMsg = "success";
	        }else{
	            // 2. 验证签名
	            this.verifySignRSA2(params);
	            String trade_no = params.get("trade_no");
	            LogUtil.log("trade_no", trade_no);
	            String trade_status = params.get("trade_status");
	            LogUtil.log("trade_status", trade_status);
	            String out_trade_no = params.get("out_trade_no");
	            LogUtil.log("out_trade_no", out_trade_no);
	            if(RSConsts.TRADE_SUCCESS.equals(trade_status)){
	                OrderSync(trade_no);
	            }
	        }
            
        } catch (AlipayApiException e) {
            logger.error(e.getMessage(),e);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        } finally {
            // 5. 响应结果加签及返回
            try {
                // http 内容应答
                response.reset();
                response.setContentType("text/xml;charset=GBK");
                PrintWriter printWriter = response.getWriter();
                printWriter.print(responseMsg);
                logger.debug("响应请求串:"+params.toString());
                response.flushBuffer();
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        } 
    }
    
    
    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateRefreshAppToken", method = { RequestMethod.POST, RequestMethod.GET })
    public void updateRefreshAppToken(String outParkingId,HttpServletRequest request) {
        // 1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        logger.debug("支付宝请求串:"+params.toString());
        parkService.updateRefreshAppToken(outParkingId);
    }
    
    
    
    
    public void OrderSync(String tradeNO) {
        try {
              OrderBean orderBean = orderBeanService.selectByOrderNo(tradeNO);
              String nowTime =DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
              orderBean.setPayTime(nowTime);
              orderBean.setOrderStatus(OrderStatus.sucess.getVal());
              orderBean.setCardNumber("*");
              orderBean.setOrderSynStatus(OrderSynStatus.paysucess.getVal());
              orderBean.setOrderPayStatus(OrderPayStatus.success.getVal());
              orderBean.setInDuration(DateUtil.getTimeDifferMin(orderBean.getInTime(), nowTime));
              orderBean.setPaidMoney(orderBean.getPayMoney());//已支付
              orderBean.setBillingTyper(billingTyper.A.toString());
              orderBeanService.updateByPrimaryKeySelective(orderBean);
              orderBeanService.insertFromOrder(orderBean);
          } catch (ParseException e) {
              logger.error(e.getMessage(),e);
          }
      }
    

    /**
     * 验签
     * 
     * @param request
     *            ‘
     * @return
     * @throws IOException
     */
    private void verifySign(Map<String, String> params) throws AlipayApiException, IOException {
        if (!AlipaySignature.rsaCheckV2(params, propertiesUtil.readValue("alipay.public.key.RSA1"), propertiesUtil.readValue("alipay.charset.RSA1"),
                propertiesUtil.readValue("alipay.public.signType.RSA1"))) {
            throw new AlipayApiException("verify sign fail.");
        }
    }

    /**
     * 验签RSA2
     * 
     * @param request
     *            ‘
     * @return
     * @throws IOException
     */
    private void verifySignRSA2(Map<String, String> params) throws AlipayApiException, IOException {
        if (!AlipaySignature.rsaCheckV1(params, propertiesUtil.readValue("alipay.public.key"), propertiesUtil.readValue("alipay.charset"),
                propertiesUtil.readValue("alipay.public.signType"))) {
            throw new AlipayApiException("verify sign fail.");
        }
    }
    
    /**
     * 返回函数
     * 
     * @param code
     * @param msg
     * @param econotify
     * @return
     */
    private String buildBaseAckMsg(String code, String msg, String econotify) {
        JSONObject data = new JSONObject();
        data.put("code", code);
        data.put("msg", msg);
        data.put("econotify", econotify);
        String jsonStr = JSON.toJSONString(data);
        return jsonStr;
    }

    public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset, boolean isEncrypt, boolean isSign, String signType) throws AlipayApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(charset)) {
            charset = AlipayConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = AlipaySignature.rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>AES</encryption_type>");
            if (isSign) {
                String sign = AlipaySignature.rsaSign(encrypted, cusPrivateKey, charset, signType);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>");
                sb.append(signType);
                sb.append("</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            String sign = AlipaySignature.rsaSign(bizContent, cusPrivateKey, charset, signType);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>");
            sb.append(signType);
            sb.append("</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }
    
    /**
     * 查询车牌
     * @param outParkingId 
     * @param carNumber
     * @return
     */
    @RequestMapping(value = "/weixinQueryCarNumber", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public AjaxReturnInfo parkingConfigSet(String outParkingId,String carNumber) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        Map<String, Object> dates = new  HashMap<String, Object>();
        ParkBean parkBean = parkService.selectByPrimaryKey(outParkingId);
        if (StringUtils.isEmpty(parkBean) || StringUtils.isEmpty(parkBean.getAppAuthToken())) {
            ajaxinfo.setSuccess(AjaxReturnInfo.FALSE_RESULT);
            ajaxinfo.setMessage("停车场未授权！");
            return ajaxinfo;
        }
        String carNumberD = "";
        try {
            carNumberD = new String(carNumber.getBytes("ISO8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        //查询订单
        OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo(carNumberD);
        cr.andOutParkingIdEqualTo(outParkingId);
        cr.andStatusEqualTo("0");
        List<OrderBean> orderList = orderBeanService.selectByExample(example);
        if (orderList == null || orderList.size() == 0) {
        	ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
            ajaxinfo.setMessage("未检测到车辆进入云停风驰停车场！");
            return ajaxinfo;
        }
        // 首先查询是否存在未付款的订单
        OrderBean order = null;
        OrderBean payOrder = null;
        for (OrderBean orderBean : orderList) {
            //有未付款的订单
            if (OrderSynStatus.create.getVal().equals(orderBean.getOrderSynStatus())) {
            	order = orderBean;
            	break;
            }
            if (OrderSynStatus.paysucess.getVal().equals(orderBean.getOrderSynStatus())) {
            	payOrder = orderBean;
            }
        }
        BigDecimal money = null;
        if(order != null){//存在未付款的订单
        	money = getPayMoney(carNumber, parkBean.getOutParkingId(), order.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),order.getCarType());// 调用接口查询费用
        }
        // 没有找到未付款的订单，找下已经付款的订单
        if (payOrder!=null) {
            // 判断订单的金额是否已经超时产生费用
            String paidMoney = orderBeanService.queryPaidWithCarNumber(payOrder.getCarNumber());
            BigDecimal tradePaidMoney = new BigDecimal(paidMoney);
            money = getPayMoney(carNumber, parkBean.getOutParkingId(), payOrder.getInTime(), DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT),payOrder.getCarType());// 调用接口查询费用
            if (money.compareTo(tradePaidMoney) == 1) {
                // 创建未支付订单
                ParkBean bean = parkService.selectByPrimaryParkingId(outParkingId);
                String in_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
                String outOrderNo = parkService.enterinfoSyncEnter(bean, payOrder.getOrderTrade(), carNumber, payOrder.getInTime(), payOrder.getCarType(), payOrder.getCarColor(),
                		payOrder.getAgreementStatus(), payOrder.getBillingTyper(), payOrder.getCarNumberColor(), payOrder.getLane());
                OrderBean noPaidOrder = orderBeanService.selectByPrimaryKey(outOrderNo);
                order = noPaidOrder;
            }else{
            	order = payOrder;
            }
        }
        try {
			dates.put(RSConsts.orderMoney, money.setScale(2, BigDecimal.ROUND_HALF_DOWN));
			orderBeanService.updateByPrimaryKey(order);
			dates.put("outOrderNo", order.getOutOrderNo());
			String paidMoney = orderBeanService.queryPaidWithCarNumber(order.getCarNumber());
			if (!"0".equals(paidMoney)) {
			    BigDecimal paid = new BigDecimal(paidMoney);
			    if (money.compareTo(paid) == 1) {
			        String payResult = money.subtract(paid).floatValue() + "";
			        BigDecimal setScale = new BigDecimal(payResult).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			        dates.put(RSConsts.payMoney, setScale);
			        dates.put(RSConsts.paidMoney, paid.setScale(2, BigDecimal.ROUND_HALF_DOWN));
			    } else if (money.compareTo(paid) == 0) {
			        dates.put(RSConsts.payMoney, RSConsts.zero);
			        dates.put(RSConsts.paidMoney, paid.setScale(2, BigDecimal.ROUND_HALF_DOWN));
			        dates.put(RSConsts.payBtn, false);
			    }
			} else {
			    BigDecimal setScale = money.setScale(2, BigDecimal.ROUND_HALF_DOWN);
			    dates.put(RSConsts.payMoney, setScale);
			    dates.put(RSConsts.paidMoney, RSConsts.zero);
			}
			dates.put(RSConsts.parkingName, parkBean.getParkingName());
			dates.put(RSConsts.merchantLogo, parkBean.getMerchantLogo());
			dates.put(RSConsts.discountMoney, getDiscountMoney(carNumber, order.getOutParkingId()));// 优惠金额
			dates.put(RSConsts.inTime, order.getInTime());
			String nowTime = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
			dates.put(RSConsts.timeDiffer, DateUtil.getTimeDiffer(order.getInTime(), nowTime));
			dates.put(RSConsts.inDuration, DateUtil.getTimeDifferMin(order.getInTime(), nowTime));
			dates.put(RSConsts.orderTime, DateUtil.getCurrDate(new Date(), DateUtil.STANDDATEFORMAT));
			//dates.put(RSConsts.isvPhone, propertiesUtil.readValue("alipay.isvPhone"));
			dates.put(RSConsts.isvPhone, parkBean.getContactTel());
			dates.put(RSConsts.isvName, propertiesUtil.readValue("alipay.isvName"));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        ajaxinfo.setCarNumber(carNumber);
        ajaxinfo.setDatas(dates);
        ajaxinfo.setSuccess(AjaxReturnInfo.TURE_RESULT);
        return ajaxinfo;
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
        String data = HttpRequestUtil.urlPost(AlipayParkController.PARKPRICE_URL, paramMap,"utf-8");
        JSONObject json = JSONObject.parseObject(data);
        return new BigDecimal(json.getString("totalPrice"));
    }
    
    public String getDiscountMoney(String carNumber, String outParkingId) {
        return "0.00";
    }

}
