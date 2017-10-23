<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>用户管理</title>
<link rel="stylesheet"
	href="${ctx}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/js/bootstrapTables/bootstrap-table.css" />
<!-- Bootstrap -->
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-theme.min.css">

        <!-- Bootstrap Admin Theme -->
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-admin-theme.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-admin-theme-change-size.css">

        <!-- Vendors -->
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/datepicker.fixes.css">
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/uniform/themes/default/css/uniform.default.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/uniform.default.fixes.css">
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/chosen/chosen.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/selectize/dist/css/selectize.bootstrap3.css">
        
        <link href="${ctx}/js/magicsuggest/magicsuggest.css" rel="stylesheet">
        
        <script type="text/javascript">
		var ctx= '${ctx}';
		</script>
		<script src="${ctx}/js/jquery-2.0.3.min.js"></script>
		<script src="${ctx}/js/bootstrap.min.js"></script>
		<script src="${ctx}/js/bootstrapTables/bootstrap-table.js"></script>
		<script src="${ctx}/js/bootstrapTables/bootstrap-table-zh-CN.js"></script>
		
		<link type="text/css" rel="stylesheet" href="${ctx}/js/weeb/weebox.css" />
	    <script type="text/javascript" src="${ctx}/js/weebox/src/browser.js"></script>
	    <script type="text/javascript" src="${ctx}/js/weeb/bgiframe.js"></script>
		<script type="text/javascript" src="${ctx}/js/weeb/weebox.js"></script>
		
		<script type="text/javascript" src="${ctx }/vendors/chosen/chosen.jquery.min.js"></script>
        <script type="text/javascript" src="${ctx }/vendors/selectize/dist/js/standalone/selectize.min.js"></script>
        

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>
<body  class="bootstrap-hsjiang-with-small-navbar">

	 <div class="container">
		<div>
			<div class="col-*-12">
			<div id="toolbar" class="btn-group">
			   <button id="btn_add" type="button" class="btn btn-default" onclick="addUser();">
			    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			   </button>
			   <button id="btn_edit" type="button" class="btn btn-default" onclick="modifyUser();">
			    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			   </button>
		<%--  <button id="btn_delete" type="button" class="btn btn-default">
			    <span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="disable();"></span>禁用用户
			   </button> --%>
			  </div>
			<table id="mytab" class="table table-hover"></table>
			</div>
		</div>
	</div>
	<script src="${ctx}/js/role/userinfo.js"></script>
</body>
</html>