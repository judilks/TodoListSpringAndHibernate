<%--
  Created by IntelliJ IDEA.
  User: judil
  Date: 8/10/2018
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Login</h1>
<span style="color:red"> <form:errors path="user.*"></form:errors></span>
<form action="/authentication/authenticate">
    <input type="text" name="username"><br>
    <input type="text" name="password"><br>
    <input type="submit" value="login">
    <input type="submit" formaction="/registration/registerform" value="register">
</form>
</body>
</html>
