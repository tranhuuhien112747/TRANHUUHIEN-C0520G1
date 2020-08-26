<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 25/08/2020
  Time: 10:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>[Bài tập] Ứng dụng Product Discount Calculator</title>
</head>
<style>
    label {
        color: blue;
        font-weight: bold;
    }

    input {
        width: 150px;
        height: 30px;
    }
</style>
<body>
<form method="post" action="/calculator">
    <label>Product Description:</label><br>
    <textarea style="width: 150px;height: 40px" name="description"></textarea><br><br>
    <label>Price:</label><br>
    <input type="text" placeholder="Price product" name="price"><br><br>
    <label>Discount Percent:</label><br>
    <input type="text" placeholder="Discount" name="discount"><br><br>
    <input type="submit" value="Calculate Discount" style="color: red;background-color: yellow; font-weight: bolder">
</form>
</body>
</html>
