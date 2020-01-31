<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johnpank
  Date: 23.12.2019
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div align="center">
        <spring:form modelAttribute="workerModel" method="post" action="check">
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
                    <td></td>
                    <td><spring:button>Login</spring:button></td>
                </tr>
            </table>

        </spring:form>



    </div>
</body>
</html>