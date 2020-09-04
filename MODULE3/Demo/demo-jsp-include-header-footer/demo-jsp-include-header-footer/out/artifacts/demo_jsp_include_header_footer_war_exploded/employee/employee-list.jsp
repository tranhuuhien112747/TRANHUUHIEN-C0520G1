<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 09/04/2020
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="home">
        <a href="/employeeServlet?actionUser=create">Go to create employee</a>
        <h2>Welcome to employee list!</h2>
    </div>
    <%@ include file="../common/footer.jsp"%>
</body>
</html>
