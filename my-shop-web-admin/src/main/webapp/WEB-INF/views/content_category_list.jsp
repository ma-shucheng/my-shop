<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="../../static/assets/bower_components/jquery-ui/themes/ui-darkness/jquery-ui.min.css">
    <link rel="stylesheet" href="../../static/assets/plugins/treeTable/demo/style/demo.css">
    <link rel="stylesheet" href="../../static/assets/plugins/treeTable/themes/vsStyle/treeTable.min.css">
    <link rel="stylesheet" href="../../static/assets/plugins/treeTable/themes/default/treeTable.min.css">
    <title>我的商城 | 内容管理</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<jsp:include page="../includes/net.jsp"/>

<div class="wrapper">
    <!--main header-->
    <jsp:include page="../includes/main-header.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../includes/left-side.jsp"/>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                主页面
                <small>内容管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">内容管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="box">
                            <div class="box-header with-border callout callout-${baseResult.status==200?"success":"danger"}">
                                <h3 class="box-title">${baseResult.message}</h3>

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
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                            <div class="row" style="padding-left: 12px; padding-top: 10px;">
                                <button type="button" class="btn btn-sm btn-success" data-toggle="modal" data-target="#modal-success"><i class="fa fa-plus"></i>新增</button>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#modal-danger"><i class="fa fa-trash-o"></i>删除</button>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-info" data-toggle="modal" data-target="#modal-info"><i class="fa fa-download"></i>导入</button>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal-default"><i class="fa fa-upload"></i>导出</button>&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                    <tr id="${tbContentCategory.id}" pId="${tbContentCategory.parentId}">
                                        <th>${tbContentCategory.id}</th>
                                        <th>${tbContentCategory.name}</th>
                                        <th>${tbContentCategory.sortOrder}</th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>


    <!-- /.content-wrapper -->
    <jsp:include page="../includes/footer.jsp"/>

</div>

<jsp:include page="../includes/body.jsp"/>
<script type="text/javascript" src="../../static/assets/plugins/treeTable/jquery.treeTable.min.js"></script>
<script type="text/javascript" src="../../static/assets/plugins/treeTable/jquery.treeTable.js"></script>
<script>
    $(function () {

    });
</script>
</body>
</html>
