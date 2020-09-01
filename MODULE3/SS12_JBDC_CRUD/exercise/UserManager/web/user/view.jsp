<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 31/08/2020
  Time: 7:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VIEW</title>
</head>
<body>
<table>
    <tr>
        <th></th>
        <th>Information:</th>
    </tr>
    <tr>
        <td>ID-User:</td>
        <td>${requestScope["user"].id}</td>
    </tr>
    <tr>
        <td>Name-User:</td>
        <td>${requestScope["user"].name}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${requestScope["user"].email}</td>
    </tr>
    <tr>
        <td>Country:</td>
        <td>${requestScope["user"].country}</td>
    </tr>
</table>
<div>
    <a role="button" href="/user">Back</a>
</div>
</body>
</html>
