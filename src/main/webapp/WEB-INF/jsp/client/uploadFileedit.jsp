<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>

<%@ include file="../head.jsp"%>

 <link href="${ctx}/js/fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
 <link href="${ctx}/js/fileinput/themes/explorer/theme.css" media="all" rel="stylesheet" type="text/css"/>
 <script src="${ctx}/js/fileinput/js/plugins/sortable.js" type="text/javascript"></script>
 <script src="${ctx}/js/fileinput/js/fileinput.js" type="text/javascript"></script>
 <script src="${ctx}/js/fileinput/js/locales/fr.js" type="text/javascript"></script>
 <script src="${ctx}/js/fileinput/js/locales/es.js" type="text/javascript"></script>
 <script src="${ctx}/js/fileinput/themes/explorer/theme.js" type="text/javascript"></script>

<%--http://plugins.krajee.com/file-advanced-usage-demo#advanced-example-2 --%>
 <script>
    $(document).on('ready', function () {
   
	      $("#iconFileUpload").fileinput({
	    	  showPreview: true,
	    	  uploadUrl: '${ctx }/client/uploadIcon',
	    	  allowedFileExtensions : ['jpg', 'png','gif'],//允许的文件类型  
	    	  maxFilesNum: 1,//最多文件数量  
	          maxFilePreviewSize: 10240
	      }).on("fileuploaded", function(event, data, id, index) {
	    	  $("#clientIcon").val(data.response.url);
	      });    	  
    	  
    });
</script>


</head>
<body>
<br/><br/><br/><br/><br/>

<body  class="bootstrap-admin-with-small-navbar">
	 <div class="container">
	 	<div class="page-header">
		</div>
			     <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default bootstrap-admin-no-table-panel">
                               
                                <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                        	<form:form method="post" commandName="client">
                                        <fieldset>
                                            <div class="form-group">
											        <form:hidden path="id"/>
											        <form:hidden path="clientId"/>
											        <form:hidden path="clientSecret"/>
											
											        <div class="form-group">
											            <form:label path="clientName">客户端名：</form:label>
											            <form:input path="clientName"/>
											        </div>
											         <div class="form-group">
											            <form:label path="clientUri">访问地址：</form:label>
											            <form:input path="clientUri"/>
											        </div>
											        
											         <div class="form-group col-lg-5" >
											            <label>图标</label>
											           <input id="iconFileUpload" name="iconFileUpload" type="file" multiple class="file-loading" >
											       		<br/>
											      	  <form:button class="btn btn-primary">${op}</form:button>
											        </div>
											        
											         <div class="form-group">
											         	<input  type="hidden" id = "clientIcon" name ="clientIcon" />
											      	 </div>
												
                                                <div class="form-group">
                                                	<!-- <button type="submit" class="btn btn-primary">查&nbsp;询</button>
                                           			 <button type="reset" class="btn btn-default">清&nbsp;空</button> -->
                                            </div>
                                        </fieldset>
                                       </form:form>
                                       
                                </div>
                            </div>
                        </div>
                    </div>  
			
			
					
	</div>


    
</body>
</html>