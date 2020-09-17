<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 11/09/2020
  Time: 10:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="../bootstrap_4/bootstrap-4.5.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../bootstrap_4/jquery-ui-1.12.1/jquery-ui.css">
<head>
    <title>Title</title>
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
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Add New Product</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-8" style="background-color: ghostwhite">
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="id">ID Product:</label>
                        <input type="text" class="form-control" name="id" id="id"  >
                    </div>
                    <div class="form-group">
                        <label for="name">Name Product :</label>
                        <input type="text" name="name" class="form-control" id="name" required>
                    </div>
                    <div class="form-group">
                        <label for="price">Price :</label>
                        <input type="text" name="price" class="form-control" id="price" required>
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <input type="text" name="quantity" class="form-control" id="quantity" >
                    </div>
                </div>
                <div class="col-xl-2"></div>
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="color">Color :</label>
                        <input type="text" name="color" class="form-control" id="color">
                    </div>
                    <div class="form-group">
                        <label for="description">Description :</label>
                        <input type="text" name="description" class="form-control" id="description" >
                    </div>
                    <div class="form-group">
                        <label for="category">Category :</label><br>
                        <select id="category" name="category" style="width: 100%; height: 37px">
                            <option value="1">Smart Phone</option>
                            <option value="2">Television</option>
                            <option value="3">Computer</option>
                            <option value="4">Computer Tablet</option>
                        </select>
                    </div>
                    <div style="padding-top:15px">
                        <br>
                        <input class="btn btn-danger" style="margin-left: 20px;width: 80px" type="submit" role="button"
                               value="Save">
                        <a role="button" href="/product" class="btn btn-success"
                           style="margin-left: 110px;width: 80px">Back</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2"></div>
    </div>
</form>

</body>
</html>
