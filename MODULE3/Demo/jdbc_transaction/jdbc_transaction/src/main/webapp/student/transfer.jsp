<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 9/1/2020
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
    <h2>Money Transfer</h2>
    <form action="/student" method="post" class="">
        <div class="form-group form-inline col-8">
            <label for="fromStudent">From: </label>
            <select class="form-control ml-2" name="fromStudent" id="fromStudent">
                <c:forEach var="student" items="${studentList}">
                    <option value="${student.id}">${student.name}</option>
                </c:forEach>
            </select>
            <label for="toStudent" class="ml-3">To: </label>
            <select class="form-control ml-2" name="toStudent" id="toStudent">
                <c:forEach var="student" items="${studentList}">
                    <option value="${student.id}">${student.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group col-3">
            <label for="money">Money</label>
            <input type="text" name="money" id="money" class="form-control" placeholder="Input money">
        </div>
        <div class="form-group col-3">
            <input type="hidden" name="action" value="transfer">
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
</body>
</html>
