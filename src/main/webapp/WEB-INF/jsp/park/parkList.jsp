<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>停车场管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/park/park.js"></script>

<script type="text/javascript">
function createPark(){
	   var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
        return row.outParkingId;
    });
		if(ids==''){
    		alert('请选择修改的记录!');
    		return;
		}
		$.ajax({   
	   	   type:"GET",
	       url:  ctx+"/alipayPark/parkingCreate/"+ids,
	       success:function(obj){
	    	   alert(obj.message);
	    	  if(obj.success=='true'){
					alert(obj.message);
				}else{
					alert(obj.message);
				}
	          }	          
	     }); 
}     


function updatePark(){
	   var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
     		return row.outParkingId;
 		});
		if(ids==''){
 		alert('请选择修改的记录!');
 		return;
		}
		$.ajax({   
	   	   type:"GET",
	       url:  ctx+"/alipayPark/parkingConfigSet/"+ids,
	       success:function(obj){
	    	  if(obj.success=='true'){
					alert(obj.message);
				}else{
					alert(obj.message);
				}
	          }	          
	     }); 
}


function carControl(){
	var ids = $.map($('#mytab').bootstrapTable('getSelections'), function (row) {
        return row.outParkingId;
    });
	if(ids==''){
		alert('请选择修改的记录!');
		return;
	}
	location.href = ctx+"/park/showCarControl/"+ids;
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
			<h3>停车场管理</h3>
		</div>
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                               
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                </div>
                            </div>
                        </div>
                    </div>  
			
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${not empty danger}">	
							<div class="alert alert-danger">
								<a class="close" href="#" data-dismiss="alert">×</a>
								<strong>${danger}</strong>
							</div>	
					</c:if>
					<c:if test="${not empty msg}">	
							<div class="alert alert-success">
								<a class="close" href="#" data-dismiss="alert">×</a>
								<strong>${msg}</strong>
							</div>	
					</c:if>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
						<p>
						<div id="toolbar" class="btn-group">
						 		<button id="btn_edit" type="button" class="btn btn-default" onclick="grantPark();">
							    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>授权
							   </button>&nbsp;&nbsp;
							   <button id="btn_create" type="button" class="btn btn-default" onclick="createPark();">
							    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>创建停车场
							   </button>&nbsp;&nbsp;
							   <button id="btn_add" type="button" class="btn btn-default" onclick="updatePark();">
							    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>修改停车场信息
							   </button>
							    <button id="btn_control" type="button" class="btn btn-default" onclick="carControl();">
							    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>车场接口
							   </button>
							 
						  </div>
						 </p> 
						<table id="mytab" class="table table-hover"></table>
				</div>
		</div>				
	</div>
	
	
	
</body>
</html>