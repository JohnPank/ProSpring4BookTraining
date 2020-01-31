<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johnpank
  Date: 30.12.2019
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправка сообщений</title>
</head>
<body>
<div align="center">
<h1>Отправить сообшение</h1>
</div>

<table>

<spring:form modelAttribute="str_message" method="post" action="message_handler">
    <tr align="center" >
        <td width="100"><spring:button name="str_message" value="Ready">Готов</spring:button></td>
        <td width="100"><spring:button name="str_message" value="Drive">В пути</spring:button></td>
        <td width="100"><spring:button name="str_message" value="Arrival">На месте</spring:button></td>
        <td width="100"><spring:button name="str_message" value="Access">Допуск</spring:button></td>
    </tr>
    <tr>
        <td width="100"><spring:button name="str_message" value="Work complete">Работа завершена</spring:button></td>
        <td width="100"><spring:button name="str_message" value="On base">На базе</spring:button></td>
        <td width="100"><spring:button name="str_message" value="Car error">Поломка машины</spring:button></td>
        <td width="100"><spring:button name="str_message" value="SOS">SOS</spring:button></td>
    </tr>
</table>
</spring:form>

<a href="/webAppByJohn/perform_logout">Logout</a>

</body>
</html>
