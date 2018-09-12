<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: judil
  Date: 8/9/2018
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Registration</h1>
<span style="color:red"> <form:errors path="user.*"></form:errors></span>
<form action="/registration/register">
    <input type="text" name="username"><br>
    <input type="text" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
