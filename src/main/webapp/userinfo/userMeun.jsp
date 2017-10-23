<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <title>菜单管理</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Expires" content="0">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-control" content="no-cache">
		<meta http-equiv="Cache" content="no-cache">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1,maximum-scale=1,user-scalable=no">

        <!-- Bootstrap -->
        <link rel="stylesheet" type="text/css" href="${ctx}/js/extjs/ext-theme-crisp-all.css" />
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
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/chosen.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/selectize/dist/css/selectize.bootstrap3.css">
       
      
        
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
           <script type="text/javascript" src="${ctx}/js/html5shiv.js"></script>
           <script type="text/javascript" src="${ctx}/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <script type="text/javascript">
		var ctx= '${ctx}';
	</script>
        <script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/twitter-bootstrap-hover-dropdown.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/bootstrap-admin-theme-change-size.js"></script>
        <script type="text/javascript" src="${ctx}/vendors/uniform/jquery.uniform.min.js"></script>
        <script type="text/javascript" src="${ctx}/vendors/chosen.jquery.min.js"></script>
        <script type="text/javascript" src="${ctx}/vendors/selectize/dist/js/standalone/selectize.min.js"></script>
        
        <script type="text/javascript" src="${ctx}/vendors/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="${ctx}/vendors/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
        <script type="text/javascript" src="${ctx}/vendors/uniform/twitter-bootstrap-wizard/jquery.bootstrap.wizard-for.bootstrap3.js"></script>
        <script type="text/javascript" src="${ctx}/vendors/boostrap3-typeahead/bootstrap3-typeahead.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/extjs/ext-all.js"></script>
		<script type="text/javascript" src="${ctx}/js/extjs/ext-locale-zh_CN.js"></script>
		<script type="text/javascript" src="${ctx}/js/extjs/ext-theme-crisp.js"></script>
		<script type="text/javascript" src="${ctx}/js/extjs/ext-theme-crisp.js"></script>
		<script type="text/javascript" src="${ctx}/js/role/roleTree.js"></script>
		
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<body  class="bootstrap-hsjiang-with-small-navbar">
	 <div class="container">
     		<div id="paneldiv"></div>
     </div>
</body>      
</html>
