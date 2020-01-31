<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>


<%!
String getFormattedDate(){

    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    return sdf.format(new Date());
}
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>John Pank Server</title>
</head>
<body>
    <div align="center">
        <h1>Цифровой электромонтёр</h1>
    </div>

    <div align="right">
        <ul>
            <li><a href="/webAppByJohn/login">Login</a></li>
            <li><a href="/webAppByJohn/perform_logout">Logout</a></li>
        </ul>

    </div>


    <br/>
    <i>Сегодня <%= getFormattedDate() %></i>
</body>
</html>

