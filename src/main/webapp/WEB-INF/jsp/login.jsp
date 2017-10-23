<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
    <head>
        <title>闪电停平台</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap -->
        <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

        <!-- Bootstrap Admin Theme -->
        <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/js/static/css/bootstrap-admin-theme.css">

        <!-- Custom styles -->
        <style type="text/css">
             .error{
                color:red;
            }
        </style>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
           <script type="text/javascript" src="js/html5shiv.js"></script>
           <script type="text/javascript" src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bootstrap-admin-without-padding text-center"  style="background:url(${pageContext.request.contextPath}/js/static/images/bg22.png) no-repeat center;background-size:cover;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                			<div>
                		<!--  
                			 <div class="page-header bootstrap-admin-content-title"> -->
                                <h1 style="color:white"><b></b></h1>
                            </div> 
                            <div>
                                <h4  style="color:white"><b></b></h4>
                            </div> 
                    <form method="post" action="login" class="bootstrap-admin-login-form" >
                        <h1>登&nbsp;&nbsp;录</h1>
                        <div class="form-group">
                            <input class="form-control" type="text" name="username" placeholder="用户名"   required oninvalid="setCustomValidity('必须填写！');" oninput="setCustomValidity('');">
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="password" name="password" placeholder="密码" required oninvalid="setCustomValidity('必须填写！');" oninput="setCustomValidity('');">
                        </div>
                      <!--   
                        <div class="form-group">
                           	 自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
                        </div> -->
                          
                          <div class="form-group">
                        		<div class="error">${error}</div>
                          </div>
                        <button class="btn btn-lg btn-primary" type="submit">进&nbsp;入</button>
                    </form>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(function() {
                // Setting focus
                $('input[name="username"]').focus();

                // Setting width of the alert box
                var alert = $('.alert');
                var formWidth = $('.bootstrap-admin-login-form').innerWidth();
                var alertPadding = parseInt($('.alert').css('padding'));

                if (isNaN(alertPadding)) {
                    alertPadding = parseInt($(alert).css('padding-left'));
                }

                $('.alert').width(formWidth - 2 * alertPadding);
            });
          
        </script>
    </body>
</html>
