<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 04/09/2020
  Time: 4:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE</title>
</head>
<link rel="stylesheet" type="text/css" href="../bootstrap_4/jquery-ui-1.12.1/jquery-ui.css">
<style>
    label {
        color: darkblue;
        font-weight: bolder;
    }

    p {
        color: red;
        font-style: italic;
    }
</style>
<body>
<%@include file="../common/header.jsp" %>
<form method="post">
    <div class="container-fluid">
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray"> Edit Information Employee </h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-9" style="background-color: ghostwhite">
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="id">ID Employee:</label>
                        <input type="text" class="form-control" name="id" id="id"
                               value="${requestScope["employee"].employeeId}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="name">Name Employee:</label>
                        <input type="text" name="name" class="form-control" id="name"
                               value="${requestScope["employee"].employeeName}">
                    </div>
                    <div class="form-group">
                        <label for="birthday">Date Of Birthday:</label>
                        <input type="text" name="birthday" class="form-control" id="birthday"
                               value="${requestScope["employee"].employeeBirthday}">
                    </div>
                    <div class="form-group">
                        <label for="card">ID-Card Employee:</label>
                        <input type="text" name="card" class="form-control" id="card"
                               value="${requestScope["employee"].employeeIdCard}">
                        <c:if test='${requestScope["message"].get(0) != ""}'>
                            <p>${requestScope["message"].get(0)}</p>
                        </c:if>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="salary">Salary Employee:</label>
                        <input type="text" name="salary" class="form-control" id="salary"
                               value="${requestScope["employee"].employeeSalary}">
                        <c:if test='${requestScope["message"].get(1) != ""}'>
                            <p>${requestScope["message"].get(1)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Employee:</label>
                        <input type="text" name="phone" class="form-control" id="phone"
                               value="${requestScope["employee"].employeePhone}">
                        <c:if test='${requestScope["message"].get(2) != ""}'>
                            <p>${requestScope["message"].get(2)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="email">Email Employee:</label>
                        <input type="text" name="email" class="form-control" id="email"
                               value="${requestScope["employee"].employeeEmail}">
                        <c:if test='${requestScope["message"].get(3) != ""}'>
                            <p>${requestScope["message"].get(3)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="address">Address Employee:</label>
                        <input type="text" name="address" class="form-control" id="address"
                               value="${requestScope["employee"].employeeAddress}">
                    </div>
                    <div style="padding-top: 10px">
                        <input class="btn btn-danger" style="width: 80px" type="submit" role="button"
                               value="Save">
                        <a role="button" href="/employee" class="btn btn-success" style="float: right;width: 80px">Cancel</a>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-4">
                    <div class="form-group">
                        <label for="position">Position Employee:</label><br>
                        <select id="position" name="position" style="width: 100%; height: 37px">
                            <option value="${requestScope["employee"].employeePosition}">
                                <c:if test='${requestScope["employee"].employeePosition == 1}'>
                                    Receptionist
                                </c:if>
                                <c:if test='${requestScope["employee"].employeePosition == 2}'>
                                    Serve
                                </c:if>
                                <c:if test='${requestScope["employee"].employeePosition == 3}'>
                                    Professional
                                </c:if>
                                <c:if test='${requestScope["employee"].employeePosition == 4}'>
                                    Monitoring
                                </c:if>
                                <c:if test='${requestScope["employee"].employeePosition == 5}'>
                                    Manager
                                </c:if>
                                <c:if test='${requestScope["employee"].employeePosition == 6}'>
                                    President
                                </c:if>
                            </option>
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
                            <option value="${requestScope["employee"].employeeDivision}">
                                <c:if test='${requestScope["employee"].employeeDivision == 1}'>
                                    Sale – Marketing
                                </c:if>
                                <c:if test='${requestScope["employee"].employeeDivision == 2}'>
                                    Administration
                                </c:if>
                                <c:if test='${requestScope["employee"].employeeDivision == 3}'>
                                    Serve
                                </c:if>
                                <c:if test='${requestScope["employee"].employeeDivision == 4}'>
                                    Manager
                                </c:if>
                            </option>
                            <option value="1">Sale – Marketing</option>
                            <option value="2">Administration</option>
                            <option value="3">Serve</option>
                            <option value="4">Manager</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="education">Education-Degree Employee:</label><br>
                        <select id="education" name="education" style="width: 100%; height: 37px">
                            <option value="${requestScope["employee"].employeeEducation}">
                                <c:if test='${requestScope["employee"].employeeEducation == 1}'>
                                    Intermediate
                                </c:if>
                                <c:if test='${requestScope["employee"].employeeEducation == 2}'>
                                    Colleges
                                </c:if>
                                <c:if test='${requestScope["employee"].employeeEducation == 3}'>
                                    University
                                </c:if>
                                <c:if test='${requestScope["employee"].employeeEducation == 4}'>
                                    After university
                                </c:if>
                            </option>
                            <option value="1">Intermediate</option>
                            <option value="2">Colleges</option>
                            <option value="3">University</option>
                            <option value="4">After university</option>
                        </select>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="user">User:</label>--%>
<%--                        <input type="text" name="user" class="form-control" id="user"--%>
<%--                               value="${requestScope["employee"].userName}" readonly>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
        <div class="col-xl-1"></div>
    </div>
</form>
<script src="../bootstrap_4/bootstrap-4.5.2-dist/js/jquery-3.5.1.js"></script>
<script src="../bootstrap_4/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script>
    $( document ).ready(function() {
        $("#birthday").datepicker({ dateFormat: "dd/mm/yy" });
    });
</script>
</body>
</html>
