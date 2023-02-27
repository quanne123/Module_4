<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/27/2023
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator" method="post">
    <div class="mb-3">
        <input type="number" name="numberOne" value="${numberOne}">
        <input type="number" name="numberTwo" value="${numberTwo}">
    </div>
    <div>
        <input type="submit" value="Addition" name="calculation">
        <input type="submit" value="Subtraction" name="calculation">
        <input type="submit" value="Multiplication" name="calculation">
        <input type="submit" value="Division" name="calculation">
    </div>
</form>
<div>Result : ${result}</div>
</body>
</html>
