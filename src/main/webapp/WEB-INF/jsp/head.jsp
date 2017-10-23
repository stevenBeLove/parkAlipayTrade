<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 		<meta http-equiv="Expires" content="0">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-control" content="no-cache">
		<meta http-equiv="Cache" content="no-cache">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<% 
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", -10);
		%>
        <!-- Bootstrap -->
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-theme.min.css">

       
		 <!-- Bootstrap Admin Theme -->
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-admin-theme.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/bootstrap-admin-theme-change-size.css">
        
        
         <link rel="stylesheet" media="screen" href="${ctx}/vendors/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/datepicker.fixes.css">
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/uniform/themes/default/css/uniform.default.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/css/uniform.default.fixes.css">
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/chosen.min.css">
        <link rel="stylesheet" media="screen" href="${ctx}/vendors/selectize/dist/css/selectize.bootstrap3.css">
		<link rel="stylesheet" href="${ctx}/js/bootstrapTables/bootstrap-table.css" />
		
		
		<script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="${ctx}/js/json2.js"></script>

        <script type="text/javascript" src="${ctx}/js/respond.min.js"></script>
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
		
		
		<script src="${ctx}/js/bootstrapTables/bootstrap-table.js"></script>
		<script src="${ctx}/js/bootstrapTables/bootstrap-table-zh-CN.js"></script>
		
		<link type="text/css" rel="stylesheet" href="${ctx}/js/weebox/src/weebox.css" />
		<script type="text/javascript" src="${ctx}/js/weebox/src/browser.js"></script>
        <script type="text/javascript" src="${ctx}/js/weebox/src/bgiframe.js"></script>
		<script type="text/javascript" src="${ctx}/js/weebox/src/weebox.js"></script>
		
		<script type="text/javascript">
		<!--
		function returnBack(){
			   self.history.back();
		}
		//-->
		</script>
		
		
