<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }/static" var="sp"></c:set>
<c:set value="${pageContext.request.contextPath }" var="rp"></c:set>
<html>
<head>
    <title>list_post</title>
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
    <ul id="list_posts">
        <c:forEach items="${requestScope.posts}" var="item">
            <li>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            <a href="">${item.title}</a>
                        </h3>
                    </div>
                    <div class="panel-body">
                        <div>${item.content}</div>
                        <div>${item.datetime}</div>
                    </div>
                </div>
            </li>
        </c:forEach>

    </ul>

    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <c:forEach begin="1" end="${pages}" step="1" var="page">
            <c:choose>
                <c:when test="${page==currentPage}">
                    <li class="active"><a href="${rp}/req/list?page=${ page }">${page}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${rp}/req/list?page=${ page }">${page }</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>


        <li><a href="#">&raquo;</a></li>
    </ul>
    <script>
        $(document).ready(function () {
        })
    </script>
</div>
