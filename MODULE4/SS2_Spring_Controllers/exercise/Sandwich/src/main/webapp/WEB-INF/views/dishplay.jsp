<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 21/09/2020
  Time: 8:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form method="post">
    <h2>Sandwich Condiments</h2>
    <c:forEach var="value" items="${condiment1}">
        <h5>[${value}]</h5>
    </c:forEach>
    <div>
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce
        <input type="checkbox" name="condiment" value="Tomato">Tomato
        <input type="checkbox" name="condiment" value="Mustard">Mustard
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    </div>
    <br>
    <hr>
    <div>
        <input type="submit" value="Save">
    </div>
    <p>${mess}</p>
</form>
</body>
</html>
