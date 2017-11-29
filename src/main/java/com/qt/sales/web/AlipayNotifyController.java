/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 */
package com.qt.sales.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.qt.sales.common.AliPayUtil;
import com.qt.sales.common.PropertiesUtil;
import com.qt.sales.exception.QTException;
import com.qt.sales.service.OrderBeanService;
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
	private AliPayUtil aliPayUtil;
	
	
    @Resource(name = "propertiesUtil")
    private PropertiesUtil propertiesUtil;
	

    
    
    /**
     * 自动代扣关闭
     * @param request
     * @return
     */
    @RequestMapping(value = "/agreementNotify", method = {RequestMethod.POST, RequestMethod.GET})
    public void agreementNotify(HttpServletRequest request, HttpServletResponse response){
    	 //支付宝响应消息  
        String responseMsg = "";
        //1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        //打印本次请求日志，开发者自行决定是否需要
        LogUtil.log("支付宝请求串", params.toString());
        try {
			//2. 验证签名
			this.verifySign(params);
			orderBeanService.updateAgreementNotify(params);
			String code = "10000";
	    	String msg = "success";
	    	String econotify= "success";
			responseMsg =  buildBaseAckMsg(code,msg,econotify);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            //5. 响应结果加签及返回
            try {
                //对响应内容加签
                responseMsg = encryptAndSign(responseMsg,
                	propertiesUtil.readValue("alipay.public.key.RSA1"),
                	propertiesUtil.readValue("alipay.app.private.key.RSA1"), propertiesUtil.readValue("alipay.charset"),
                    false, true, propertiesUtil.readValue("alipay.public.signType.RSA1"));
                //http 内容应答
                response.reset();
                response.setContentType("text/xml;charset=GBK");
                PrintWriter printWriter = response.getWriter();
                printWriter.print(responseMsg);
                LogUtil.log("返回值", params.toString());
                response.flushBuffer();
            } catch (AlipayApiException alipayApiException) {
                //开发者可以根据异常自行进行处理
                alipayApiException.printStackTrace();
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    /**
     * 验签
     * 
     * @param request‘
     * @return
     * @throws IOException 
     */
    private void verifySign(Map<String, String> params) throws AlipayApiException, IOException {
		if (!AlipaySignature.rsaCheckV2(params, propertiesUtil.readValue("alipay.public.key.RSA1"),
				propertiesUtil.readValue("alipay.charset.RSA1"), propertiesUtil.readValue("alipay.public.signType.RSA1"))) {
			throw new AlipayApiException("verify sign fail.");
		}
    }
    /**
     * 返回函数
     * @param code
     * @param msg
     * @param econotify
     * @return
     */
    private String buildBaseAckMsg(String code,String msg,String econotify) {
        StringBuilder sb = new StringBuilder();
        sb.append("<XML>");
        sb.append("<code><![CDATA[" + code + "]]></code>");
        sb.append("<msg><![CDATA[" + msg + "]]></msg>");
        sb.append("<econotify><![CDATA[" + econotify + "]]></econotify>");
        sb.append("</XML>");
        return sb.toString();
    }
    
	public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset,
			boolean isEncrypt, boolean isSign, String signType) throws AlipayApiException {
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
