<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 30/08/2020
  Time: 7:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create-New-Customer</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Create New Product</legend>
        <div>
            <label for="id">ID</label>
            <input type="text" id="id" name="id">
        </div>
        <div>
            <label for="name">Name</label>
            <input type="text" id="name" name="name">
        </div>

        <div>
            <label for="price">Price</label>
            <input type="text" id="price" name="price">
        </div>

        <div>
            <label for="description">Description</label>
            <input type="text" id="description" name="description">
        </div>
        <div>
            <label for="producer">Producer</label>
            <input type="text" id="producer" name="producer">
        </div>

        <div>
            <input type="submit" role="button">
            <a role="button" href="/product">Back</a>
        </div>
    </fieldset>
</form>
</body>
</html>
