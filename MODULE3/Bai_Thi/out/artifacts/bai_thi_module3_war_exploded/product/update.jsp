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
        <h3 style="text-align: center;color: #fd7e14;background-color: darkslategray">Edit Product</h3>
        <div class="row">
            <div class="col-xl-2"></div>
            <div class="row col-xl-8" style="background-color: ghostwhite">
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="id">ID Product:</label>
                        <input type="text" class="form-control" name="id" id="id" value="${requestScope["product"].id}" readonly >
                    </div>
                    <div class="form-group">
                        <label for="name">Name Product :</label>
                        <input type="text" name="name" class="form-control" id="name" required value="${requestScope["product"].name}">
                    </div>
                    <div class="form-group">
                        <label for="price">Price :</label>
                        <input type="text" name="price" class="form-control" id="price" value="${requestScope["product"].price}">
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <input type="text" name="quantity" class="form-control" id="quantity" value="${requestScope["product"].quantity}">
                    </div>
                </div>
                <div class="col-xl-2"></div>
                <div class="col-xl-5">
                    <div class="form-group">
                        <label for="color">Color :</label>
                        <input type="text" name="color" class="form-control" id="color"  value="${requestScope["product"].color}">
                    </div>
                    <div class="form-group">
                        <label for="description">Description :</label>
                        <input type="text" name="description" class="form-control" id="description" value="${requestScope["product"].description}" >
                    </div>
                    <div class="form-group">
                        <label for="category">Category :</label><br>
                        <select id="category" name="category" style="width: 100%; height: 37px">
                            <c:forEach var="category" items="${categoryList}">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
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
