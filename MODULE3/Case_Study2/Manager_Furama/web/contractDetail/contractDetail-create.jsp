<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 07/09/2020
  Time: 9:56 CH
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
</style>
<body>
<%@include file="../common/header.jsp" %>
<form method="post">
    <div class="container-fluid">
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Add New Contract</h3>
        <div class="row">
            <div class="col-xl-4"></div>
            <div class="row col-xl-4" style="background-color: ghostwhite">
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="id">ID ContractDetail:</label>
                        <input type="text" class="form-control" name="id" id="id">
                    </div>
                    <div class="form-group">
                        <label for="contractID">ID-Contract :</label>
                        <select class="col-8 form-control" id="contractID" name="contractID" style="height: 37px">
                            <c:forEach var="contract" items="${contractList}">
                                <option value="${contract.contractId}">${contract.contractId}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-xl-2"></div>
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="attach">Attach-Service:</label>
                        <select id="attach" name="attach" style="width: 100%; height: 37px">
                            <option value="1">Massage</option>
                            <option value="2">Karaoke</option>
                            <option value="3">Food</option>
                            <option value="4">Drink</option>
                            <option value="5">Card</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <input type="text" class="form-control" name="quantity" id="quantity">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4"></div>
        <div style="padding-top:9px">
            <br>
            <input class="btn btn-danger" style="margin-left: 38%;width: 80px" type="submit" role="button"
                   value="Save">
            <a role="button" href="/contractDetail" class="btn btn-success" style="margin-left: 100px;width: 80px">Back</a>
        </div>
    </div>
</form>
</body>
</html>
