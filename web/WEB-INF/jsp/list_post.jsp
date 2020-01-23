<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }/static" var="sp"></c:set>
<c:set value="${pageContext.request.contextPath }" var="rp"></c:set>
<html>
<head>
    <title>list_post</title>
    <link rel="stylesheet" href="${sp}/bootstrap/css/bootstrap.css${sp}/">
    <link rel="stylesheet" href="${sp}/layui/css/layui.css${sp}/">
    <script rel="script" src="${sp}/js/jquery.min.js${sp}/"></script>
    <script rel="script" src="${sp}/bootstrap/js/bootstrap.js${sp}/"></script>
    <script rel="script" src="${sp}/layui/layui.js${sp}/"></script>
</head>
<body>
<div>

    <jsp:include page="nav.jsp"></jsp:include>
</div>
<div>
    <ul id="list_posts">
        {% for post in post_list %}
        <li>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <a href="">{{ post['p_title'] }}</a>
                    </h3>
                </div>
                <div class="panel-body">
                    <div>{{ post['p_content'] }}</div>
                    <div>{{ post['p_datetime'] }}</div>
                </div>
            </div>
        </li>
        {% endfor %}

    </ul>

    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>

      
        {% for page in range(1,pages) %}
        {% if page_num == page %}
        <c:if test=""></c:if>
        <li class="active"><a href="/post_page?page={{ page }}">{{ page }}</a></li>
        {% else %}
        <li><a href="/post_page?page={{ page }}">{{ page }}</a></li>
        {% endif %}
        {% endfor %}
        <li><a href="#">&raquo;</a></li>
    </ul>
    <script>
        $(document).ready(function () {
        })
    </script>
</div>
