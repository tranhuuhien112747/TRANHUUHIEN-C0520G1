<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 08/09/2020
  Time: 9:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="../bootstrap_4/datatables/css/dataTables.bootstrap.min.css">
<head>
    <title>Title</title>
</head>
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
                <h2 style="color: red;font-weight: bold;font-size: 25px">List Customer User Service Of Furama</h2>
            </div>
            <div class="table-responsive-lg">
                <table class="table table-striped" id="tableStudent" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Name-Customer</th>
                        <th scope="col">ID-Customer</th>
                        <th scope="col">ID-Service</th>
                        <th scope="col">Name-Service</th>
                        <th scope="col">ID-Contract</th>
                        <th scope="col">Attach-Service</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="userServiceList" items="${userServiceList}">
                        <tr>
                            <td>${userServiceList.customerName}</td>
                            <td>${userServiceList.customerId}</td>
                            <td>${userServiceList.serviceId}</td>
                            <td>${userServiceList.serviceName}</td>
                            <td>${userServiceList.contractId}</td>
                            <td>${userServiceList.attachServiceName}</td>
                            <td style="color: goldenrod;font-weight: bolder">
                                <a href="/service?action=edit&id=${userServiceList.serviceId}" class="btn btn-outline-warning"
                                   role="button"><span
                                        class="fas fa-edit mr-3">Edit</span></a>
                                <a href="/service?action=delete&id=${userServiceList.serviceId}" class="btn btn-outline-danger"
                                   role="button"><span class="fas fa-eraser">Delete</span></a>
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
