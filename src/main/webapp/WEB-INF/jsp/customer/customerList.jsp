<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>客户管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/customer/customer.js"></script>
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
			<h3>客户管理</h3>
		</div>
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                               
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                    <form class="form-horizontal" onsubmit="reloadDate();return false;">
                                        <fieldset>
                                       	 <div class="form-group">
                                                <label class="col-lg-2 control-label" for="customerid">客户号</label>
                                                <div class="col-lg-3">
                                                    <input type="text" id="customerid" class="form-control" />
                                                </div>
                                                <label class="col-lg-2 control-label" for="mobile">手机号</label>
                                                <div class="col-lg-3">
                                                    <input type="text" id="mobile" name="mobile" class="form-control" />
                                                </div>
                                                 <div class="col-lg-2">
                                                	<button type="button" class="btn btn-primary" onclick="reloadDate()">查&nbsp;询</button>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-2 control-label" for="customerName">姓名</label>
                                                <div class="col-lg-3">
                                                    <input type="text" id="customerName" name ="customerName" class="form-control" />
                                                </div>
                                                <label class="col-lg-2 control-label" for="payTerminalId">终端号</label>
                                                <div class="col-lg-3">
                                                    <input type="text" id="payTerminalId" name="payTerminalId" class="form-control" />
                                                </div>
                                                 <div class="col-lg-2">
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
						<table id="mytab" class="table table-hover"></table>
				</div>
		</div>				
	</div>
	
	
	
</body>
</html>