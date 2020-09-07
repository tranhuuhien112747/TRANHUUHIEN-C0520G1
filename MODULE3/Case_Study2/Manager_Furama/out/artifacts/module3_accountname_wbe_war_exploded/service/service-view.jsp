<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 07/09/2020
  Time: 11:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<style>
    label {
        color: darkblue;
        font-weight: bolder;
    }
</style>
<body>
<%@include file="../common/header.jsp" %>
<form method="post">
    <div class="container-fluid">
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Information Service Of Furama</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-9" style="background-color: ghostwhite">
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="id">ID Service:</label>
                        <input type="text" class="form-control" name="id" id="id"
                               value="${requestScope["service"].serviceId}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="name">Name Service:</label>
                        <input type="text" name="name" class="form-control" id="name"
                               value="${requestScope["service"].serviceName}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="area">Area Service:</label>
                        <input type="text" name="area" class="form-control" id="area"
                               value="${requestScope["service"].area}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="cost">Rent-Cost:</label>
                        <input type="text" name="cost" class="form-control" id="cost"
                               value="${requestScope["service"].serviceCost}" readonly>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="maxPeople">Max People:</label>
                        <input type="text" name="maxPeople" class="form-control" id="maxPeople"
                               value="${requestScope["service"].maxPeople}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="rentType">Rent Type:</label>
                        <c:if test='${requestScope["service"].rentTypeId == 1}'>
                            <input type="text" class="col-8 form-control" id="rentType" name="rentType"
                                   value="Day" readonly>
                        </c:if>
                        <c:if test='${requestScope["service"].rentTypeId == 2}'>
                            <input type="text" class="col-8 form-control" id="rentType" name="rentType" value="Week"
                                   readonly>
                        </c:if>
                        <c:if test='${requestScope["service"].rentTypeId == 3}'>
                            <input type="text" class="col-8 form-control" id="rentType" name="rentType"
                                   value="Month" readonly>
                        </c:if>
                        <c:if test='${requestScope["service"].rentTypeId == 4}'>
                            <input type="text" class="col-8 form-control" id="rentType" name="rentType"
                                   value="Year" readonly>
                        </c:if>
                        <c:if test='${requestScope["service"].rentTypeId == 5}'>
                            <input type="text" class="col-8 form-control" id="rentType" name="rentType" value="Hour"
                                   readonly>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="typeService">Type Service:</label>
                        <c:if test='${requestScope["service"].serviceTypeId == 1}'>
                            <input type="text" class="col-8 form-control" id="typeService" name="typeService"
                                   value="Villa" readonly>
                        </c:if>
                        <c:if test='${requestScope["service"].serviceTypeId == 2}'>
                            <input type="text" class="col-8 form-control" id="typeService" name="typeService"
                                   value="House"
                                   readonly>
                        </c:if>
                        <c:if test='${requestScope["service"].serviceTypeId == 3}'>
                            <input type="text" class="col-8 form-control" id="typeService" name="typeService"
                                   value="Room" readonly>
                        </c:if>
                    </div>
                    <c:if test='${requestScope["service"].serviceTypeId == 1 ||requestScope["service"].serviceTypeId==2}'>
                    <div class="form-group">
                        <label for="standardRoom">Standard Room:</label>
                        <input type="text" name="standardRoom" class="form-control" id="standardRoom"
                               value="${requestScope["service"].standardRoom}" readonly>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="description">Description Other:</label>
                        <input type="text" class="form-control" name="description" id="description"
                               value="${requestScope["service"].description}" readonly>
                    </div>
                    <c:if test='${requestScope["service"].serviceTypeId == 1}'>
                        <div class="form-group">
                            <label for="areaPool">Area Pool:</label>
                            <input type="text" name="areaPool" class="form-control" id="areaPool"
                                   value="${requestScope["service"].areaPool}" readonly>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label for="numberFloor">Number Of Floor:</label>
                        <input type="text" name="numberFloor" class="form-control" id="numberFloor"
                               value="${requestScope["service"].numberFloor}" readonly>
                    </div>
                </div>
                </c:if>
            </div>
        </div>
        <div class="col-xl-1"></div>
        <div>
            <a role="button" href="/service" class="btn btn-danger"
               style="margin-left: 50%;width: 80px">Close</a>
        </div>
    </div>
</form>
</body>
</html>
