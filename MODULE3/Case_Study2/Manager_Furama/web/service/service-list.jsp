<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 07/09/2020
  Time: 9:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST SERVICE</title>
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
                <h2 style="color: red;font-weight: bold;font-size: 25px">List Service of Furama </h2>
            </div>
            <div style="padding-top: 0px">
                <a class="btn btn-outline-success" href="/service?action=create" role="button"  style="font-weight: bolder;font-size: 20px">Add New Service</a>
            </div>
            <div class="table-responsive-lg">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID-Service</th>
                        <th scope="col">Name</th>
                        <th scope="col">Area-Service</th>
                        <th scope="col">Rent Cost</th>
                        <th scope="col">Rent-Type</th>
                        <th scope="col">Service-Type</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="service" items="${serviceList}">
                        <tr>
                            <td>${service.serviceId}</td>
                            <td>${service.serviceName}</td>
                            <td>${service.area}</td>
                            <td>${service.serviceCost}</td>
                            <c:if test='${service.rentTypeId == 1}'>
                                <td>Day</td>
                            </c:if>
                            <c:if test='${service.rentTypeId == 2}'>
                                <td>Week</td>
                            </c:if>
                            <c:if test='${service.rentTypeId == 3}'>
                                <td>Month</td>
                            </c:if>
                            <c:if test='${service.rentTypeId == 4}'>
                                <td>Year</td>
                            </c:if>
                            <c:if test='${service.rentTypeId == 5}'>
                                <td>Hour</td>
                            </c:if>
                            <c:if test='${service.serviceTypeId == 1}'>
                                <td>Villa</td>
                            </c:if>
                            <c:if test='${service.serviceTypeId == 2}'>
                                <td>House</td>
                            </c:if>
                            <c:if test='${service.serviceTypeId == 3}'>
                                <td>Room</td>
                            </c:if>
                            <td style="color: goldenrod;font-weight: bolder">
                                <a href="/service?action=view&id=${service.serviceId}" class="btn btn-outline-info" role="button"><span
                                        class="fas fa-info mr-3">Detail</span></a>
                                <a href="/service?action=edit&id=${service.serviceId}" class="btn btn-outline-warning" role="button"><span
                                        class="fas fa-edit mr-3">Edit</span></a>
                                <a href="/service?action=delete&id=${service.serviceId}" class="btn btn-outline-danger" role="button"><span class="fas fa-eraser">Delete</span></a>
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
