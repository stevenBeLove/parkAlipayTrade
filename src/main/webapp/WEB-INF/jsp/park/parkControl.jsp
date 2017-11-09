<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>停车场管理控制</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>

<script type="text/javascript">
function carIn(){
	$.ajax({
		type : "POST",
		url : ctx + "/alipayPark/enterinfoSync",
		data : {
			'carNumber':$("#carNumber").val(),
			'outParkingId':$("#outParkingId").val(),
			'carType':'1',
			'carColor':'白色'
		},
		success : function(obj) {
			alert(obj.message);
			if (obj.success == 'true') {
				alert(obj.message);
			} else {
				alert(obj.message);
			}
		},
	});
}

// 点击payButton按钮后唤起收银台
function createOrderButton(){
	$.ajax({
		type : "POST",
		url :  "${ctx}/alipayPark/tradeCreate",
		data : {
			'outOrderNo':$("#outOrderNo").val(),
			'payMoney':$("#payMoney").val()
		},
		beforeSend : function() {
		},
		success : function(obj) {
			if (obj.success == 'true') {
				alert(obj.message);
			} else {
				alert(obj.message);
			}
		}
	});
}	
	

function tardeOrder(){
	var tradeNO = $("#tradeNO").val();
	location.href = ctx+"/park/orderView/"+tradeNO;
}

</script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<style type="text/css">
body.bootstrap-admin-with-small-navbar {
    padding-top: 62px;
}
.page-header{
		padding-bottom: 0px;
}
</style>	
</head>
<body  class="bootstrap-admin-with-small-navbar">
	 <div class="container">
	 	<div class="page-header">
			<h3>停车场接口控制</h3>
		</div>
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                        <fieldset>
                                            <div class="form-group">
                                            	<label class="col-lg-1 control-label" for="username">车牌</label>
                                                <div class="col-lg-2">
                                                    <input type="text"  id="carNumber" class="form-control" />
                                                </div>
                                                <label class="col-lg-1 control-label" for="username">停车场ID</label>
                                                <div class="col-lg-2">
                                                    <input type="text"  id="outParkingId" value="${outParkingId }" class="form-control" />
                                                </div>
                                                <div class="col-lg-2">
                                                	<button id ="carIn" type="button" class="btn btn-primary" onclick="carIn();">车辆驶入</button>
                                                </div>
                                            </div>
                                        </fieldset>
                                </div>
                                
                            </div>
                            
                            
                             <div class="panel panel-default bootstrap-admin-no-table-panel">
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                        <fieldset>
                                            <div class="form-group">
                                            	<label class="col-lg-1 control-label" for="tradeNO">outOrderNo</label>
                                                <div class="col-lg-2">
                                                    <input type="text"  id="outOrderNo" name ="outOrderNo" class="form-control" />
                                                </div>
                                                
                                                <label class="col-lg-1 control-label" for="tradeNO">订单金额</label>
                                                <div class="col-lg-2">
                                                    <input type="text"  id="payMoney" name ="payMoney" class="form-control" />
                                                </div>
                                                <div class="col-lg-2">
                                                	<button  type="button" class="btn btn-primary" onclick="createOrderButton();">创建订单</button>
                                                </div>
                                            </div>
                                        </fieldset>
                                </div>
                                
                            </div>
                        </div>
                    </div>  
			
			
	</div>
	
</body>
</html>