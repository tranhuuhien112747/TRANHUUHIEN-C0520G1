<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 04/09/2020
  Time: 4:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<style>
    th {
        align-items: center;
        color: #fd7e14;
        background-color: #343a40;
    }

    td {

        height: 35px;

    }

    tr {
        text-align: center;
        align-content: center;
    }
</style>
<body>
<%@include file="../common/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-xl-12" style="border: 1px solid darkblue">
            <div style="text-align: center;padding-top: 10px">
                <h2 style="color: red;font-weight: bold;font-size: 25px">List Employee of Furama </h2>
            </div>
            <div style="padding-top: 0px">
                <a class="btn btn-outline-success" href="/employee?action=create" role="button"  style="font-weight: bolder;font-size: 20px">Add New Employee</a>
            </div>
            <div class="table-responsive-lg">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Birthday</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employeeList}">
                        <tr>
                            <td>${employee.employeeId}</td>
                            <td>${employee.employeeName}</td>
                            <td>${employee.employeeBirthday}</td>
                            <td>${employee.employeePhone}</td>
                            <td>${employee.employeeEmail}</td>
                            <td>${employee.employeeAddress}</td>
                            <td style="color: goldenrod;font-weight: bolder">
                                <a href="/employee?action=view&id=${employee.employeeId}" class="btn btn-outline-info" role="button"><span
                                        class="fas fa-info mr-3">Detail</span></a>
                                <a href="/employee?action=edit&id=${employee.employeeId}" class="btn btn-outline-warning" role="button"><span
                                        class="fas fa-edit mr-3">Edit</span></a>
                                <a href="/employee?action=delete&id=${employee.employeeId}" class="btn btn-outline-danger" role="button"><span class="fas fa-eraser">Delete</span></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%--<%@include file="../common/footer.jsp" %>--%>
</body>
</html>
