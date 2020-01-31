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
    <title>Monter</title>
</head>
<body>
<div align="center">
    <h1>Информация о электромонтёре</h1>
</div>

<table border="1">

    <tr>
        <td>ID</td>
        <td>${monter.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${monter.name}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${monter.password}</td>
    </tr>
    <tr>
        <td>Qualification</td>
        <td>${monter.qualification}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${monter.email}</td>
    </tr>

</table>

<a href="/webAppByJohn/perform_logout">Logout</a>

</body>
</html>
