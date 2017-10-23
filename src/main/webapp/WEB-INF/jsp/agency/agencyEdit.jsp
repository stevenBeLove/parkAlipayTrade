<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>机构及权限管理</title>
<%@ include file="../head.jsp"%>
<script type="text/javascript">
		var ctx= '${ctx}';
</script>

<script src="${ctx}/js/suggest/src/bootstrap-suggest.js"></script>
<script src="${ctx}/js/pagejs/agency/agencyEdit.js"></script>


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
                                    <div class="text-muted bootstrap-admin-box-title">${op }</div>
                                </div>
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                     <form method="post" id="agencyForm" class="form-horizontal" action="${ctx}/agency/${action}" onsubmit="return check();">
                                        <fieldset>
                                         
                                         <c:if test="${action == 'insert' }">
                                         		 <input type="hidden" id="status" name="status" value="01">
			                                     <input type="hidden" id="userid" name="userid" value="${user.id }">
                                          <legend>导入机构：</legend>
                                        		<div class="form-group">
			                                                <label class="col-lg-2 control-label" for="target">导入已有机构</label>
			                                            	<div class="col-lg-4">
												                    <div class="input-group">
												                        <input type="text" class="form-control" id="importAgencySelect">
												                        <div class="input-group-btn">
												                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
												                                <span class="caret"></span>
												                            </button>
												                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
												                            </ul>
												                        </div>
												                        <!-- /btn-group -->
												                    </div>
												             </div>
			                                      </div>
			                               </c:if>
			                               
			                                      
                                          <legend>企业信息：</legend>
                                          <c:if test="${action == 'updateFansAgency' }">
			                               	 <input type="hidden" id="status" name="status" value="${fanceAgency.status }">
			                                 <input type="hidden" id="userid" name="userid" value="${fanceAgency.userid }">
		                                 </c:if>
                                          
                                          
			                                            <div class="form-group">
			                                                 <label class="col-lg-2 control-label" for="parentIdSelect">上级机构</label>
			                                                <div class="col-lg-4">
			                                                  		<div class="input-group">
			                                                  		
			                                                  		  <input type="hidden"  id="layer" name="layer" value="${fanceAgency.layer }" />
		                                                  			   <input type="hidden"  id="parentId" name="parentId" value="${fanceAgency.parentId }" />
		                                                  			   <input type="hidden"  id="parentName" name="parentName" value="${fanceAgency.parentName }"/>
												                       <input type="text" class="form-control" id="parentIdSelect" value="${ fanceAgency.parentName}">
												                        <div class="input-group-btn">
												                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
												                                <span class="caret"></span>
												                            </button>
												                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
												                            </ul>
												                        </div>
												                        <!-- /btn-group -->
												                    </div>
			                                                </div>
			                                                
			                                                
			                                                <label class="col-lg-2 control-label" for="agencyId">机构编码</label>
			                                                <div class="col-lg-4">
			                                                 	<input class="form-control disabled" id="agencyId" name="agencyId" type="text" readonly="readonly" value="${fanceAgency.agencyId }"  />
			                                                </div>
			                                            </div>
			                                            
			                                            <div class="form-group">
			                                                 <label class="col-lg-2 control-label" for="companyname">企业名称</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control disabled" id="agencyName" name="agencyName" type="text" value="${fanceAgency.agencyName }"  readonly="readonly"  />
			                                                </div>
			                                                
			                                                <label class="col-lg-2 control-label" for="focusedInput">法人信息</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control disabled" id="legalInfo" name="legalInfo" type="text" value="${qt1Agency.legalInfo }"  readonly="readonly" />
			                                                </div>
			                                            </div>
			                                          <%-- 
			                                         	<div class="form-group">
			                                                 <label class="col-lg-2 control-label" for="provinceid">省</label>
			                                                <div class="col-lg-4">
			                                                    <select id="provinceid" class="form-control" style="width: 150px">
				                                               </select>
			                                                </div>
			                                                
			                                                
			                                                <label class="col-lg-2 control-label" for="cityid">市</label>
			                                                <div class="col-lg-4">
			                                                    <select id="cityid" class="form-control"  style="width: 150px">
				                                               </select>
			                                                </div>
			                                            </div> 
			                                         --%>  
			                                            
			                                             <div class="form-group">
			                                                <label class="col-lg-2 control-label" for="companyaddr">企业地址</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control disabled" id="companyaddr" type="text" value="${qt1Agency.companyaddr }" readonly="readonly" />
			                                                </div>
			                                                
			                                                 <label class="col-lg-2 control-label" for="contactsname">联系人</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control disabled" id="contactsname"  type="text" value="${qt1Agency.contactsname }" readonly="readonly" />
			                                                </div>
			                                            </div>
			                              
                                    <legend>结算信息：</legend>
                                      				  <div class="form-group">
			                                                <label class="col-lg-2 control-label" for="mobile">结算人手机</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control" id="mobile" name="mobile" type="text"  value="${ fanceAgency.mobile}" required oninvalid="setCustomValidity('必须填写！');" oninput="setCustomValidity('');">
			                                                </div>
			                                                
			                                                 <label class="col-lg-2 control-label" for="name" >结算人姓名</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control" id="name" name="name" type="text" value="${ fanceAgency.name}" required oninvalid="setCustomValidity('必须填写！');" oninput="setCustomValidity('');" />
			                                                </div>
			                                            </div>
			                                            <div class="form-group">
			                                            
			                                            	  <label class="col-lg-2 control-label" for="bankname">结算人身份证号</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control" id="idCardNum" name="idCardNum" type="text" value="${fanceAgency.idCardNum}"  required oninvalid="setCustomValidity('必须填写！');" oninput="setCustomValidity('');" />
			                                                </div>
			                                            
			                                                <label class="col-lg-2 control-label" for="bankname">开户银行</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control" id="bankname" name="bankname" type="text" value="${ fanceAgency.bankname}"  required oninvalid="setCustomValidity('必须填写！');" oninput="setCustomValidity('');" />
			                                                </div>
			                                               
			                                            </div>
			                                            <div class="form-group">
			                                                <label class="col-lg-2 control-label" for="accountno">银行卡号</label>
			                                                <div class="col-lg-4">
			                                                    <input class="form-control" id="accountno" name="accountno" value="${fanceAgency.accountno }" type="text" required oninvalid="setCustomValidity('必须填写！');" oninput="setCustomValidity('');" />
			                                                </div>
			                                                 <div class="col-lg-4 control-label">
			                                                	 <button type="button" class="btn btn-primary" onclick="validateThreeElement();">验证姓名、身份证号、银行卡号四要素</button>
			                                                 </div>
			                                            </div>
			                                            
			                                            
			                                            <p style="color: blue;">！请确保结算人信息正确，并且结算信息为个人银行账户，系统将会把每月分润结算至该账户中</p>
                                          
                                           <div class="col-lg-12" align="center">
	                                            <button type="submit" class="btn btn-primary" id="submitBtn">${op }</button>
	                                            <button type="reset" class="btn btn-default" onclick="returnBack();">取&nbsp;消</button>
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