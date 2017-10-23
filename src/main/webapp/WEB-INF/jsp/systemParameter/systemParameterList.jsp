<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>基本参数管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/systemParameter/systemParameterList.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<style type="text/css">
body.bootstrap-admin-with-small-navbar {
    padding-top: 62px;
}
.page-header{
		padding-bottom: 0px;
}
</style>	
</head>
<body class="bootstrap-admin-with-small-navbar">
	<div class="container">
		<div class="page-header">
			<h3>基本参数设置</h3>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default bootstrap-admin-no-table-panel">
					<div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
						<form class="form-horizontal" onsubmit="reloadDate();return false;">
							<fieldset>
								<div class="form-group" style="padding-top: 20px;">

									<label class="col-lg-1 control-label" for="target">参数名称</label>
									<div class="col-lg-3">
										<div class="input-group">
											<input  class="form-control"  type="text" id="parName" name="parName">
										</div>
									</div>

									<div class="col-lg-2">
										<button type="submit" class="btn btn-primary">查&nbsp;询</button>
									</div>
								</div>

								<div class="form-group"></div>

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
						<a class="close" href="#" data-dismiss="alert">×</a> <strong>${danger}</strong>
					</div>
				</c:if>
				<c:if test="${not empty success}">
					<div class="alert alert-success">
						<a class="close" href="#" data-dismiss="alert">×</a> <strong>${success}</strong>
					</div>
				</c:if>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<p>
				<div id="toolbar" class="btn-group">
					<button id="btn_add" type="button" class="btn btn-default" onclick="addSystemParameter();">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
					<button id="btn_edit" type="button" class="btn btn-default" onclick="updateSystemParameter();">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
					<button id="btn_delete" type="button" class="btn btn-default" onclick="deleteSystemParameter();">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				</div>
				</p>
				<table id="mytab" class="table table-hover"></table>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function addSystemParameter() {
			location.href = ctx + "/systemManagement/systemParameterAdd/";
		}

		function deleteSystemParameter() {
			var ids = $.map($('#mytab').bootstrapTable('getSelections'),
					function(row) {
						return row.id;
					});
			if (ids == '') {
				alert('请选择删除的记录!');
				return;
			}

			if (confirm("确认要删除？")) {
				$.ajax({
					type : "GET",
					url : ctx + "/systemManagement/delete/" + ids,
					success : function(data) {
						var obj = eval('(' + data + ')');
						if (obj.success == 'true') {
							alert('删除成功!');
							$('#mytab').bootstrapTable('refresh');
						} else {
							alert('删除失败!');
							$('#mytab').bootstrapTable('refresh');
						}
					}
				});
			}

		}

		function updateSystemParameter() {
			var ids = $.map($('#mytab').bootstrapTable('getSelections'),
					function(row) {
						return row.id;
					});
			if (ids == '') {
				alert('请选择修改的记录!');
				return;
			}
			location.href = ctx + "/systemManagement/systemParameterUpdate/" + ids;
		}
	</script>

</body>
</html>