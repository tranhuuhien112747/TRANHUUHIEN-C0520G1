<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 10/09/2020
  Time: 7:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATE</title>
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
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Add New Student</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-8" style="background-color: ghostwhite">
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="id">ID Student:</label>
                        <input type="text" class="form-control" name="id" id="id" placeholder="Example: HV-XXXX" required>
                    </div>
                    <div class="form-group">
                        <label for="name">Name Student:</label>
                        <input type="text" name="name" class="form-control" id="name" required>
                    </div>
                </div>
                <div class="col-xl-2"></div>
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="age">AGE :</label>
                        <input type="text" name="age" class="form-control" id="age" required>
                    </div>
                    <div class="form-group">
                        <label for="typeId">Type Student :</label><br>
                        <select id="typeId" name="typeId" style="width: 100%; height: 37px">
                            <option value="A1">Diamond</option>
                            <option value="A2">Gold</option>
                            <option value="A3">Silver</option>
                            <option value="A4">Member</option>
                        </select>
                    </div>
                    <div style="padding-top:15px">
                        <br>
                        <input class="btn btn-danger" style="margin-left: 20px;width: 80px" type="submit" role="button"
                               value="Save">
                        <a role="button" href="/student" class="btn btn-success"
                           style="margin-left: 110px;width: 80px">Back</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2"></div>
    </div>
</form>
</html>
