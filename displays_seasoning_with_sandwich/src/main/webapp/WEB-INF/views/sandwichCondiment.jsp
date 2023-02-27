<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/27/2023
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Sandwich Condiments</h1>
<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
    <form action="/save" method="post">
        <div class="btn-group me-2" role="group" aria-label="First group">

            <input type="checkbox" class="btn btn-primary" value="Lecttuce" name="condiment">Lecttuce
            <input type="checkbox" class="btn btn-primary" value="Tomato" name="condiment">Tomato
            <input type="checkbox" class="btn btn-primary" value="Mustard" name="condiment">Mustard
            <input type="checkbox" class="btn btn-primary" value="Sporout" name="condiment">Sporout
            <input type="submit" class="btn btn-primary" value="Save">
        </div>
    </form>
</div>
<div>${listCondiment}</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
