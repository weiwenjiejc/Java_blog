<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }/static" var="sp"></c:set>
<c:set value="${pageContext.request.contextPath }" var="rp"></c:set>
<html>
<head>
    <title>onePost</title>
    <link rel="stylesheet" href="${sp}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${sp}/layui/css/layui.css">
    <script rel="script" src="${sp}/js/jquery.min.js"></script>
    <script rel="script" src="${sp}/bootstrap/js/bootstrap.js"></script>
    <script rel="script" src="${sp}/layui/layui.js"></script>
</head>
<body style="background-color: #f5f6f7">
<div>
    <jsp:include page="../nav.jsp"></jsp:include>
</div>
<div class="row">
    <div class="col-md-8">
        <div style="padding: 30px; background-color: #FFFFFF">
            <div style="font-size: 28px; word-wrap: break-word; color: #000;">
                <div>${requestScope.onePost.title}</div>
                <div>
                    <span>发布时间:${requestScope.onePost.datetime}</span>
                    <span>阅读量:22</span>
                </div>
            </div>
            <div>
                ${requestScope.onePost.content}
            </div>
            <div>

                <span class="label label-info pull-left">wwj</span>
                <span class="label label-info pull-right">java</span>
                <span class="label label-info pull-right">python</span>
            </div>
        </div>
        <div style="padding: 30px;">
            <nav aria-label="...">
                <ul class="pager">
                    <li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> Older</a></li>
                    <li class="next"><a href="#">Newer <span aria-hidden="true">&rarr;</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="col-md-4" style="padding: 30px">
        <p>相似文章</p>

        <div class="list-group">
            <a href="#" class="list-group-item active">
                <h4 class="list-group-item-heading">List group item heading</h4>
                <p class="list-group-item-text">...</p>
            </a>
            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">List group item heading</h4>
                <p class="list-group-item-text">...</p>
            </a>
            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">List group item heading</h4>
                <p class="list-group-item-text">...</p>
            </a>
        </div>
    </div>
</div>
<div>
    <div>评论</div>
    <hr>
</div>
