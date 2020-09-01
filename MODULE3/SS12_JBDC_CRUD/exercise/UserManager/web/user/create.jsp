<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 31/08/2020
  Time: 9:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Add New User</legend>
        <div>
            <label for="id">ID</label>
            <input type="text" id="id" name="id">
        </div>
        <div>
            <label for="fullname">Name</label>
            <input type="text" id="fullname" name="fullname">
        </div>

        <div>
            <label for="email">Email</label>
            <input type="text" id="email" name="email">
        </div>

        <div>
            <label for="country">Country</label>
            <input type="text" id="country" name="country">
        </div>
        <div>
            <input type="submit" role="button" value="Save">
            <a role="button" href="/user">Back</a>
        </div>
    </fieldset>
</form>
</body>
</html>
