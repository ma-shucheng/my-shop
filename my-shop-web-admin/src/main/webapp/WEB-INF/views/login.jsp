<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!--Head Begin-->
<head>

    <jsp:include page="../includes/header.jsp"/>
    <title>我的商城 | 登录</title>


    

</head>
<!--Head End-->

<!--Body Begin-->
<body class="hold-transition login-page">


<jsp:include page="../includes/net.jsp"/>

<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>我的商城</b></a>
    </div>

    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">开始你的购物吧！</p>
        <form action="/login" method="post">

            <!-- warning-->
            <c:if test="${message != null}">
                <div class="box">
                    <div class="box-header with-border callout callout-danger">
                        <h3 class="box-title">${message}</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                <i class="fa fa-minus"></i></button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
                                <i class="fa fa-times"></i></button>
                        </div>
                    </div>
                    <!-- /.box-footer-->
                </div>
            </c:if>
            <!-- sign in-->
            <div class="form-group has-feedback">
                <input name="email" type="email" class="form-control" placeholder="邮箱" value="${email}">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="loginPwd" type="password" class="form-control" placeholder="密码" value="${loginPwd}">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input name="remMe" type="checkbox" ${remMe == true?"checked":""}> 记住我
                        </label>
                        <label>
                            <input name="autoSign" type="checkbox"> 自动登录
                        </label>
                    </div>
                </div>

                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->

            </div>
        </form>

        <!-- /.social-auth-links -->
        <a href="#">忘记密码？</a><br>
    </div>
</div>

<jsp:include page="../includes/body.jsp"/>
</body>
<!--Body End-->
</html>