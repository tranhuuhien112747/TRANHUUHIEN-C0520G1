<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 28/08/2020
  Time: 10:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr {
            border-collapse: collapse;
            border: 2px solid red;
            background-color: ghostwhite;
            align-content: center;
            margin-left: 250px;
            margin-top: 50px;
        }

        td {
            width: 150px;
            text-align: center;
            font-weight: bolder;
        }

        th {
            height: 40px;
            font-size: 20px;
            font-weight: bolder;
            color: darkblue;
        }
    </style>
    <head>
        <title>Customer</title>
    </head>
<body>
<table>
    <caption style="color: red;font-weight: bolder;font-size: 40px">List of Customer</caption>
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
            <td class="avatar"><img src="${element.image}" alt="avatar" width="200px" height="200px"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
