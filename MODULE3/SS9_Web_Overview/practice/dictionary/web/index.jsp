<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 25/08/2020
  Time: 10:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<link rel="stylesheet" type="text/css" href="dictionary.css">
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="/dictionary">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search"/>
</form>
</body>
</html>
