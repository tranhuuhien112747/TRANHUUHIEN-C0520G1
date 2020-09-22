<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 21/09/2020
  Time: 5:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="post" action="update" modelAttribute="settings">
    <table>
        <tr>
            <td><form:label path="languages">languages:</form:label></td>
            <td><form:select path="languages" items="${languageList}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${pageSizeList}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
            <td><form:checkbox path="spamsFilter" value="Enable"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"/></td>
            <td><button type="button"/>
                <a href="/form" style="text-decoration: none">Cancel</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>
