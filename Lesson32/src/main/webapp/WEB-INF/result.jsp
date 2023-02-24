<%--
  Created by IntelliJ IDEA.
  User: pigde
  Date: 24.02.2023
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

results:

<c:forEach var="pair" items="${pairs}">
    <li>

            ${pair} have result ${result.get(pair)} <br>

    </li>
</c:forEach>

you have ${player.getMoney()} money <br>

<form action="/">
    <button>return</button>
</form>

</body>
</html>
