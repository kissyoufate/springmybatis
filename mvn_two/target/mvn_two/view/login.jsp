<%--
  Created by IntelliJ IDEA.
  User: Gary Wong
  Date: 2017/11/12
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
    <form action="/user/login" method="post">
        账号:<input type="text" name="name"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
<p style="color: red">${error}</p>
</body>
</html>
