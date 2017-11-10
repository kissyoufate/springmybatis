<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!jjjjjj</h2>
<a href="/test/getAllUser">获取所有用户</a>
<a href="#">添加一个用户</a>
<form action="/test/addUser" method="post">
    用户名<input type="text" name="name"><br>
    密 码<input type="password" name="password"><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
