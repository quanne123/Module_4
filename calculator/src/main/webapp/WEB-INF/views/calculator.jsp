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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator" method="post">
    <div class="input-group">
        <span class="input-group-text">First number and Second number</span>
        <input type="number" aria-label="Number One" class="form-control" name="numberOne" value=${numberOne}>
        <input type="number" aria-label="Number Two" class="form-control" name="numberTwo" value=${numberTwo}>
    </div>
    <div>
        <input class="btn btn-primary mb-2" type="submit" value="Addition" name="calculation">
        <input class="btn btn-primary mb-2" type="submit" value="Subtraction" name="calculation">
        <input class="btn btn-primary mb-2" type="submit" value="Multiplication" name="calculation">
        <input class="btn btn-primary mb-2" type="submit" value="Division" name="calculation">
    </div>
</form>
<div>Result : ${result}</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
