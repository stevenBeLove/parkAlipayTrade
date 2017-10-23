<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>系统公告添加</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
	var ctx = '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/announcement/announcementAdd.js"></script>
<script type="text/javascript">
	function check() {
		if ($("#title").val().trim().length == 0) {
			alert("标题不能为空！");
			$("#title").focus();
			return false;
		}

		if ($("#noticeContent").val().trim().length == 0) {
			alert("正文内容不能为空！");
			$("#noticeContent").focus();
			return false;
		}
		
		if ($("#appuser").val().trim().length == 0) {
			alert("正文内容不能为空！");
			$("#appuser").focus();
			return false;
		}
		
		if ($("#effectTime").val().trim().length == 0) {
			alert("生效时间不能为空！");
			$("#effectTime").focus();
			return false;
		}
		if ($("#disabledTime").val().trim().length == 0) {
			alert("失效时间不能为空！");
			$("#disabledTime").focus();
			return false;
		}
	}
	
	document.getElementsByTagName('textarea')[0].onkeypress = function () {
	   var value = this.value,
	       allLine = value.split('\n'),
	       lastLine = allLine.pop();

	 if (lastLine.length >= 15) {
	     lastLine = lastLine.substr(0, 15) + '\n' + lastLine.substr(15);
	     allLine.push(lastLine)
	     this.value = allLine.join('\n');
	 }   
	};
	</script>
</script>


<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

</head>
<body class="bootstrap-admin-with-small-navbar">
	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<div class="panel panel-default bootstrap-admin-no-table-panel">
					<div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
						<form method="post" class="form-horizontal" action="${ctx}/announcement/insert" onsubmit="return check();">
							<fieldset>
								<input type="hidden" id="createid" name="createid" value="${user.nickname}">
								<legend style="padding-left: 500px;">系统公告添加</legend>
								<div class="form-group">
									<label class="col-lg-2 control-label" for="title">标题</label>
									<div class="col-lg-4">
										<input style="width: 800px;" class="form-control disabled" id="title" name="title" type="text" />
									</div>

								</div>


								<div class="form-group">
									<label class="col-lg-2 control-label" for="noticeContent">正文</label>
									<div class="col-lg-4">
										<textarea style="width: 800px; height: 300px;" name="noticeContent" id="noticeContent"></textarea>
									</div>
								</div>
								
									<div class="form-group">
									<label class="col-lg-2 control-label" for="title">应用类型</label>
									<div class="col-lg-4">
										<input style="width: 800px;" class="form-control disabled" id="appuser" name="appuser" type="text" value="ruifans" readonly/>
									</div>

								</div>
								<div class="form-group">

									<label class="col-lg-2 control-label" for="effectTime">生效日期</label>
									<div class="col-lg-4">
										<input style="width: 200px;" class="form-control datepicker" id="effectTime" name="effectTime" type="text" placeholder="请选择日期"
											onfocus="this.blur();">
									</div>

									<label class="col-lg-2 control-label" for="disabledTime">失效日期</label>
									<div class="col-lg-4">
										<input style="width: 200px;" class="form-control datepicker" id="disabledTime" name="disabledTime" type="text" placeholder="请选择日期"
											onfocus="this.blur();">
									</div>

								</div>

								<div class="form-group">
									<div class="col-lg-12" align="center">
										<button type="submit" class="btn btn-primary">保&nbsp;存</button>
										<button type="reset" class="btn btn-default" onclick="returnBack()">取&nbsp;消</button>
									</div>
								</div>
							</fieldset>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	 $(function() {
		 $('#effectTime').datetimepicker({
	     	format: 'yyyymmdd',
	        language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  0,
	 		autoclose: 1,
	 		todayHighlight: 1,
	 		minView: 2,
	 		forceParse: 0
	     });
	 });
		function returnBack() {
			self.history.back();
		}
	</script>

</body>
</html>