<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 09/04/2020
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="home">
        <a href="/customerServlet?actionUser=create">Go to create customer</a>
        <h2>Welcome to customer list!</h2>
    </div>
    <%@ include file="../common/footer.jsp"%>
</body>
</html>
