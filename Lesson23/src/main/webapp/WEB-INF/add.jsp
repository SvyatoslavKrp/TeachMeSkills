<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.01.2023
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Add</title>
</head>
<body>

<div class="input-group input-group-lg">
    <form action="add" method="post">
        <input type="text" class="form-control" name="brand" aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default" required placeholder="brand">
        <input type="text" class="form-control" name="color" aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default" placeholder="color"> <br>
        <input type="submit" class="btn btn-primary" id="inputGroup-sizing-default" value="submit">
    </form>
</div>

<ul>
    <c:forEach items="${cars}" var="car">
        <li>
                ${car.id}---<b>${car.brand}</b>---${car.color}
        </li>
    </c:forEach>
</ul>

<form action="/">
    <button class="btn btn-primary">return</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
