<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 30/08/2020
  Time: 7:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit-Product</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Edit Product</legend>
        <div>
            <label for="name">Name</label>
            <input type="text" id="name" name="name" value="${requestScope["product"].name}">
        </div>
        <div>
            <label for="price">Price</label>
            <input type="text" id="price" name="price" value="${requestScope["product"].price}" >
        </div>

        <div>
            <label for="description">Description</label>
            <input type="text" id="description" name="description" value="${requestScope["product"].description}">
        </div>
        <div>
            <label for="producer">Producer</label>
            <input type="text" id="producer" name="producer" value="${requestScope["product"].producer}">
        </div>

        <div>
            <input type="submit" role="button">
            <a role="button" href="/product">Back</a>
        </div>
    </fieldset>
</form>
</body>
</html>
