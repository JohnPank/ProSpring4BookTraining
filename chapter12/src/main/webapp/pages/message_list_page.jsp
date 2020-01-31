<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johnpank
  Date: 30.12.2019
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список сообщений</title>
</head>
<body>
<div align="center">
    <h1>Список сообщений</h1>
</div>

<table border="1">

    <tr>
        <td>ID</td>
        <td>Имя Фамилия</td>
        <td>Статус</td>
        <td>Сообщение</td>
        <td>Дата</td>
    </tr>
    <c:forEach items="${message_list}" var="message">
        <tr>
            <td>${message.id}</td>
            <td>${message.workerId}</td>
            <td>${message.status}</td>
            <td>${message.message}</td>
            <td>${message.date_time}</td>
        </tr>
    </c:forEach>
</table>

<a href="/webAppByJohn/perform_logout">Logout</a>

</body>
</html>

