<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>机构及权限管理</title>
<%@ include file="../head.jsp"%>

<style type="text/css">
body{
 	padding-top: 28px;
}

</style>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/agency/agencyEdit.js"></script>




<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
   <script type="text/javascript" src="${ctx}/js/html5shiv.js"></script>
   <script type="text/javascript" src="${ctx}/js/respond.min.js"></script>
<![endif]-->

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
</head>
<body>
	<form class="form-horizontal">
	
	  <legend>企业信息：</legend>
		<div class="form-group">
			<%-- <label class="col-sm-2 control-label">来源系统</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${fanceAgency.systemid }</p>
			</div> --%>
			
			<label class="col-sm-2 control-label">上级机构</label>
			<div class="col-sm-3">
				 <p class="form-control-static">${ fanceAgency.parentName}</p>
				
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">机构编码</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${fanceAgency.agencyId  }</p>
			</div>
			
			<label class="col-sm-2 control-label">企业名称</label>
			<div class="col-sm-3">
				 <p class="form-control-static">${ fanceAgency.agencyName}</p>
				
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">法人信息</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${qt1Agency.legalInfo }</p>
			</div>
			
			<label class="col-sm-2 control-label">企业地址</label>
			<div class="col-sm-4">
				 <p class="form-control-static">${ qt1Agency.companyaddr}</p>
				
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">联系人</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${qt1Agency.contactsname }</p>
			</div>
			
		
		</div>
		    <legend>结算信息：</legend>
		    
		 <div class="form-group">
			<label class="col-sm-2 control-label">结算人手机</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${fanceAgency.mobile}</p>
			</div>
			
			<label class="col-sm-2 control-label">结算人姓名</label>
			<div class="col-sm-3">
				 <p class="form-control-static">${fanceAgency.name}</p>
				
			</div>
		</div> 
		
		 <div class="form-group">
			<label class="col-sm-2 control-label">结算人身份证号</label>
			<div class="col-sm-3">
				 <p class="form-control-static">${fanceAgency.idCardNum}</p>
				
			</div>
		</div> 
		
		<div class="form-group">
			<label class="col-sm-2 control-label">开户银行</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${fanceAgency.bankname}</p>
			</div>
			
			<label class="col-sm-2 control-label">银行卡号</label>
			<div class="col-sm-3">
				 <p class="form-control-static">${fanceAgency.accountno }</p>
				
			</div>
		</div> 
	
	<c:if test="${not empty fanceAgency.remark}">		
		
		<c:if test="${fanceAgency.status == '03' }">
				 <legend>审核信息：</legend>
				 <div class="form-group">
					<label class="col-sm-2 control-label">驳回理由</label>
					<div class="col-sm-3">
					  <p class="form-control-static">${fanceAgency.remark}</p>
					</div>
				</div>
		</c:if>
		 
	</c:if>	 
		
	</form>
	
</body>
</html>