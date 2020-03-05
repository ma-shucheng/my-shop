<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="../../static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
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
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">内容管理</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-6">
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
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbContent ==null?"新增":"编辑"}内容</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form cssClass="form-horizontal" action="/content/save" method="post" modelAttribute="tbContent">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="categoryId" class="col-sm-2 control-label">父级类目</label>
                                    <div class="col-sm-10">
                                        <!--隐藏选中路径，输入id对应名字-->
                                        <form:hidden path="categoryId"/>
                                        <input id="categoryName" class="form-control required" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-select"/>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>
                </div>
            </div>
            <!-- /.box -->
        </section>
    </div>

    <!-- /.footer -->
    <jsp:include page="../includes/footer.jsp"/>

</div>

<jsp:include page="../includes/body.jsp"/>
<script type="text/javascript" src="../../static/assets/plugins/jquery-ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="../../static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.js"></script>
<sys:model title="请选择" message="<ul id='myTree' class='ztree'></ul>"/>
<script>
    $(function () {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url:"/content/category/tree/data",
                autoParam:["id"],
            }
        };
        $.fn.zTree.init($("#myTree"), setting);
        $("#btnModalOk").bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree"),
                nodes = zTree.getSelectedNodes();
            //未选择
            if (nodes.length == 0) {
                alert("请先选择一节点");
            }
            //已选择
            else {
                var node = nodes[0];
                $("#categoryId").val(node.id);
                $("#categoryName").val(node.name);
            }
        })
    });
</script>
</body>
</html>
