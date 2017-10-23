<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>客户详情</title>
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
<script src="${ctx}/js/pagejs/customer/customer.js"></script>




<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
   <script type="text/javascript" src="${ctx}/js/html5shiv.js"></script>
   <script type="text/javascript" src="${ctx}/js/respond.min.js"></script>
<![endif]-->

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
</head>
<body>
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

	<form class="form-horizontal">
	  <legend>客户详情：</legend>
		<div class="form-group">
			<label class="col-sm-2 control-label">客户号:</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${customer.customerid }</p>
			</div>
			
			<label class="col-sm-2 control-label">姓名:</label>
			<div class="col-sm-3">
				 <p class="form-control-static">${customer.customerName }</p>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">手机号：</label>
			<div class="col-sm-3">
			 <p class="form-control-static">${customer.mobile }</p>
			</div>
			
			<label class="col-sm-2 control-label">注册时间：</label>
			<div class="col-sm-3">
				 <p class="form-control-static">${ customer.customerregdate}</p>
				
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">终端编号：</label>
			<div class="col-sm-3">
			  <p class="form-control-static">${ customer.payTerminalId}</p>
			</div>
			
			<label class="col-sm-2 control-label">所属机构：</label>
			<div class="col-sm-4">
				 <p class="form-control-static">${ customer.agencyName}</p>
				
			</div>
		</div>
	 <legend>用户关系：</legend>	
		<div class="form-group">
			<label class="col-sm-2 control-label">上一级：</label>
			<c:forEach var="customerOne" items="${customerListOne }">
				<div class="col-sm-3">
				  <p class="form-control-static">姓名：${ customerOne.customerName}</p>
				</div>
				<div class="col-sm-3">
				  <p class="form-control-static">客户号：${ customerOne.customerid}</p>
				</div>
				<div class="col-sm-3">
				  <p class="form-control-static">手机号：${ customerOne.mobile}</p>
				</div>
			</c:forEach>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">上二级：</label>
			<c:forEach var="customerTwo" items="${customerListTwo }">
				<div class="col-sm-3">
				  <p class="form-control-static">姓名：${ customerTwo.customerName}</p>
				</div>
				<div class="col-sm-3">
				  <p class="form-control-static">客户号：${ customerTwo.customerid}</p>
				</div>
				<div class="col-sm-3">
				  <p class="form-control-static">手机号：${ customerTwo.mobile}</p>
				</div>
			</c:forEach>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">上三级：</label>
				<c:forEach var="customerTop" items="${customerListTop }">
				<div class="col-sm-3">
				  <p class="form-control-static">姓名：${ customerTop.customerName}</p>
				</div>
				<div class="col-sm-3">
				  <p class="form-control-static">客户号：${ customerTop.customerid}</p>
				</div>
				<div class="col-sm-3">
				  <p class="form-control-static">手机号：${ customerTop.mobile}</p>
				</div>
			</c:forEach>
		</div>
		<legend></legend>	
	</form>
	
</body>
</html>