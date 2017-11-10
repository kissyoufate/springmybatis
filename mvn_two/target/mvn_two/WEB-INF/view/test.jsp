<%--
  Created by IntelliJ IDEA.
  User: wudi
  Date: 2017/11/10
  Time: 下午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试页面</title>
</head>
<body>

<table border="1" style="margin: 0 auto">
    <tr>
        <th colspan="3">用户信息一览表</th>
    </tr>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
    </tr>
    <c:forEach items="${lists}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>******</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
