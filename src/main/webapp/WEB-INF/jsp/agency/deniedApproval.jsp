<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>审核驳回</title>
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
<script src="${ctx}/js/pagejs/agency/scaleList.js"></script>
<script type="text/javascript">
	function saveDenied(){
		 var params = $("#agencyForm").serialize();
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				url : '${ctx}/agency/deniedAgencyScale',
				data : params,
				success : function(obj) {
					if (obj.success == 'true') {
						//获取上次一次的URL
						alert(obj.message);
						parent.$('#mytabApproval').bootstrapTable('refresh');
						parent.$.weeboxs.close();
					} else {
						//获取上次一次的URL
						alert(obj.message);
						parent.$.weeboxs.close();
					}

				}
			});
		 
		 
		 
		 
		 
	}
	
	function coloseWeebox(){
		parent.$.weeboxs.close();
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
<form  id="agencyForm" role="form">
		<div class="form-group">
			<label for="exampleInputEmail1">请填写驳回理由</label>
			<input type="hidden" id="agencyId" name="agencyId" value="${fanceAgency.agencyId }" />
			<textarea id="remark" name="remark" class ="form-control" style="width: 100%; height: 100px"></textarea>
		</div>
		
		  <div class="col-lg-12" align="center">
                   <button type="button" class="btn btn-primary" onclick="saveDenied()">确认驳回</button>
                   <button type="reset" class="btn btn-default" onclick="coloseWeebox();">取&nbsp;消</button>
                  </div>
</form>
</body>
</html>