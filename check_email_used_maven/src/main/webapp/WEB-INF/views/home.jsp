<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/27/2023
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1> Email Validate</h1>
<h3 style="color: red">${msg}</h3>
<form action="validate" method="post"></form>
<input type="text" name="email"><br>
<input type="submit" value="validate">
</body>
</html>
