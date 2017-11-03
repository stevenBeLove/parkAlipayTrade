<%@ page language="java"
	import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="baseHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理后台</title>
  <link rel="stylesheet" media="screen" href="${ctx}/css/common/cus-icons.css">
  <style>
  		#allmenu li span.glyphicon-tag + span{
  			padding-left: 8px;
  		}
  		#allmenu li span.glyphicon-user + span{
  			padding-left: 8px;
  		}
  </style>
</head>
<body class="bootstrap-hsjiang-body-with-small-navbar" style="overflow-x:hidden;overflow-y:hidden;">

	<nav
		class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar-sm"
		role="navigation">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="collapse navbar-collapse">

					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" role="button"
							class="dropdown-toggle" data-hover="dropdown"> <i
								class="glyphicon glyphicon-user"></i> ${user.nickname }，您好！ <i class="caret"></i></a>
							<ul class="dropdown-menu">
								<!--  <li><a href="#">个人信息</a></li>-->
								 <li><a href="#" onclick="javascript:document.getElementById('iframe1').src='${ctx}/reqPassword/${id }';">修改密码</a></li> 
								 <li role="presentation" class="divider"></li> 
								<li><a href="${ctx}/logout">退出</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	
	        <!-- main / large navbar -->
        <nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".main-navbar-collapse">
                                <span class="sr-only">首页</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="${ctx} " aria-hidden="true"><span class="glyphicon glyphicon-home"></span><span>首页</span></a>
                        </div>
                        <div class="collapse navbar-collapse main-navbar-collapse">
                          <ul class="nav navbar-nav" id="allmenu">

						<c:forEach var="m" items="${menus}">
							<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-hover="dropdown">
								<span class="${m.icon }"></span><span>${m.name}</span>
							<b class="caret"></b></a>
								<ul class="dropdown-menu">
										<c:forEach var="mm" items="${m.resourceList}">
											<li><a href="${pageContext.request.contextPath}/${mm.url}" target="myContent">${mm.name}</a></li>
										</c:forEach>
								</ul></li>
						</c:forEach>

					</ul>
                        </div><!-- /.navbar-collapse -->
                    </div>
                </div>
            </div><!-- /.container -->
        </nav>

	
		<div style="position:absolute;top:15px;bottom:10px;left:0px;right:0px;">
			
			<iframe class="content" frameborder="0" name="myContent" id="iframe1"
				width="100%" height="100%" src="${ctx}/park/parkList">
		    </iframe>
		</div>

	 <%--  <jsp:include page="footer.jsp"></jsp:include> 
 --%>
</body>

</html>