<%--
  Created by IntelliJ IDEA.
  User: WWJ
  Date: 2020/1/26
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test" method="post">
    <input type="text" name="test">
    ${requestScope.msg}
    <input type="submit" value="提交">
</form>
</body>
</html>
