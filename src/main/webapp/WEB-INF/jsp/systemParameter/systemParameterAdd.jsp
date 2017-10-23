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
</script>


<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

</head>
<body class="bootstrap-admin-with-small-navbar">
	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<div class="panel panel-default bootstrap-admin-no-table-panel">
					<div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
						<form method="post" class="form-horizontal" action="${ctx}/systemManagement/insert" onsubmit="return check();">
							<fieldset>
								<legend style="padding-left: 500px;">基本参数添加</legend>
								<div class="form-group">

									<label class="col-lg-2 control-label" for="parNo">参数编码</label>
									<div class="col-lg-4">
										<input class="form-control disabled" id="parNo" name="parNo" type="text" />
									</div>

									<label class="col-lg-2 control-label" for="parName">参数名称</label>
									<div class="col-lg-4">
										<input class="form-control disabled" id="parName" name="parName" type="text" />
									</div>

								</div>

								<div class="form-group">

									<label class="col-lg-2 control-label" for="parMin">参数最小值</label>
									<div class="col-lg-4">
										<input class="form-control disabled" id="parMin" name="parMin" type="text" />
									</div>
									
									
									<label class="col-lg-2 control-label" for="parMax">参数最大值</label>
									<div class="col-lg-4">
										<input class="form-control disabled" id="parMax" name="parMax" type="text" />
									</div>

									

								</div>
								
								
								<div class="form-group">
								
									<label class="col-lg-2 control-label" for="parRemark">参数说明</label>
									<div class="col-lg-4">
										<input class="form-control disabled" id="parRemark" name="parRemark" type="text" />
									</div>
									
									<label class="col-lg-2 control-label" for="status">参数状态</label>
                                                <div class="col-lg-4">
                                                    <select id="status" name="status" class="form-control disabled">
                                                   			<option value="">--请选择--</option>
                                                   			<option value="1">有效</option>
                                                   			<option value="0">无效</option>
	                                               </select>
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
		function returnBack() {
			self.history.back();
		}
	</script>

</body>
</html>