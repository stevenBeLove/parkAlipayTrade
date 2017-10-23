<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>机构审核（待审核）</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
		function resetBtn(){
			$("#agencyId").val("");
			$("#agencyName").val("");
			$("#pageListAgencySelect").val("");
		}
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/agency/agencyList.js"></script>
<script src="${ctx}/js/pagejs/agency/agencyListApprove.js"></script>
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
			<h3>机构审核</h3>
		</div>
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                               
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                    <form class="form-horizontal" onsubmit="reloadApproveDate();return false;">
                                        <fieldset>
                                            <div class="form-group">
                                            	
                                            	<label class="col-lg-1 control-label" for="target">机构名称</label>
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
                                            	
                                            	<label class="col-lg-1 control-label" for="target">机构编码</label>
                                                <div class="col-lg-2">
                                                    <input type="text" id="agencyId" class="form-control" />
                                                    <input type="hidden" id="agencyId"  value=""/>
                                                </div>
                                            	
                                                <div class="col-lg-2">
                                                	<button type="submit" class="btn btn-primary">查&nbsp;询</button>
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
						
						 <shiro:hasPermission name="angencyApproval:approval">
							   <button id="btn_add" type="button" class="btn btn-default" onclick="approvalAgency();">
							    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>审核通过
							   </button>
						 </shiro:hasPermission>  
						 
						  <shiro:hasPermission name="angencyApproval:denied">
							   <button id="btn_edit" type="button" class="btn btn-default" onclick="deniedApprovale();">
							    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>审核驳回
							   </button>
						   </shiro:hasPermission>   
						  </div>
						 </p> 
						<table id="mytabApproval" class="table table-hover"></table>
				</div>
		</div>				
	</div>
	
	
	
</body>
</html>