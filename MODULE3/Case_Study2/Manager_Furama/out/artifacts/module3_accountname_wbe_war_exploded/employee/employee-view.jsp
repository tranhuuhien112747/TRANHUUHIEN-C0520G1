<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 06/09/2020
  Time: 9:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VIEW</title>
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
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Information Employee</h3>
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
                               value="${requestScope["employee"].employeeName}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Date Of Birthday:</label>
                        <input type="text" name="birthday" class="form-control" id="birthday"
                               value="${requestScope["employee"].employeeBirthday}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="card">ID-Card Employee:</label>
                        <input type="text" name="card" class="form-control" id="card"
                               value="${requestScope["employee"].employeeIdCard}" readonly>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-3">
                    <div class="form-group">
                        <label for="salary">Salary Employee:</label>
                        <input type="text" name="salary" class="form-control" id="salary"
                               value="${requestScope["employee"].employeeSalary}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Employee:</label>
                        <input type="text" name="phone" class="form-control" id="phone"
                               value="${requestScope["employee"].employeePhone}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="email">Email Employee:</label>
                        <input type="text" name="email" class="form-control" id="email"
                               value="${requestScope["employee"].employeeEmail}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="address">Address Employee:</label>
                        <input type="text" name="address" class="form-control" id="address"
                               value="${requestScope["employee"].employeeAddress}" readonly>
                    </div>
                    <div style="padding-top: 10px">
                        <a role="button" href="/employee" class="btn btn-danger"
                           style="margin-left: 50% ;width: 80px">Close</a>
                    </div>
                </div>
                <div class="col-xl-1"></div>
                <div class="col-xl-4">
                    <div class="form-group">
                        <label for="position">Position Employee:</label><br>
                        <c:if test='${requestScope["employee"].employeePosition == 1}'>
                            <input type="text" class="col-8 form-control" id="position" name="position"
                                   value="Receptionist" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeePosition == 2}'>
                            <input type="text" class="col-8 form-control" id="position" name="position" value="Serve"
                                   readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeePosition == 3}'>
                            <input type="text" class="col-8 form-control" id="position" name="position"
                                   value="Professional" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeePosition == 4}'>
                            <input type="text" class="col-8 form-control" id="position" name="position"
                                   value="Monitoring" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeePosition == 5}'>
                            <input type="text" class="col-8 form-control" id="position" name="position" value="Manager"
                                   readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeePosition == 6}'>
                            <input type="text" class="col-8 form-control" id="position" name="position"
                                   value="President" readonly>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="division">Division Employee:</label><br>
                        <c:if test='${requestScope["employee"].employeeDivision == 1}'>
                            <input type="text" class="col-8 form-control" id="division" name="division"
                                   value="Sale – Marketing" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeeDivision == 2}'>
                            <input type="text" class="col-8 form-control" id="division" name="division"
                                   value="Administration"
                                   readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeeDivision == 3}'>
                            <input type="text" class="col-8 form-control" id="division" name="division"
                                   value="Serve" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeeDivision == 4}'>
                            <input type="text" class="col-8 form-control" id="division" name="division"
                                   value="Manager" readonly>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="education">Education-Degree Employee:</label><br>
                        <c:if test='${requestScope["employee"].employeeEducation == 1}'>
                            <input type="text" class="col-8 form-control" id="education" name="education"
                                   value="Intermediate" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeeEducation == 2}'>
                            <input type="text" class="col-8 form-control" id="education" name="education"
                                   value="Colleges" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeeEducation == 3}'>
                            <input type="text" class="col-8 form-control" id="education" name="education"
                                   value="University" readonly>
                        </c:if>
                        <c:if test='${requestScope["employee"].employeeEducation == 4}'>
                            <input type="text" class="col-8 form-control" id="education" name="education"
                                   value="After university" readonly>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="user">User:</label>
                        <input type="text" name="user" class="form-control" id="user"
                               value="${requestScope["employee"].userName}" readonly>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-1"></div>
    </div>
</form>
</body>
</html>
