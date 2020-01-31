<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johnpank
  Date: 20.12.2019
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Monter</title>
</head>
<body>
<div align="center">
    <h1>Добавление работника</h1>
</div>

<spring:form modelAttribute="workerModel" method="post" action="add_worker">
    <table>
        <tr>
            <td>Name</td>
            <td><spring:input path="name" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><spring:input path="password" /></td>
        </tr>
        <tr>
            <td>Qualification</td>
            <td><spring:input path="qualification" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><spring:input path="email" /></td>
        </tr>
        <tr>
            <td></td>
            <td><spring:button>Add</spring:button></td>
        </tr>
    </table>

</spring:form>

</body>
</html>
