<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 25/08/2020
  Time: 9:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>[Thực hành] Ứng dụng chuyển đổi tiền tệ - Servlet</title>
  </head>
  <link rel="stylesheet" type="text/css" href="change_money.css">
  <body>
  <h2>Currency Converter</h2>
  <form method="post"action="/money">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
  </form>
  </body>
</html>
