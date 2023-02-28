<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/28/2023
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MailBox</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<h1>Information</h1>
<h2>${msg}</h2>
<br>
<div class="d-inline p-2 bg-primary text-white">Languages: ${mailBox.languages}</div>
<div class="d-inline p-2 bg-primary text-white">Page: ${mailBox.pageSize}</div>
<div class="d-inline p-2 bg-primary text-white">Spam fillter ${spamFillter}</div>
<div class="d-inline p-2 bg-primary text-white">Signature: ${mailBox.signature}</div>
<button type="button" class="btn btn-success">Success</button><a href="/updateMail">Update</a></button>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
