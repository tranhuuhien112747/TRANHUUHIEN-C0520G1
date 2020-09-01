<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 31/08/2020
  Time: 7:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List-User</title>
</head>
<body>
<h1>List User</h1>
<div>
    <a href="/user?action=create" role="button">Add New Users</a><br>
</div>
<div>
    <form action="/user">
        <input type="text" placeholder="Search" name="search">
        <input type="submit" value="search" name="action">
        <input type="submit" value="sort" name="action">
    </form>
</div>
<table>
    <tr>
        <th>ID-User</th>
        <th>Name-User</th>
        <th>Detail</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td><a href="/user?action=view&id=${user.id}">Detail</a></td>
            <td><a href="/user?action=delete&id=${user.id}">Delete</a></td>
            <td><a href="/user?action=update&id=${user.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<div>
    <a role="button" href="/user">Back</a>
</div>
</body>
</html>
