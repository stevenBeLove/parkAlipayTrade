<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>终端管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/terminalManagement/terminalManagement.js"></script>
<style type="text/css">
#Mdown {
	margin-left: 0;
	padding: 0;
	text-align: center;
	font: normal 14px/180% Tahoma, sans-serif;
}

#loginBox {
	margin: 0 auto;
	padding-left: 0px;
	text-align: left;
	width: 500px;
	height: 260px;
	background: #EAEEFF;
	font-size: 9pt;
	border: 2px solid #AAAAAA;
	overflow: hidden;
	filter: alpha(opacity = 90);
	opacity: 1;
}

#loginBox .title {
	text-align: left;
	padding-left: 10px;
	font-size: 11pt;
	border-bottom: 1px solid #AAAAAA;
	height: 25px;
	line-height: 25px;
	cursor: move;
}

#loginBox .t1 {
	float: left;
	font-weight: bold;
	color: #AA7B7B;
	text-decoration: none;
}

#loginBox .t2 {
	float: right;
	text-align: center;
	line-height: 18px;
	height: 18px;
	width: 18px;
	margin-top: 3px;
	margin-right: 2px;
	overflow: hidden;
	border: 1px solid #99BBFF;
	background: #FFE0E9;
	cursor: pointer;
}

#loginBox .login {
	text-align: center;
	width: 100%;
	height: 100%;
}

#bgDiv {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0px;
	left: 0px;
	right: 0px;
	background-color: #777;
	opacity: 0.7;
	z-index: 10000000;
}
body.bootstrap-admin-with-small-navbar {
    padding-top: 62px;
}
.page-header{
		padding-bottom: 0px;
}


</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

</head>
<body class="bootstrap-admin-with-small-navbar">
	<div class="container">
		<div class="page-header">
			<h3>终端管理</h3>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default bootstrap-admin-no-table-panel">
					<div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
						<form class="form-horizontal" onsubmit="reloadDate();return false;">
							<fieldset>

								<input type="hidden" id="limit" name="limit" />
								<input type="hidden" id="offset" name="offset" />

								<div class="form-group">

									<label class="col-lg-1 control-label" for="termId">终端号</label>
									<div class="col-lg-2">
										<input type="text" id="termId" name="termId" class="form-control" />
									</div>

									<label class="col-lg-2 control-label" for="mobile">使用人手机号</label>
									<div class="col-lg-2">
										<input type="text" id="mobile" name="mobile" class="form-control" />
									</div>

									<label class="col-lg-2 control-label" for="orderMobile">订货人手机号</label>
									<div class="col-lg-2">
										<input type="text" id="orderMobile" name="orderMobile" class="form-control" />
									</div>

									<div class="col-lg-1">
										<button type="submit" class="btn btn-primary">查&nbsp;询</button>
									</div>
								</div>


								<div class="form-group">

									<label class="col-lg-1 control-label" for="target">机构名称</label>
                                            	<div class="col-lg-3">
									                    <div class="input-group">
									                        <input type="hidden" id="agencyName" />
									                        <input type="text" class="form-control" id="parentIdSelect" />
									                        <div class="input-group-btn">
									                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									                                <span class="caret"></span>
									                            </button>
									                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
									                            </ul>
									                        </div>
									                    </div>
									             </div>
                                            	
                                            	<div style="display:none">
                                            	<label class="col-lg-1 control-label" for="target">机构编码</label>
                                                <div class="col-lg-2">
                                                    <input type="text" id="agencyId" class="form-control" />
                                                </div>
                                                </div>

									<label class="col-lg-1 control-label" for="termActivation">终端状态</label>
									<div class="col-lg-2">
										<select id="termActivation" name="termActivation" class="form-control" style="width: 150px">
											<option value="">--请选择--</option>
											<option value="1">已激活</option>
											<option value="0">未激活</option>
										</select>
									</div>

									<label class="col-lg-2 control-label" for=""></label>
									<div class="col-lg-2">
										<input type="hidden" id="" name="" class="form-control" />
									</div>

									<div class="col-lg-1">
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
					<button id="btn_export" type="button" class="btn btn-default" onclick="ExportInstitutionsFenRunIssue();">
						<span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入发货信息
					</button>
				</div>
				<div id="toolbar" class="btn-group">
					<button id="btn_export" type="button" class="btn btn-default" onclick="ExportTemplate();">
						<span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出模板
					</button>
				</div>
				</p>
				<table id="mytab" class="table table-hover"></table>
			</div>
		</div>
	</div>

	<div id="loginBox" style="position: absolute; left: 550px; top: 150px; z-index: 10000000000000; display: none;">
		<div class="title" id="Mdown">
			<span class="t1"></span><span class="t2" title="关闭" onClick="login.style.display='none';bgDiv.style.display='none'">X</span>
		</div>
		<div class="login">
			<form action="${ctx }/terminalManagement/uploadTerminalExcel" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check();">
				<fieldset>
					<div class="form-group" align="center" style="padding-top: 80px;">
						<table>
							<tr>
								<td width="100" align="right"><span style="font-size: 16px;"> 导入发货信息:</span></td>
								<td><input style="height: 40px;" class="form-control uniform_on" id="excelFile" name="excelFile" type="file"></td>
								<td><button type="submit" class="btn btn-primary" id="submitBtn">导入</button></td>
							</tr>
						</table>
					</div>
				</fieldset>

			</form>
		</div>
		<script type="text/javascript">
			var IsMousedown, LEFT, TOP, login;
			document.getElementById("Mdown").onmousedown = function(e) {
				login = document.getElementById("loginBox");
				IsMousedown = true;
				e = e || event;
				LEFT = e.clientX - parseInt(login.style.left);
				TOP = e.clientY - parseInt(login.style.top);
				document.onmousemove = function(e) {
					e = e || event;
					if (IsMousedown) {
						login.style.left = e.clientX - LEFT + "px";
						login.style.top = e.clientY - TOP + "px";
					}
				}
				document.onmouseup = function() {
					IsMousedown = false;
				}
			}
		</script>

		<script type="text/javascript">
			function check(){
				
				var excelFile = $("#excelFile").val();
				
				if(excelFile == ''){
					alert('请选择附件！');
					return false;
				}
				if(excelFile.substring(excelFile.indexOf(".")) != '.xls'){
					alert('请选择正确的文件格式！');
					return false;
				}
				
			}
		
			function ExportInstitutionsFenRunIssue() {
				$("#excelFile").val('');
				loginBox.style.display = '';
			}
			//导出模板
			function ExportTemplate() {
				location.href = ctx + "/plug/terminalTemplate.zip";
			}
		</script>
</body>
</html>
