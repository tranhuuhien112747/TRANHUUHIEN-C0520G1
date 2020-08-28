<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 27/08/2020
  Time: 9:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table,tr{
        border-collapse: collapse;
        border: 2px solid red;
        background-color: ghostwhite;
    }
    td{
        width: 150px;
        text-align: center;
    }
    th{
        height: 40px;
    }
</style>
<head>
    <title>Customer</title>
</head>
<body>
<table>
    <caption  style="color: darkblue;font-weight: bolder">List of Customer</caption>
    <tr id="header">
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th class="avatar">Avatar</th>
    </tr>

    <c:forEach var="element" items="${listCustomer}">
        <tr>
            <td>${element.name}</td>
            <td>${element.dateOfBirth}</td>
            <td>${element.address}</td>
            <td class="avatar"><img src='<c:out value="${element.image}"/>' alt="avatar" width="50px" height="50px"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
