<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 16/09/2020
  Time: 2:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/usd" method="post">
    <div>
        <label>USD</label>
        <input type="number" name="usd" value="${usd}"><br>
    </div>
    <div>
        <label>VND</label>
        <input type="text" name="vnd" value="${vnd}">
    </div>
    <div>
        <input type="submit"value="Change">
        <a href="/usd" role="button">Reset</a>
    </div>
</form>
</body>
</html>
