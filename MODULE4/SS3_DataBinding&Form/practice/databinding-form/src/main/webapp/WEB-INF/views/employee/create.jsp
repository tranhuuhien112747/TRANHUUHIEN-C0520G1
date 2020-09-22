<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 21/09/2020
  Time: 3:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Employee</title>
</head>
<body>
<form:form method="POST" action="addNew" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID:</form:label></td>
            <td><form:input path="id"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee Name:</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Contact Number:</form:label></td>
            <td><form:input path="contactNumber"></form:input></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>

</form:form>
</body>
</html>
