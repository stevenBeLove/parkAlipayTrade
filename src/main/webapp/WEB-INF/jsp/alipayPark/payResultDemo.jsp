<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<title>结果详情</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${ctx}/js/antui/dist/antui.min.css"/>
	<script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
	<script src="https://as.alipayobjects.com/g/component/antbridge/1.1.1/antbridge.min.js"></script>
	<script src="${ctx}/js/antui/dist/antui.min.js"></script>
</head>
<body text=#000000 bgColor="#ffffff" leftMargin=0 topMargin=4>
	<div class="am-message result" role="alert">
	  <i class="am-icon result pay" aria-hidden="true"></i>
	  <div class="am-message-main am-ft-blue">支付成功</div>
	   <div class="am-message-sub"><b>20</b></div>
	  <div class="am-message-sub am-ft-lightgray" style="font-size:20px">请于15分钟内离场，超时将加收停车费</div>
	</div>
</body>
</html>