<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/assets/bower_components/jquery-ui/themes/ui-darkness/jquery-ui.min.css">
    <link rel="stylesheet" href="../../static/assets/plugins/treeTable/themes/vsStyle/treeTable.min.css">
</head>
<body>
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
    <!-- jQuery 3 -->
    <script src="../../static/assets/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="../../static/assets/bower_components/jquery-ui/jquery-ui.min.js"></script>
    <!-- /.box-body -->
    <script type="text/javascript" src="../../static/assets/plugins/treeTable/jquery.treeTable.min.js"></script>
    <script>
        $(function () {
            $('#treeTable').treeTable({
                expandLevel: 2,
                expandable:true,
                stringExpand:"展开"
            });
        })
    </script>
</body>
</html>
