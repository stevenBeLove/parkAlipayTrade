<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
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
    <style>
        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
    </style>
    
    <script type="text/javascript">
	    function check(){
	    	var name = $("#name").val();;
		    var url  = $("#url").val();
		    var checkIndex=$("#roleNames").get(0).selectedIndex;
		    if(name == ''){
		        alert("名称不能为空!");
		        return false;
		    }
		    if(url == ''){
		        alert("URL不能为空!");
		        return false;
		    }
		    if(checkIndex == -1){
		        alert("请选择角色!");
		        return false;
		    }
	    }
    
    </script>

</head>
<body>

<div class="container">
<div class="row">
	<div class="col-lg-12">

    <form:form method="post" commandName="urlFilter" class="form-horizontal" onsubmit="return check()">
        <fieldset>
        
        <form:hidden path="id"/>

        <div class="form-group">
            <form:label path="name" class="col-lg-2 control-label" >名称：</form:label>
             <div class="col-lg-4">
            	<form:input path="name" class="form-control" />
             </div>
        </div>

        <div class="form-group">
            <form:label path="url" class="col-lg-2 control-label">URL：</form:label>
            <div class="col-lg-4">
           		 <form:input path="url" class="form-control" />
            </div>
        </div>
 <%-- 
       <div class="form-group">
            <form:label path="roles">角色：</form:label>
            <form:input path="roles"/>
        </div> 
  --%>      
       <div class="form-group">
            <form:label path="roleNames" class="col-lg-2 control-label">角色列表：</form:label>
           <div class="col-lg-4">
            <form:select multiple="true" path="roleNames" items="${roleList}" itemLabel="description" itemValue="role" />
           <!--  (按住shift键多选) -->
            </div>
        </div> 
        

        <div class="form-group">
            <form:label path="permissions" class="col-lg-2 control-label">权限列表：</form:label>
            <div class="col-lg-4">
           		 <form:input path="permissions" class="form-control" />
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
