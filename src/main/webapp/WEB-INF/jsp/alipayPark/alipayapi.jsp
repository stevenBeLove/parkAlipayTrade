<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>支付宝统一下单并支付接口</title>
	</head>
	<%
		////////////////////////////////////请求参数//////////////////////////////////////

		//卖家支付宝帐户
		String seller_email = new String(request.getParameter("WIDseller_email").getBytes("ISO-8859-1"),"UTF-8");
		//必填
		//商户订单号
		String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//商户网站订单系统中唯一订单号，必填
		//订单名称
		String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
		//必填
		//付款金额
		String total_fee = new String(request.getParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");
		//必填
		//订单业务类型
		String product_code = new String(request.getParameter("WIDproduct_code").getBytes("ISO-8859-1"),"UTF-8");
		//SOUNDWAVE_PAY_OFFLINE：声波支付，FINGERPRINT_FAST_PAY：指纹支付，BARCODE_PAY_OFFLINE：条码支付；商户代扣：GENERAL_WITHHOLDING
		//动态ID类型
		String dynamic_id_type = new String(request.getParameter("WIDdynamic_id_type").getBytes("ISO-8859-1"),"UTF-8");
		//wave_code：声波，qr_code：二维码，bar_code：条码
		//动态ID
		String dynamic_id = new String(request.getParameter("WIDdynamic_id").getBytes("ISO-8859-1"),"UTF-8");
		//例如3856957008a73b7d
		//协议支付信息
		String agreement_info = new String(request.getParameter("WIDagreement_info").getBytes("ISO-8859-1"),"UTF-8");
		//商户代扣不可空，json格式
		
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "alipay.acquire.createandpay");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("seller_email", "qcxdac2965@sandbox.com");
		sParaTemp.put("out_trade_no", "AC20171103");
		sParaTemp.put("subject", "停车费用");
		sParaTemp.put("total_fee", "40");
		sParaTemp.put("product_code", "GENERAL_WITHHOLDING");
		//sParaTemp.put("dynamic_id_type", dynamic_id_type);
		sParaTemp.put("dynamic_id", "3856957008a73b7d");
		sParaTemp.put("agreement_info", "1231231231wqwqeqweqeqew");
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest("", "", sParaTemp);
		out.println(sHtmlText);
	%>
	<body>
	</body>
</html>
