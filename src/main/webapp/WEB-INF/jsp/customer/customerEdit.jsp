<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>机构管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
</head>
<body  class="bootstrap-hsjiang-with-small-navbar">
	 <div class="container">
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                               
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                    <form class="form-horizontal" onsubmit="chartSubmit();return false;">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-lg-1 control-label" for="target">机构编码</label>
                                                <div class="col-lg-2">
                                                   <select id="reporttype" name="reporttype" class="selectize-select" style="width: 150px">
                                                        <option value='day'>按日</option>
                                                        <option value='month'>按月</option>
                                                    </select>
                                                </div>
                                                <label class="col-lg-1 control-label" for="datatype">企业名称</label>
                                                <div class="col-lg-2">
                                                    <input type="text" />
                                                  
                                                </div>
                                                 <label class="col-lg-1 control-label" for="datatype">状态</label>
                                                <div class="col-lg-2">
                                                    <input type="text" />
                                                  
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                            <label class="col-lg-1 control-label" for="reporttype">统计种类</label>
                                                <div class="col-lg-2">
                                                    <select id="reporttype" name="reporttype" class="selectize-select" style="width: 150px">
                                                        <option value='day'>按日</option>
                                                        <option value='month'>按月</option>
                                                    </select>
                                                </div>
                                                <label class="col-lg-1 control-label" for="begindate">日期</label>
                                                <div class="col-lg-2">
                                                     <input class="form-control datepicker" id="begindate" name="begindate" type="text" placeholder="请选择日期"  onfocus="this.blur();" required oninvalid="setCustomValidity('必须填写！');" onchange="setCustomValidity('');">
                                                </div>  
                                                
                                                <div class="col-lg-2">
                                                	<button type="submit" class="btn btn-primary">查&nbsp;询</button>
                                           			 <button type="reset" class="btn btn-default">取&nbsp;消</button>
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
						<div id="toolbar" class="btn-group">
						   <button id="btn_add" type="button" class="btn btn-default" onclick="addUser();">
						    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
						   </button>
						   <button id="btn_edit" type="button" class="btn btn-default" onclick="modifyUser();">
						    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
						   </button>
						 <button id="btn_delete" type="button" class="btn btn-default">
						    <span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="disable();"></span>删除
						   </button> 
						  </div>
						<table id="mytab" class="table table-hover"></table>
				</div>
		</div>				
	</div>
	
	
	
</body>
</html>