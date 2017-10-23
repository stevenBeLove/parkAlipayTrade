<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>机构及权限管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/announcement/announcementList.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<style type="text/css">
a,a:hover{ text-decoration:none; color:#333}
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
			<h3>系统公告发送</h3>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default bootstrap-admin-no-table-panel">
					<div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
						<form class="form-horizontal" onsubmit="reloadDate();return false;">
							<fieldset>
								<div class="form-group" style="padding-top: 20px;">

									<label class="col-lg-1 control-label" for="effectTime">生效日期</label>
									<div class="col-lg-3">
										<div class="input-group">
											<input class="form-control datepicker" id="effectTime" name="effectTime" type="text" placeholder="请选择日期" onfocus="this.blur();">
										</div>
									</div>

									<label style="padding-right: 100px;" class="col-lg-1 control-label" for="disabledTime">至</label>
									<div class="col-lg-3">
										<div class="input-group">
											<input class="form-control datepicker" id="disabledTime" name="disabledTime" type="text" placeholder="请选择日期" onfocus="this.blur();  ">
										</div>
									</div>
									  <div class="col-lg-2">
										<button type="submit" class="btn btn-primary">查&nbsp;询</button>
										<button type="reset" class="btn btn-default">清&nbsp;空</button>
									</div>
									 
								</div>
								

								<div class="form-group">
								 
								  <label class="col-lg-1 control-label" for="status">状态</label>
                                       <div class="col-lg-2">
                                           <select id="status" name="status" class="form-control"  style="width: 150px">
                                          			<option value="">--请选择--</option>
                                          			<option value="00">无效</option>
                                           		<option value="01">有效</option>
                                       </select>
                                </div>
									<div class="col-lg-2">
										
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
				
				
					<shiro:hasPermission name="announcement:add">
						<button id="btn_add" type="button" class="btn btn-default" onclick="addAnnouncement();">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
						</button>
					</shiro:hasPermission> 	
					
					<shiro:hasPermission name="announcement:update">
						<button id="btn_edit" type="button" class="btn btn-default" onclick="updateAnnouncement();">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
						</button>
					</shiro:hasPermission> 	
					
					<shiro:hasPermission name="announcement:delete">	
						<button id="btn_delete" type="button" class="btn btn-default" onclick="deleteAnnouncement();">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
						</button>
					</shiro:hasPermission> 	
					
					<shiro:hasPermission name="announcement:audit">	
						<button id="btn_delete" type="button" class="btn btn-default" onclick="auditAnnouncement();">
							<span class="glyphicon glyphicon-check" aria-hidden="true"></span>审核
						</button>
					</shiro:hasPermission> 	
				</div>
				</p>
				<table id="mytab" class="table table-hover"></table>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function addAnnouncement() {
			location.href = ctx + "/announcement/announcementAdd/";
		}

		function deleteAnnouncement() {
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
					url : ctx + "/announcement/delete/" + ids,
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

		function updateAnnouncement() {
			var ids = $.map($('#mytab').bootstrapTable('getSelections'),
					function(row) {
						return row.id;
					});
			if (ids == '') {
				alert('请选择修改的记录!');
				return;
			}
			location.href = ctx + "/announcement/announcementUpdate/" + ids;
		}

		function auditAnnouncement() {
			var ids = $.map($('#mytab').bootstrapTable('getSelections'),
					function(row) {
						return row.id;
					});
			if (ids == '') {
				alert('请选择审核的记录!');
				return;
			}
			location.href = ctx + "/announcement/announcementAudit/" + ids;
		}
	</script>

</body>
</html>