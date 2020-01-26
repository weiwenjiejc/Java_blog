<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }/static" var="sp"></c:set>
<c:set value="${pageContext.request.contextPath }" var="rp"></c:set>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${sp}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${sp}/layui/css/layui.css">
    <script rel="script" src="${sp}/js/jquery.min.js"></script>
    <script rel="script" src="${sp}/bootstrap/js/bootstrap.js"></script>
    <script rel="script" src="${sp}/layui/layui.js"></script>
</head>
<body>
<div>

    <jsp:include page="nav.jsp"></jsp:include>
</div>
<div>
    <!--中间部分-->
    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        最新博文
                    </h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">免费域名注册</li>
                        <li class="list-group-item">免费 Window 空间托管</li>
                        <li class="list-group-item">图像的数量</li>
                        <li class="list-group-item">24*7 支持</li>
                        <li class="list-group-item">每年更新成本</li>
                    </ul>
                </div>
            </div>

        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        带有 title 的面板标题
                    </h3>
                </div>
                <div class="panel-body">
                    面板内容
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        最热博文
                    </h3>
                </div>
                <div class="panel-body">
                    面板内容
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
