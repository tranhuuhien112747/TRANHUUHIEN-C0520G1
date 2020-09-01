<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 30/08/2020
  Time: 9:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View-Product</title>
</head>
<body>
<table>
    <tr>
        <th></th>
        <th>Information:</th>
    </tr>
    <tr>
        <td>ID-Product:</td>
        <td>${requestScope["product"].id}</td>
    </tr>
    <tr>
        <td>Name-Product:</td>
        <td>${requestScope["product"].name}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${requestScope["product"].price}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${requestScope["product"].description}</td>
    </tr>
    <tr>
        <td>Producer:</td>
        <td>${requestScope["product"].producer}</td>
    </tr>
</table>
</body>
</html>