<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 04/09/2020
  Time: 4:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="../bootstrap_4/bootstrap-4.5.2-dist/css/bootstrap.min.css">
<script src="../bootstrap_4/bootstrap-4.5.2-dist/js/jquery-3.5.1.js"></script>
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
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Add New Employee</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-9" style="background-color: ghostwhite">
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="id">ID Employee:</label>
                        <input type="text" class="form-control" name="id" id="id" placeholder="Example: 1001" required>
                        <c:if test='${requestScope["message"].get(0) != ""}'>
                            <p >${requestScope["message"].get(0)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="name">Name Employee:</label>
                        <input type="text" name="name" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                        <label for="birthday">Date Of Birthday:</label>
                        <input type="text" name="birthday" class="form-control" id="birthday">
                    </div>
                    <div class="form-group">
                        <label for="card">ID-Card Employee:</label>
                        <input type="text" name="card" class="form-control" id="card">
                        <c:if test='${requestScope["message"].get(1) != ""}'>
                            <p >${requestScope["message"].get(1)}</p>
                        </c:if>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="salary">Salary Employee:</label>
                        <input type="text" name="salary" class="form-control" id="salary">
                        <c:if test='${requestScope["message"].get(2) != ""}'>
                            <p >${requestScope["message"].get(2)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Employee:</label>
                        <input type="text" name="phone" class="form-control" id="phone">
                        <c:if test='${requestScope["message"].get(3) != ""}'>
                            <p >${requestScope["message"].get(3)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="email">Email Employee:</label>
                        <input type="text" name="email" class="form-control" id="email">
                        <c:if test='${requestScope["message"].get(4) != ""}'>
                            <p >${requestScope["message"].get(4)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="address">Address Employee:</label>
                        <input type="text" name="address" class="form-control" id="address">
                    </div>
                    <div style="padding-top: 10px">
                        <input class="btn btn-danger" style="width: 80px" type="submit" role="button"
                               value="Save">
                        <a role="button" href="/employee" class="btn btn-success"
                           style="float: right;width: 80px">Back</a>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="position">Position Employee:</label><br>
                        <select id="position" name="position" style="width: 100%; height: 37px">
                            <option value="1">Receptionist</option>
                            <option value="2">Serve</option>
                            <option value="3">Professional</option>
                            <option value="4">Monitoring</option>
                            <option value="5">Manager</option>
                            <option value="6">President</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="division">Division Employee:</label><br>
                        <select id="division" name="division" style="width: 100%; height: 37px">
                            <option value="1">Sale – Marketing</option>
                            <option value="2">Administration</option>
                            <option value="3">Serve</option>
                            <option value="4">Manager</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="education">Education-Degree Employee:</label><br>
                        <select id="education" name="education" style="width: 100%; height: 37px">
                            <option value="1">Intermediate</option>
                            <option value="2">Colleges</option>
                            <option value="3">University</option>
                            <option value="4">After university</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="user">User:</label>
                        <input type="text" name="user" class="form-control" id="user">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-1"></div>
    </div>
</form>
</body>
</html>
