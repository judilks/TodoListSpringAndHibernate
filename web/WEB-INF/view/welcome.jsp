<%--
  Created by IntelliJ IDEA.
  User: judil
  Date: 8/8/2018
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="com.yash.todolist.model.Todo"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome!</title>
</head>
<body>
<h1>User Successfully Logged In, Information Below</h1>
Username -> ${user.username} <br />
<form action="../tasks/addTask" method="post">
    <table>
        <tr>
            <td>New Task:</td>
            <td><input type="text" name="task" /> <input type="hidden"
                                                         name="username" value="${user.username}" /></td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form>
<table id="incomplete" border="1">
    <thead>
    <tr>
        <th>Task</th>
        <th>Status</th>
        <th>Complete</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todoList}" var="todo">
        <c:if test="${todo.status == 0}">
            <tr>
                <td>${todo.task}</td>
                <td>Unfinished</td>
                <td style="text-align: center"><a href="../tasks/completeTask">x</a></td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
<table id="complete" border="1" style="display: none">
    <thead>
    <tr>
        <th>Task</th>
        <th>Status</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <c:if test="${todo.status == 1}">
            <tr>
                <td><del>${todo.task}</del></td>
                <td><del>Finished</del></td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
<button onClick="showCompletedTable()">Show Complete</button>
<button onClick="showIncompletedTable()">Show Todo</button>
</body>
</html>
<script type="text/javascript">
    function showCompletedTable() {
        document.getElementById('complete').style.display = "block";
        document.getElementById('incomplete').style.display = "none";
    }

    function showIncompletedTable() {
        document.getElementById('incomplete').style.display = "block";
        document.getElementById('complete').style.display = "none";
    }
</script>
