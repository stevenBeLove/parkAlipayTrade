<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
   <!-- Bootstrap -->
     <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
     <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

     <!-- Bootstrap Admin Theme -->
     <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
     <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme-change-size.css">
    
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/twitter-bootstrap-hover-dropdown.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-admin-theme-change-size.js"></script>
    
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-table/dist/bootstrap-table.min.css">
	<script src="${pageContext.request.contextPath}/js/bootstrap-table/dist/bootstrap-table.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css">
    
    <script type="text/javascript">
    function check(){
    	var name = $("#name").val();;
	    if(name == ''){
	        alert("名称不能为空!");
	        return false;
	    }
    }
    
    </script>
</head>
<body>
<div class="container">
<div class="row">
	<div class="col-lg-12">
	
   <form:form method="post" commandName="resource" class="form-horizontal" onsubmit="return check()">
    <fieldset>
        <form:hidden path="id"/>
        <form:hidden path="available"/>
        <form:hidden path="parentId"/>
        <form:hidden path="parentIds"/>

        <c:if test="${not empty parent}">
            <div class="form-group">
                <label class="col-lg-2 control-label">父节点名称：</label>
                <div class="col-lg-4">
               		 ${parent.name}
                </div>
            </div>
        </c:if>

        <div class="form-group">
            <form:label path="name"  class="col-lg-2 control-label"><c:if test="${not empty parent}">子</c:if>名称：</form:label>
           
            <div class="col-lg-4">
            	<form:input path="name" class="form-control" />
            </div>	
            	
        </div>
        <div class="form-group">
            <form:label path="type" class="col-lg-2 control-label">类型：</form:label>
             <div class="col-lg-4">	
            		<form:select path="type" items="${types}" itemLabel="info" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="url" class="col-lg-2 control-label">URL路径：</form:label>
            <div class="col-lg-4">	
           		 <form:input path="url" class="form-control" />
           	</div>	 
        </div>


        <div class="form-group">
            <form:label path="permission" class="col-lg-2 control-label">权限字符串：</form:label>
            <div class="col-lg-4">
            	<form:input path="permission" class="form-control" />
            </div>	
        </div>
        
         <div class="form-group">
            <form:label path="icon" class="col-lg-2 control-label">图标：</form:label>
           
           	 <div class="col-lg-4">
            <form:input path="icon" class="form-control" />
            </div>
        </div>

        
        <div class="form-group">
			 <div class="col-lg-6">
		        <form:button class="btn btn-primary pull-right" >${op}</form:button>
		     </div>
		 </div>	
        
	</fieldset>

	</form:form>


	</div>
</div>
</div>
</body>
</html>
