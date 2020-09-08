<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 07/09/2020
  Time: 10:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
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
                <h2 style="color: red;font-weight: bold;font-size: 25px">List Contract Detail </h2>
            </div>
            <div style="padding-top: 0px">
                <a class="btn btn-outline-success" href="/contractDetail?action=create" role="button"
                   style="font-weight: bolder;font-size: 20px">Add New Contract Detail</a>
            </div>
            <div class="table-responsive-lg">
                <table class="table table-striped" id="tableStudent" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">ID-Contract Detail</th>
                        <th scope="col">ID-Contract</th>
                        <th scope="col">Attach-Service</th>
                        <th scope="col">Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="contractDetail" items="${contractDetailList}">
                        <tr>
                            <td>${contractDetail.contractDetailId}</td>
                            <td>${contractDetail.contractId}</td>
                            <c:if test="${contractDetail.attachServiceId ==1}">
                                <td> Massage</td>
                            </c:if>
                            <c:if test="${contractDetail.attachServiceId == 2}">
                                <td> Karaoke</td>
                            </c:if>
                            <c:if test="${contractDetail.attachServiceId  == 3}">
                                <td> Food</td>
                            </c:if>
                            <c:if test="${contractDetail.attachServiceId  == 4}">
                                <td>Drink</td>
                            </c:if>
                            <c:if test="${contractDetail.attachServiceId == 5}">
                                <td>Car</td>
                            </c:if>
                            <td>${contractDetail.quantity}</td>
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
            "pageLength": 5
        });
    });
</script>
<script src="../bootstrap_4/datatables/js/jquery.dataTables.min.js"></script>
<%--<%@include file="../common/footer.jsp" %>--%>
</body>
</html>
