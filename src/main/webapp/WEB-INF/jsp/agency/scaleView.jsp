<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="zhangfn"
	uri="http://github.com/zhangkaitao/tags/zhang-functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>参数详情</title>
<%@ include file="../head.jsp"%>
<style type="text/css">
.tr-audit{
	 background-color: #fda325;
}

</style>

<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/agency/agencyEdit.js"></script>
<script type="text/javascript">

</script>



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

		<div class="form-group">
			<label class="col-sm-2 control-label">机构名称</label>
			<div class="col-sm-3">
				<p class="form-control-static">${fanceAgency.agencyName }</p>
			</div>

			<label class="col-sm-2 control-label">上级机构</label>
			<div class="col-sm-3">
				<p class="form-control-static">${ fanceAgency.parentName}</p>

			</div>
		</div>

		<legend></legend>
		<div class="form-group">
			<div class="col-lg-12">
				<table id="scaleListTab" data-toggle="table">
					<thead>
						<tr>
							<th>序号</th>
							<th>交易类型</th>
							<th>起始分佣比</th>
							<th>上一级分佣比</th>
							<th>上二级分佣比</th>
							<th>上三级分佣比</th>
							<th>生效日期</th>
							<th>结束日期</th>
							<th>创建人</th>
							<th>创建时间</th>
							<th>审核状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${scaleList }" var="fansAgency"
							varStatus="status">
							<c:choose>
								<c:when test="${fansAgency.auditStatus == '01'}">
									<tr id="${ fansAgency.id}" class='tr-class-1 tr-audit' >
										<td>${ status.index + 1}</td>
										<td>${fansAgency.businessName }</td>
										<td>${fansAgency.mycost }</td>
										<td>${fansAgency.nextRate }</td>
										<td>${fansAgency.secondRate }</td>
										<td>${fansAgency.finalRate }</td>
										<td>${fansAgency.begindate }</td>
										<td>${fansAgency.enddate }</td>
										<td>${fansAgency.userNames }</td>
										<td>${fansAgency.datetime }</td>
										<td>未审核</td>
									</tr>
								</c:when>
							 	<c:otherwise>
							 	 <tr id="${ fansAgency.id}" class='tr-class-1'>
									<td>${ status.index + 1}</td>
									<td>${fansAgency.businessName }</td>
									<td>${fansAgency.mycost }</td>
									<td>${fansAgency.nextRate }</td>
									<td>${fansAgency.secondRate }</td>
									<td>${fansAgency.finalRate }</td>
									<td>${fansAgency.begindate }</td>
									<td>${fansAgency.enddate }</td>
									<td>${fansAgency.userNames }</td>
									<td>${fansAgency.datetime }</td>
									<td>通过</td>
								</tr>
							 	</c:otherwise>
							</c:choose>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>



	</form>

</body>
</html>