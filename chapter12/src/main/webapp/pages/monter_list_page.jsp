<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.johnpank.prospring4.chapter12.entity.Worker" %><%--
  Created by IntelliJ IDEA.
  User: johnpank
  Date: 24.12.2019
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список монтёров</title>
</head>
<body>
<div align="center">
    <h1>Список электромонтёров</h1>
</div>

    <table border="1">

        <tr>
            <td>ID</td>
            <td>Имя Фамилия</td>
            <td>Пароль</td>
            <td>Почта</td>
            <td>Квалификация</td>
        </tr>
        <c:forEach items="${monter_list}" var="monter">
        <tr>
        <td>${monter.id}</td>
            <td>${monter.name}</td>
            <td>${monter.password}</td>
            <td>${monter.email}</td>
            <td>${monter.qualification}</td>
        </tr>
        </c:forEach>
    </table>

<a href="/webAppByJohn/perform_logout">Logout</a>

</body>
</html>
