<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 07/09/2020
  Time: 6:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    label {
        color: darkblue;
    }
    p{
        color: red;
        font-style: italic;
    }
</style>
<body>
<%@include file="../common/header.jsp" %>
<form method="post">
    <div class="container-fluid">
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Add New Contract</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-8" style="background-color: ghostwhite">
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="id">ID Contract:</label>
                        <input type="text" class="form-control" name="id" id="id" required>
                        <c:if test='${requestScope["message"].get(0) != ""}'>
                            <p >${requestScope["message"].get(0)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="start">Date Start :</label>
                        <input type="text" name="start" class="form-control" id="start" required>
                    </div>
                    <div class="form-group">
                        <label for="end">Date End :</label>
                        <input type="text" name="end" class="form-control" id="end" required>
                    </div>
                    <div class="form-group">
                        <label for="deposit">Deposit:</label>
                        <input type="text" name="deposit" class="form-control" id="deposit" required>
                        <c:if test='${requestScope["message"].get(1) != ""}'>
                            <p >${requestScope["message"].get(1)}</p>
                        </c:if>
                    </div>
                </div>
                <div class="col-xl-2"></div>
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="money">Total Money :</label>
                        <input type="text" name="money" class="form-control" id="money" required>
                        <c:if test='${requestScope["message"].get(2) != ""}'>
                            <p >${requestScope["message"].get(2)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="employeeId">ID-Employee:</label>
                        <select class="col-8 form-control" id="employeeId" name="employeeId" style="height: 37px">
                            <c:forEach var="employee" items="${employeeList}">
                                <option value="${employee.employeeId}">${employee.employeeId} - ${employee.employeeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="customerId">ID-Customer :</label>
                        <select class="col-8 form-control" id="customerId" name="customerId" style="height: 37px">
                            <c:forEach var="customer" items="${customerList}">
                                <option value="${customer.customerId}">${customer.customerId} - ${customer.customerName} </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="serviceId">ID-Service :</label><br>
                        <select class="col-8 form-control" id="serviceId" name="serviceId" style="height: 37px">
                            <c:forEach var="service" items="${serviceList}">
                                <option value="${service.serviceId}">${service.serviceId} - ${service.serviceName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2"></div>
        <div style="padding-top:9px">
            <br>
            <input class="btn btn-danger" style="margin-left: 38%;width: 80px" type="submit" role="button"
                   value="Save">
            <a role="button" href="/contract" class="btn btn-success" style="margin-left: 120px;width: 80px">Back</a>
        </div>
    </div>
</form>
</body>
</html>
