<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 26/08/2020
  Time: 3:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    div{
        width: 300px;
        height: 600px;
        background-color: seashell;
        border-collapse: collapse;
        border: 2px solid purple;
    }
    h1{
        color: red;
        font-weight: bolder;
        font-size: 25px;
        text-align: center;
        align-content: center;
    }
    hr{
        width: auto;
        color: red;
    }
    h2{
        color: darkblue;
    }
</style>
<body>
<div>
    <h1>DisPlay</h1>
    <hr>
    <h2>Product Description: <%=request.getAttribute("des")%></h2>
    <hr>
    <h2>List Price: <%=request.getAttribute("price")%></h2>
    <hr>
    <h2>Discount Percent: <%=request.getAttribute("discount")%></h2>
    <hr>
    <h2>Discount Amount: <%=request.getAttribute("amount")%></h2>
    <hr>
    <h2>Discount Percent</h2>
</div>
</body>
</html>
