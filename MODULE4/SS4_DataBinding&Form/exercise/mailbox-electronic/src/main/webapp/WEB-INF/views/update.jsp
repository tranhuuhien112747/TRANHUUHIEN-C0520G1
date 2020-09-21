<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 21/09/2020
  Time: 5:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Updated</h2>
<table>
    <tr>
        <td>Language :</td>
        <td>${languages}</td>
    </tr>
    <tr>
        <td>Page Size :</td>
        <td>${pageSize}</td>
    </tr>
    <tr>
        <td>Spams Filter :</td>
        <td>${spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature :</td>
        <td>${signature}</td>
    </tr>
</table>
</body>
</html>
