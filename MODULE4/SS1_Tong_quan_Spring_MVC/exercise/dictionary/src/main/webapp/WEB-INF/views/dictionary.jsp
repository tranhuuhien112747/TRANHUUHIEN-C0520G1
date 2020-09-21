<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 16/09/2020
  Time: 3:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form method="post">
    <label>English: </label>
    <input type="text" name="english" placeholder="key english..." value="${english}"><br>
    <br>
    <label>Vietnamese: </label>
    <input type="text" name="vietnam" value="${vietnam}" readonly><br>
    <br>
    <input type="submit" value="Translate">
    <a href="/dictionary" role="button">Reset</a>
    <p style="color: red">${message}</p>
</form>
</body>
</html>
