<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 04/09/2020
  Time: 4:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETE-CUSTOMER</title>
</head>
<style>
    label{
        color: darkblue;
        font-weight: bolder;
    }
</style>
<body>
<%@include file="../common/header.jsp" %>
<form method="post">
    <div class="container-fluid">
        <h4 style="text-align: center;color: #fd7e14;background-color: darkslategray"> You want to delete the [ ${requestScope["customer"].customerName} ] customer. Are you sure ?</h4>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-8" style="background-color: ghostwhite">
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="id">ID Customer:</label>
                        <input type="text" class="form-control" name="id" id="id" value="${requestScope["customer"].customerId}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="name">Name Customer:</label>
                        <input type="text" name="name" class="form-control" id="name" value="${requestScope["customer"].customerName}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Date Of Birthday:</label>
                        <input type="text" name="birthday" class="form-control" id="birthday"
                               value="${requestScope["customer"].customerBirthday}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <input type="text" name="gender" class="form-control" id="gender"
                               value="${requestScope["customer"].customerGender}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="card">ID-Card Customer:</label>
                        <input type="text" name="card" class="form-control" id="card"
                               value="${requestScope["customer"].customerIdCard}" readonly>
                    </div>
                </div>
                <div class="col-xl-2"></div>
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="phone">Phone Customer:</label>
                        <input type="text" name="phone" class="form-control" id="phone"
                               value="${requestScope["customer"].customerPhone}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="email">Email Customer:</label>
                        <input type="text" name="email" class="form-control" id="email"
                               value="${requestScope["customer"].customerEmail}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="address">Address Customer:</label>
                        <input type="text" name="address" class="form-control" id="address"
                               value="${requestScope["customer"].customerAddress}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="typeId">Type Customer:</label>
                        <c:if test='${requestScope["customer"].customerTypeId == 1}'>
                            <input type="text" class="col-8 form-control" id="typeId" name="typeId" value="Diamond" readonly>
                        </c:if>
                        <c:if test='${requestScope["customer"].customerTypeId == 2}'>
                            <input type="text" class="col-8 form-control" id="typeId" name="typeId" value="Platinum" readonly>
                        </c:if>
                        <c:if test='${requestScope["customer"].customerTypeId == 3}'>
                            <input type="text" class="col-8 form-control" id="typeId" name="typeId" value="Gold" readonly>
                        </c:if>
                        <c:if test='${requestScope["customer"].customerTypeId == 4}'>
                            <input type="text" class="col-8 form-control" id="typeId" name="typeId" value="Silver" readonly>
                        </c:if>
                        <c:if test='${requestScope["customer"].customerTypeId == 5}'>
                            <input type="text" class="col-8 form-control" id="typeId" name="typeId" value="Member" readonly>
                        </c:if>
                    </div>
                    <div>
                        <br>
                        <input class="btn btn-danger" style="margin-left: 40px" type="submit" role="button"
                               value="Delete">
                        <a role="button" href="/customer" class="btn btn-success" style="margin-left: 120px">Cancel</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2"></div>
    </div>
</form>
</body>
</html>
