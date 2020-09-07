<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 07/09/2020
  Time: 4:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                <h2 style="color: red;font-weight: bold;font-size: 25px">List Contract </h2>
            </div>
            <div style="padding-top: 0px">
                <a class="btn btn-outline-success" href="/contract?action=create" role="button"
                   style="font-weight: bolder;font-size: 20px">Add New Contract</a>
            </div>
            <div class="table-responsive-lg">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID-Contract</th>
                        <th scope="col">Time-Star</th>
                        <th scope="col">Time-End</th>
                        <th scope="col">Deposit</th>
                        <th scope="col">Total-Money</th>
                        <th scope="col">ID-Employee</th>
                        <th scope="col">ID-Customer</th>
                        <th scope="col">ID-Service</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="contract" items="${contractList}">
                        <tr>
                            <td>${contract.contractId}</td>
                            <td>${contract.contractStart}</td>
                            <td>${contract.contractEnd}</td>
                            <td>${contract.contractDeposit}</td>
                            <td>${contract.contractMoneyTotal}</td>
                            <td>${contract.employeeId}</td>
                            <td>${contract.customerId}</td>
                            <td>${contract.serviceId}</td>
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
