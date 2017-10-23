<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zhangfn"
	uri="http://github.com/zhangkaitao/tags/zhang-functions"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>返佣参数配置</title>

<script type="text/javascript">
		var ctx= '${ctx}';
		
 $(function() {
	 $('.datepicker').datetimepicker({
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
		
 

	function updateScaleForm() {

		var mycost = $("#mycost").val();
    	if(mycost==''){
    		alert('起始分佣比,不能为空!');
    		return;
    	}
    	var finalRate = $("#finalRate").val();
    	if(finalRate==''){
    		alert('上三级分佣,不能为空!');
    		return;
    	}
    	var secondRate = $("#secondRate").val();
    	if(secondRate==''){
    		alert('上二级分佣,不能为空!');
    		return;
    	}
    	var nextRate = $("#nextRate").val();
    	if(nextRate==''){
    		alert('上一级分佣,不能为空!');
    		return;
    	}
		var sumAmount = parseInt(finalRate)+parseInt(secondRate)+parseInt(nextRate);
    	if(sumAmount > parseInt(mycost)){
    		alert('三级之和不能大于起始分佣比!');
    		return;
    	}

		var params = $("#scaleForm").serialize();
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			url : '${ctx}/agency/updateScaleForm/',
			data : params,
			success : function(obj) {
				if (obj.success == 'true') {
					//获取上次一次的URL
					alert(obj.message);
					parent.window.location.reload();
					parent.$.weeboxs.close();
				} else {
					//获取上次一次的URL
					//parent.window.location.href = document.referrer;
					alert(obj.message);
					parent.$.weeboxs.close();
				}

			}
		});
	}
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

	<form id="scaleForm" class="form-horizontal"  method="post" role="form" >
		<c:if test="${not empty danger}">
			<div class="row">
				<div class="col-sm-6">
					<div class="alert alert-danger">
						<a class="close" href="#" data-dismiss="alert">×</a> 
						<strong>${danger}</strong>
					</div>
				</div>
			</div>
		</c:if>
		<div class="form-group">
			
			<input id="id" name="id" type="hidden" value="${fansAgencyScale.id }"/>
		
			<label class="col-sm-2 control-label" for="mycost">起始分佣比</label>
			<div class="col-sm-2">
				<input class="form-control" id="mycost" name="mycost" type="text"
					value="${fansAgencyScale.mycost }" maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
			</div>
			<label class="col-sm-2 control-label" for="finalRate">上一级分佣</label>
			<div class="col-sm-2">
				<input class="form-control disabled" id="nextRate" name="nextRate" type="text"
					value="${fansAgencyScale.nextRate }" maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="secondRate">上二级分佣</label>
			<div class="col-sm-2">
				<input class="form-control" id="secondRate" name="secondRate" type="text"
					value="${fansAgencyScale.secondRate }" maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
			</div>


			<label class="col-sm-2 control-label" for="nextRate">上三级分佣</label>
			<div class="col-sm-2">
				<input class="form-control" id="finalRate" name="finalRate" type="text"
					value="${fansAgencyScale.finalRate }" maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
			</div>


		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="begindate">生效日期</label>
			<div class="col-sm-3">
						 <input class="form-control datepicker" id="begindate" name="begindate" type="text" placeholder="请选择日期"  onfocus="this.blur();"  required data-date-startdate="${enddate}"  required oninvalid="setCustomValidity('必须填写！');" onchange="setCustomValidity('');" value="${fansAgencyScale.begindate }">
			</div>

		</div>


		<div class="form-group">
			<div class="col-sm-10" align="center">
				<button type="button" class="btn btn-primary" onclick="updateScaleForm();">保存</button>
				<button type="reset" class="btn btn-default">取&nbsp;消</button>
			</div>
		</div>


	</form>

</body>
</html>