<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johnpank
  Date: 11.02.2020
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add user</title>
</head>
<body>
<div align="center">
    <H1>Add user</H1>



<spring:form modelAttribute="user" method="post" action="addToBase">
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
            <td>Email</td>
            <td><spring:input path="email" /></td>
        </tr>
        <tr>
            <td></td>
            <td><spring:button>Add</spring:button></td>
        </tr>
    </table>
</spring:form>
</div>


</body>
</html>
