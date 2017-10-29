<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>停车场管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/park/park.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<style type="text/css">
body.bootstrap-admin-with-small-navbar {
    padding-top: 62px;
}
.page-header{
		padding-bottom: 0px;
}
</style>	
</head>
<body  class="bootstrap-admin-with-small-navbar">
	 <div class="container">
	 	<div class="page-header">
			<h3>停车场管理</h3>
		</div>
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                               
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                    <form class="form-horizontal" onsubmit="reloadDate();return false;">
                                        <fieldset>
                                            <div class="form-group">
                                            	
                                            	<label class="col-lg-1 control-label" for="nickname">昵称</label>
                                                <div class="col-lg-2">
                                                    <input type="text"  id="nickname" class="form-control" />
                                                </div>
                                            	
                                            	<label class="col-lg-1 control-label" for="username">用户名</label>
                                                <div class="col-lg-2">
                                                    <input type="text"  id="username" class="form-control" />
                                                </div>
                                            	
                                            	
                                                
                                                <div class="col-lg-2">
                                                	<button type="submit" class="btn btn-primary">查&nbsp;询</button>
                                           			 <button type="reset" class="btn btn-default">清&nbsp;空</button>
                                                </div>
                                            </div>
                                            
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>  
			
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${not empty danger}">	
							<div class="alert alert-danger">
								<a class="close" href="#" data-dismiss="alert">×</a>
								<strong>${danger}</strong>
							</div>	
					</c:if>
					<c:if test="${not empty msg}">	
							<div class="alert alert-success">
								<a class="close" href="#" data-dismiss="alert">×</a>
								<strong>${msg}</strong>
							</div>	
					</c:if>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
						<p>
						<div id="toolbar" class="btn-group">
						 		<button id="btn_edit" type="button" class="btn btn-default" onclick="grantPark();">
							    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>授权
							   </button>&nbsp;&nbsp;
							   <button id="btn_add" type="button" class="btn btn-default" onclick="addUser();">
							    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>更新停车场信息
							   </button>
							 
						  </div>
						 </p> 
						<table id="mytab" class="table table-hover"></table>
				</div>
		</div>				
	</div>
	
	
	
</body>
</html>