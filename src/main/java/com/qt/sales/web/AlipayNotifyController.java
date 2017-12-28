/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 */
package com.qt.sales.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
import com.qt.sales.model.OrderBean.OrderStatus;
import com.qt.sales.model.OrderBean.OrderSynStatus;
import com.qt.sales.service.OrderBeanService;
import com.qt.sales.service.ParkService;
import com.qt.sales.utils.DateUtil;
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
              orderBean.setInDuration(DateUtil.getTimeDifferMin(orderBean.getInTime(), nowTime));
              orderBean.setPaidMoney(orderBean.getPayMoney());//已支付
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

}
