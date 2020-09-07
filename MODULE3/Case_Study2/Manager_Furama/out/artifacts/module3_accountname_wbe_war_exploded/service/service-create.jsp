<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 07/09/2020
  Time: 12:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="../bootstrap_4/bootstrap-4.5.2-dist/css/bootstrap.min.css">
<head>
    <title>CREATE</title>
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
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Add New Employee</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-9" style="background-color: ghostwhite">
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="id">ID Service:</label>
                        <input type="text" class="form-control" name="id" id="id" placeholder="Example: 1">
                    </div>
                    <div class="form-group">
                        <label for="name">Name Service:</label>
                        <input type="text" name="name" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                        <label for="area">Area Service:</label>
                        <input type="text" name="area" class="form-control" id="area">
                    </div>
                    <div class="form-group">
                        <label for="cost">Rent-Cost:</label>
                        <input type="text" name="cost" class="form-control" id="cost">
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="maxPeople">Max People:</label>
                        <input type="text" name="maxPeople" class="form-control" id="maxPeople">
                    </div>
                    <div class="form-group">
                        <label for="rentType">Rent Type:</label>
                        <select id="rentType" name="rentType" style="width: 100%; height: 37px">
                            <option value="1">Day</option>
                            <option value="2">Week</option>
                            <option value="3">Month</option>
                            <option value="4">Year</option>
                            <option value="5">Hour</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="typeService">Type Service:</label>
                        <select id="typeService" name="typeService" style="width: 100%; height: 37px">
                            <option value="1">Villa</option>
                            <option value="2">House</option>
                            <option value="3">Room</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="standardRoom">Standard Room:</label>
                        <input type="text" name="standardRoom" class="form-control" id="standardRoom">
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="description">Description Other:</label>
                        <input type="text" class="form-control" name="description" id="description">
                    </div>
                    <div class="form-group">
                        <label for="areaPool">Area Pool:</label>
                        <input type="text" name="areaPool" class="form-control" id="areaPool">
                    </div>
                    <div class="form-group">
                        <label for="numberFloor">Number Of Floor:</label>
                        <input type="text" name="numberFloor" class="form-control" id="numberFloor">
                    </div>
                    <div style="padding-top: 27px">
                        <input class="btn btn-danger" style="width: 80px" type="submit" role="button"
                               value="Save">
                        <a role="button" href="/service" class="btn btn-success"
                           style="float: right;width: 80px">Back</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-1"></div>
    </div>
</form>
<script src="../bootstrap_4/bootstrap-4.5.2-dist/js/jquery-3.5.1.js"></script>
<script src="../bootstrap_4/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
