<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 04/09/2020
  Time: 4:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<link rel="stylesheet" href="../bootstrap_4/datatables/css/dataTables.bootstrap.min.css">
<style>
    th {
        align-items: center;
        color: #fd7e14;
        background-color: darkslategray;
        font-size: 20px;
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
                <h2 style="color: red;font-weight: bold;font-size: 25px">List Customer of Furama </h2>
            </div>
            <div style="padding-top: 0px">
                <a class="btn btn-outline-success" href="/customer?action=create" role="button"
                   style="font-weight: bolder;font-size: 20px">Add New Customer</a>
            </div>
            <div class="table-responsive-lg">
                <table class="table table-striped" id="tableStudent" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Birthday</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${customerList}">
                        <tr>
                            <td>${customer.customerId}</td>
                            <td>${customer.customerName}</td>
                            <td>${customer.customerBirthday}</td>
                            <c:if test='${customer.customerGender == 0}'>
                                <td>Female</td>
                            </c:if>
                            <c:if test='${customer.customerGender == 1}'>
                                <td>Male</td>
                            </c:if>
                            <td>${customer.customerEmail}</td>
                            <td>${customer.customerAddress}</td>
                            <td style="color: goldenrod;font-weight: bolder">
                                <a href="/customer?action=view&id=${customer.customerId}" class="btn btn-outline-info"
                                   role="button"><span
                                        class="fas fa-info mr-3">Detail</span></a>
                                <a href="/customer?action=edit&id=${customer.customerId}"
                                   class="btn btn-outline-warning" role="button"><span
                                        class="fas fa-edit mr-3">Edit</span></a>
                                <a href="/customer?action=delete&id=${customer.customerId}"
                                   class="btn btn-outline-danger" role="button"><span
                                        class="fas fa-eraser">Delete</span></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    });
</script>
<script src="../bootstrap_4/datatables/js/jquery.dataTables.min.js"></script>
</body>
</html>
