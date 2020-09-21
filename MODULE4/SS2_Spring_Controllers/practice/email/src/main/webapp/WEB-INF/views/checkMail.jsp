<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 17/09/2020
  Time: 2:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<h1>Email Validate</h1>


<form method="post">
    <input type="text" name="email" placeholder="Enter email"><br>
    <input type="submit" value="Validate">
    <h3 style="color:red">${message}</h3>
<%--    <h3 style="color:red">${message}</h3>--%>
</form>
</body>
</html>
