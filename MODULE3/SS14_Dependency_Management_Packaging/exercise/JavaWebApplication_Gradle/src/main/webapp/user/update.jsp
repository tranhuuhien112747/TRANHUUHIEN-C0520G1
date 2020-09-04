<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 31/08/2020
  Time: 7:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Edit Users</legend>
        <div>
            <label for="fullname">Name</label>
            <input type="text" id="fullname" name="fullname" value="${requestScope["user"].name}">
        </div>
        <div>
            <label for="email">Email</label>
            <input type="text" id="email" name="email" value="${requestScope["user"].email}" >
        </div>

        <div>
            <label for="country">Country</label>
            <input type="text" id="country" name="country" value="${requestScope["user"].country}">
        </div>
        <div>
            <input type="submit" role="button" value="Save">
            <a role="button" href="/user">Back</a>
        </div>
    </fieldset>
</form>
</body>
</html>
