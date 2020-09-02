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
<style>
    th{
        width: 150px;
    }
    tr{
        border-collapse: collapse;
        border: 1px solid darkblue;
    }
</style>
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
    <tr style="color: red">
        <th>ID-User</th>
        <th>Name-User</th>
        <th>Email</th>
        <th>Country</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="user" items="${list}">
        <tr style="text-align: center;align-content: center">
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
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
