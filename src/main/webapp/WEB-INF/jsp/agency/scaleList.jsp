<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>返佣参数配置</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/agency/scaleList.js"></script>
<script type="text/javascript">
	function check(){
		 if($("#parentId").val() ==''){
			alert('请选择上级机构');
			return false;
		 }
		 var  re = /^1\d{10}$/;
		 var mobile = $("#mobile").val();
		 if (!re.test(mobile) || mobile =='') {
		     alert("结算人手机填写错误!");
		     return false;
		 }
		 
		 
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
<body  class="bootstrap-admin-with-small-navbar">
	 <div class="container">
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
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                                <div class="panel-heading">
                                    <div class="text-muted bootstrap-admin-box-title">返佣参数配置</div>
                                </div>
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                     <form class="form-horizontal">
                                        <fieldset>
                                        	 <legend>企业信息：</legend>
                                         		   <div class="form-group">
			                                                <label class="col-lg-2 control-label" for="agencyId">机构名称</label>
			                                                <div class="col-lg-4">
			                                                	<input type="hidden" id="userid"  value="${user.id }" /> 
			                                                	<input type="hidden" id="nickname" value="${user.nickname }" /> 
			                                                	<p class="form-control-static">${fanceAgency.agencyName }</p>
			                                                 	<input class="form-control disabled" id="agencyName" name="agencyName" type="hidden" value="${fanceAgency.agencyName }" />
			                                                </div>
			                                                
			                                                
			                                                <label class="col-lg-2 control-label" for="parentName">上级机构</label>
			                                                <div class="col-lg-4">
			                                                <p class="form-control-static">${fanceAgency.parentName }</p>
			                                                 	<input class="form-control disabled" id="parentName" name="parentName" type="hidden" value="${fanceAgency.parentName }" />
			                                                </div>
			                                                
			                                      </div>
			                               
			                                  <legend>分佣信息（所有数据均为万分比）：</legend>     
                                         
			                                            <div class="form-group">
			                                               			<label class="col-lg-2 control-label" for="businessType">交易类型</label> 
					                                                <div class="col-lg-4">
					                                                    <select id="businessType" class="form-control" style="width: 150px">
						                                               		<option value="">--请选择--</option>
						                                               		<c:forEach items="${busList }" var="businessType">
						                                               			<option value="${businessType.businessType }">${businessType.businessName }</option>
						                                              		 </c:forEach>
						                                               </select>
					                                                </div>
			                                                
			                                              		<label class="col-lg-2 control-label" for="begindate">生效日期</label> 
			                                              		 <div class="col-lg-4">
			                                              			 <input class="form-control datepicker" id="begindate" type="text" placeholder="请选择日期"  onfocus="this.blur();"  required data-date-startdate="${enddate}"  required oninvalid="setCustomValidity('必须填写！');" onchange="setCustomValidity('');">
			                                              		</div>
			                                              
			                                            </div>
			                                            
			                                            <div class="form-group">
			                                                <label class="col-lg-2 control-label" for="mycost">起始分佣比</label>
			                                                <div class="col-lg-2">
			                                                 	<input class="form-control" id="mycost" type="text" maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
			                                                </div>
			                                                
			                                                 <label class="col-lg-2 control-label" for="nextRate">上一级分佣</label>
			                                                <div class="col-lg-2">
			                                                 	<input class="form-control" id="nextRate" type="text" maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
			                                                </div>
			                                                
			                                                
			                                                <label class="col-lg-2 control-label" for="secondRate">上二级分佣</label>
			                                                <div class="col-lg-2">
			                                                 	<input class="form-control" id="secondRate"  type="text"  maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
			                                                </div>
			                                                
			                                              
			                                            </div>
			                                            
			                                             <div class="form-group">
				                                               <label class="col-lg-2 control-label" for="finalRate">上三级分佣</label>
				                                                <div class="col-lg-2">
				                                                 	<input class="form-control disabled" id="finalRate"  type="text"  maxlength='2' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
				                                                </div>
			                                             </div>
			                                       
			                                        <div class="form-group">
			                                            <div class="col-lg-12" align="center">
				                                            <button type="button" class="btn btn-primary" onclick="createTable();">添加至下方表格</button>
			                                            </div>
			                                       </div>
			                                            
			                              
                                    <legend></legend>
                                      					<div class="form-group">	
                                      					  <div class="col-lg-12">
                                      							<table id="scaleListTab" data-toggle="table">
																	    <thead>
																	    <tr>
																	        <th>序号</th>
																	        <th>交易类型</th>
																	        <th>起始分佣比</th>
																	        <th>上一级分佣比</th>
																	        <th>上二级分佣比</th>
																	        <th>上三级分佣比</th>
																	        <th>生效日期</th>
																	        <th>结束日期</th>
																	        <th>创建人</th>
																	        <th>创建时间</th>
																	        <th>是否新增</th>
																	        <th>是否生效</th>
																	        <th>操作</th>
																	    </tr>
																	    </thead>
																	    <tbody>
																	    	<c:forEach items="${scaleList }" var="fansAgency" varStatus="status">
																	    		<tr id="${ fansAgency.id}" class='tr-class-1'>
																	    			<td>${ status.index + 1}</td>
																	    			<td>${fansAgency.businessName }</td>
																	    			<td>${fansAgency.mycost }</td>
																	    			<td>${fansAgency.nextRate }</td>
																	    			<td>${fansAgency.secondRate }</td>
																	    			<td>${fansAgency.finalRate }</td>
																	    			<td>${fansAgency.begindate }</td>
																	    			<td>${fansAgency.enddate }</td>
																	    			<td>${fansAgency.userNames }</td>
																	    			<td>${fansAgency.datetime }</td>
																	    			<td>否</td>
																	    			<c:if test="${fansAgency.status }">
																	    			<td>已生效</td>
																	    			</c:if>
																	    			<c:if test="${!fansAgency.status }">
																	    			<td>待生效</td>
																	    			</c:if>
																	    			<td><c:if test="${!fansAgency.status }"><a href='#' onclick='showUpdateScaleForm(${fansAgency.id})'>修改</a>&nbsp;&nbsp;<a href='#' onclick="removeScale('${fansAgency.id}');">删除</a> </c:if></td>
																	    		</tr>
																	    	</c:forEach>
																	    </tbody>
																	</table>
																</div>
                                      				</div>
                                    <legend></legend>		
                                      			
                                      			<!-- <div class="form-group">	
		                                           <div class="col-lg-12" align="center">
			                                            <button type="button" class="btn btn-primary" onclick="saveTableCol();">保&nbsp;存</button>
			                                            <button type="reset" class="btn btn-default">取&nbsp;消</button>
		                                           </div>
	                                           </div> -->
                                        </fieldset>
                                  </form>
                                   <form class="form-horizontal" action="${ctx}/agency/saveAgencyScale" method="post" onsubmit="return saveTableCol();">
                                        <fieldset>
                                        		<div class="form-group">
                                        		<input type="hidden" id="agencyId" name="agencyId"  value="${fanceAgency.agencyId }" /> 	
                                        			<input type="hidden" id="jsonValue" name="jsonValue" /> 
		                                           <div class="col-lg-12" align="center">
			                                            <button type="submit" class="btn btn-primary">保&nbsp;存</button>
			                                            <button type="reset" class="btn btn-default" onclick="returnBack();">取&nbsp;消</button> 
		                                           </div>
	                                           </div>
                                        </fieldset>
                                    </form>    
                                </div>
                            </div>
                        </div>
                        
                    </div> 
	</div>
 <c:if test="${action == 'updateFansAgency' }">
 	<script type="text/javascript">
		 	 $(function() {
			      $("#parentIdSelect").addClass("disabled");
			      $("#parentIdSelect").attr("disabled",true);
		 	 });
		 	
 	</script>
 
 </c:if>	
	
</body>
</html>