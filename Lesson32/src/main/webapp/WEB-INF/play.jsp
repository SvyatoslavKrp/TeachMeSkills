<%--
  Created by IntelliJ IDEA.
  User: pigde
  Date: 21.02.2023
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

you have ${player.getMoney()} money <br>

<form action="/play" method="post">

    <c:forEach var="pair" items="${pairs}">
        <li>

                ${pair.toString()} <input type="radio" name="radio" value="${pair}"> <br>

        </li>
    </c:forEach>

    <input type="number" min="1" max="${player.getMoney()}" name="bet">
    <input type="submit" value="enter"><br>
    your bet

</form>

<form action="/">
    <button>return</button>
</form>

</body>
</html>
