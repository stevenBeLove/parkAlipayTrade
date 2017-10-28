<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>机构及权限管理</title>
<%@ include file="../head.jsp"%>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/agency/agencyList.js"></script>
<style type="text/css">
body.bootstrap-admin-with-small-navbar {
    padding-top: 62px;
}
.page-header{
		padding-bottom: 0px;
}
</style>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
</head>
<body  class="bootstrap-admin-with-small-navbar">
	<div class="container">
		<div class="page-header">
			<h3>我的应用</h3>
		</div>
		<div class="row">
			<%-- 
			<c:forEach items="${clientList}" var="client">
				<div class="col-sm-3 col-md-2">
					<a href="${client.clientId}" target="_blank" class="thumbnail" > <img
						src="${ctx}/images/${client.clientIcon}" alt="${client.clientName}">
					</a>
					<p class="navbar-left">${client.clientName} </p>
				</div>
			</c:forEach>
			--%>
		</div>
	</div>



</body>
</html>