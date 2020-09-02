<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 9/1/2020
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>Update Student</h2>
    <form action="/student" method="post">
        <div class="form-group">
            <label for="studentName">Student ID</label>
            <input type="text" name="studentId" id="studentId" class="form-control" placeholder="Input ID" value="${student.id}" readonly="true">
        </div>
        <div class="form-group">
            <label for="studentName">Student Name</label>
            <input type="text" name="studentName" id="studentName" class="form-control" placeholder="Input name" value="${student.name}">
        </div>
        <div class="form-group">
            <label for="studentAddress">Student Address</label>
            <input type="text" name="studentAddress" id="studentAddress" class="form-control" placeholder="Input address" value="${student.address}">
        </div>
        <div>
            <input type="hidden" name="action" value="update">
            <button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
        </div>
    </form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
