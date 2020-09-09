<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 04/09/2020
  Time: 1:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="../bootstrap_4/bootstrap-4.5.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../bootstrap_4/jquery-ui-1.12.1/jquery-ui.css">
<head>
    <title>CREATE NEW CUSTOMER</title>
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
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Add New Customer</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-8" style="background-color: ghostwhite">
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="id">ID Customer:</label>
                        <input type="text" class="form-control" name="id" id="id" placeholder="Example: KH-1234" required>
                        <c:if test='${requestScope["message"].get(0) != ""}'>
                            <p >${requestScope["message"].get(0)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="name">Name Customer :</label>
                        <input type="text" name="name" class="form-control" id="name" required>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Date Of Birthday :</label>
                        <input type="text" name="birthday" class="form-control" id="birthday" required>
                        <c:if test='${requestScope["message"].get(4) != ""}'>
                            <p>${requestScope["message"].get(4)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <select  id="gender" name="gender" style="width: 100%; height: 37px">
                            <option value="1">Male</option>
                            <option value="0">Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="card">ID-Card Customer :</label>
                        <input type="text" name="card" class="form-control" id="card" required>
                        <c:if test='${requestScope["message"].get(1) != ""}'>
                            <p >${requestScope["message"].get(1)}</p>
                        </c:if>
                    </div>
                </div>
                <div class="col-xl-2"></div>
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="phone">Phone Customer :</label>
                        <input type="text" name="phone" class="form-control" id="phone" placeholder="Example: 090XXXXXXX" required>
                        <c:if test='${requestScope["message"].get(2) != ""}'>
                            <p >${requestScope["message"].get(2)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="email">Email Customer :</label>
                        <input type="text" name="email" class="form-control" id="email" required>
                        <c:if test='${requestScope["message"].get(3) != ""}'>
                            <p >${requestScope["message"].get(3)}</p>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="address">Address Customer :</label>
                        <input type="text" name="address" class="form-control" id="address" required>
                    </div>
                    <div class="form-group">
                        <label for="typeId">Type Customer :</label><br>
                        <select id="typeId" name="typeId" style="width: 100%; height: 37px">
                            <option value="1">Diamond</option>
                            <option value="2">Platinum</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
                        </select>
                    </div>
                    <div style="padding-top:15px">
                        <br>
                        <input class="btn btn-danger" style="margin-left: 20px;width: 80px" type="submit" role="button"
                               value="Save">
                        <a role="button" href="/customer" class="btn btn-success"
                           style="margin-left: 110px;width: 80px">Back</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2"></div>
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
