<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.01.2023
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<ul>
    <c:forEach items="${cars}" var="car">

        <form method="post" action="update">
            <li>
                <input type="hidden" name="id" value="${car.id}">
                    ${car.id}---${car.brand}---${car.color}<br>
                <div class="col-4">
                    <input type="text" class="form-control" name="newColor" placeholder="new color">
                </div>
                <input class="btn btn-primary" type="submit" value="repaint">
            </li>
        </form>

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
