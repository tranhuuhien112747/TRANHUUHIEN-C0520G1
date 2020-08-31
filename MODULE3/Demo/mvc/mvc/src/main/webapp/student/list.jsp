<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 8/28/2020
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
    </tr>
    <c:forEach var="student" items="${studentListServlet}">
        <tr>
            <th>${student.id}</th>
            <th>${student.name}</th>
            <th>${student.address}</th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
