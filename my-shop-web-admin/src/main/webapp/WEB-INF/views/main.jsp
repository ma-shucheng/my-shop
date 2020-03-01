<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../includes/header.jsp"/>
    <title>我的商城</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<jsp:include page="../includes/net.jsp"/>

<div class="wrapper">
    <jsp:include page="../includes/main-header.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../includes/left-side.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                主页面
                <small>商品栏</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">主页面</li>
            </ol>
        </section>
    </div>

    <!-- /.footer -->
    <jsp:include page="../includes/footer.jsp"/>

</div>

<jsp:include page="../includes/body.jsp"/>
</body>
</html>
