<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
</head>
<body>

<div class="container">
<div class="row">
<div class="col-lg-12">

	<div class="panel panel-default">
		
		<c:if test="${not empty msg}">	
			<div class="alert alert-success">
				<a class="close" href="#" data-dismiss="alert">×</a>
				<strong>${msg}</strong>
			</div>	
		</c:if>
		
		<div class="panel-heading">
		
			<shiro:hasPermission name="urlFilter:create">
			    <a href="${pageContext.request.contextPath}/urlFilter/create"><button class="btn btn-sm btn-success">
								<i class="glyphicon glyphicon-ok-sign"></i>
								  URL新增
							  </button> </a>
			</shiro:hasPermission>
					
		</div>
		


<div class="bootstrap-admin-panel-content">
<table class="table bootstrap-admin-table-with-actions">
    <thead>
        <tr>
            <th>名称</th>
            <th>URL</th>
            <th>角色列表</th>
            <th>权限列表</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${urlFilterList}" var="urlFilter">
            <tr>
                <td>${urlFilter.name}</td>
                <td>${urlFilter.url}</td>
                <td>${urlFilter.roles}</td>
                <td>${urlFilter.permissions}</td>
                <td>
                    <shiro:hasPermission name="urlFilter:update">
                        <a href="${pageContext.request.contextPath}/urlFilter/${urlFilter.id}/update"><button class="btn btn-sm btn-primary">
								<i class="glyphicon glyphicon-pencil"></i>
								修改
							 </button></a>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="urlFilter:delete">
                        <a href="${pageContext.request.contextPath}/urlFilter/${urlFilter.id}/delete"><button class="btn btn-sm btn-danger">
								<i class="glyphicon glyphicon-trash"></i>
									删除
								</button></a>
                    </shiro:hasPermission>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>

	</div>
</div>
</div>
</div>
</body>
</html>