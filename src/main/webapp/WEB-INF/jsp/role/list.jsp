<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
   <%--  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/static/css/css.css"> --%>
    
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
	
	<shiro:hasPermission name="role:create">
	    <a href="${pageContext.request.contextPath}/role/create">
			  <button class="btn btn-sm btn-success">
				<i class="glyphicon glyphicon-ok-sign"></i>
				  角色新增
			  </button>  
	  </a>
	</shiro:hasPermission>

	</div>

	<div class="bootstrap-admin-panel-content">
			<table class="table bootstrap-admin-table-with-actions">
    <thead>
        <tr>
            <th style="width:10%;">角色名称</th>
            <th style="width:10%;">角色描述</th>
            <th style="width:60%;">拥有的资源</th>
            <th style="width:20%;">操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${roleList}" var="role">
            <tr>
                <td>${role.role}</td>
                <td>${role.description}</td>
                <td>${zhangfn:resourceNames(role.resourceIds)}</td>
                <td>
                    <shiro:hasPermission name="role:update">
                        <a href="${pageContext.request.contextPath}/role/${role.id}/update">
                        	<button class="btn btn-sm btn-primary">
								<i class="glyphicon glyphicon-pencil"></i>
								修改
							 </button>
                        </a>
                    </shiro:hasPermission>

                    <shiro:hasPermission name="role:delete">
                        <a href="${pageContext.request.contextPath}/role/${role.id}/delete">
                        		<button class="btn btn-sm btn-danger">
								<i class="glyphicon glyphicon-trash"></i>
									删除
								</button>
                        </a>
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