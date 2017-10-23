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
<script type="text/javascript">
		var ctx= '${ctx}';
		
		function resetBtn(){
			$("#agencyId").val("");
			$("#agencyName").val("");
			$("#pageListAgencySelect").val("");
			$("#status").val("");
		}
</script>

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
			<h3>机构管理</h3>
		</div>
	 			
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                               
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                    <form class="form-horizontal" onsubmit="reloadDate();return false;">
                                        <fieldset>
                                            <div class="form-group">
                                            	
                                            	<label class="col-lg-2 control-label" for="target">分销商名称</label>
                                            	<div class="col-lg-3">
									                    <div class="input-group">
									                        <input type="hidden" id="agencyName" />
									                        <input type="text" class="form-control" id="pageListAgencySelect" />
									                        <div class="input-group-btn">
									                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									                                <span class="caret"></span>
									                            </button>
									                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
									                            </ul>
									                        </div>
									                    </div>
									             </div>
                                            	
                                            	<label class="col-lg-2 control-label" for="target">机构编码</label>
                                                <div class="col-lg-3">
                                                    <input type="text" id="agencyId" class="form-control" />
                                                </div>
                                                
                                                 <div class="col-lg-2">
	                                                	<button type="submit" class="btn btn-primary">查&nbsp;询</button>
	                                                </div>
                                                
                                            </div>
                                            
                                            <div class="form-group">
	                                          	 <label class="col-lg-2 control-label" for="status">状态</label>
	                                                <div class="col-lg-3">
	                                                    <select id="status" class="form-control"  style="width: 150px">
	                                                   			<option value="">--请选择--</option>
	                                                   			<option value="00">审核通过</option>
	                                                    		<option value="01">待审核</option>
	                                                    		<option value="02">待配置参数</option>
	                                                    		<option value="03">审核驳回</option>
		                                               </select>
	                                                </div>
	                                                <div class="col-lg-2 pull-right">
	                                           			 <button type="button" class="btn btn-default" onclick="resetBtn();">清&nbsp;空</button>
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
						   <shiro:hasPermission name="angencyManage:create">
							   <button id="btn_add" type="button" class="btn btn-default" onclick="addAgency();">
							    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
							   </button>
						   </shiro:hasPermission>
						   <shiro:hasPermission name="angencyManage:update">
							   <button id="btn_edit" type="button" class="btn btn-default" onclick="modifyAgency();">
							    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
							   </button>
						   </shiro:hasPermission>
						    <shiro:hasPermission name="angencyManage:delete">
							    <button id="btn_edit" type="button" class="btn btn-default" onclick="deleteAgency();">
							    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							   </button>
						   </shiro:hasPermission>
						   
						    <shiro:hasPermission name="angencyManage:config">
							   <button id="btn_delete" type="button" class="btn btn-default" onclick="createScale();">
								    <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>配置返佣参数
							   </button> 
						   </shiro:hasPermission>
						   
						  </div>
						 </p> 
						<table id="mytab" class="table table-hover"></table>
				</div>
		</div>				
	</div>
	
	
	
</body>
</html>