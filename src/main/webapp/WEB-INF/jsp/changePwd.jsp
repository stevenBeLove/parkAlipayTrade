<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<html class="bootstrap-admin-vertical-centered">
<head>
</head>
<body class="bootstrap-admin-without-padding text-center">
	<div
		class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
		<form class="form-horizontal">
			<input type="hidden" value="${id }" id ="id" name ="id"/>
			<fieldset>
				<legend>
					<h1>修改密码</h1>
				</legend>
				 
				<div class="form-group">
					<label class="col-lg-2 control-label" for="focusedInput">原密码:</label>
					<div class="col-lg-10">
						<input class="form-control" name="oldPwd" id="oldPwd"
							type="password" oninvalid="setCustomValidity('必须填写！');" value="">
					</div>
				</div>


				<div class="form-group has-warning">
					<label class="col-lg-2 control-label" for="inputError">请输入新密码：</label>
					<div class="col-lg-10">
						<input type="password" id="newPwd" name="newPwd"
							oninvalid="setCustomValidity('必须填写！');" class="form-control">

					</div>
				</div>
				<div class="form-group has-error">
					<label class="col-lg-2 control-label" for="inputError">请再次输入新密码：</label>
					<div class="col-lg-10">
						<input type="password" id="sureNewPwd" name="sureNewPwd"
							oninvalid="setCustomValidity('必须填写！');" class="form-control">

					</div>
				</div>
				<span class="resText" id="resText"></span> <br> <br>
				<button type="button" id="mysure" class="btn btn-primary">确认修改</button>
				<button type="reset" class="btn btn-default">取消</button>
			</fieldset>
		</form>
	</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript">


	$(function() {
		$('#mysure').click(function() {
			
			if($("#newPwd").val() ==''|| $("#sureNewPwd").val() ==''){
				alert('值不允许为空!');
				return;
			}
			$.ajax({
				type : "GET",
				url : "${pageContext.request.contextPath}/chgpwd",
				data : {
					id: $("#id").val(),
					oldPwd : $("#oldPwd").val(),
					newPwd : $("#newPwd").val(),
					sureNewPwd : $("#sureNewPwd").val()
				},
				dataType : "json",
				success : function(data) {
					$('#resText').empty(); //清空resText里面的所有内容
					var html = "<font color='red'>" + data.msg + "</font>";
					//alert(data.msg);
					$('#resText').html(html);
				}
			});
		});
	});
</script>
</html>
