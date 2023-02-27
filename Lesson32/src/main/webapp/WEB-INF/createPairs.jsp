<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/createPairs" method="post">

    <input type="text" name="rider's name" placeholder="rider's name" required="required">${rider_name}<br>
    <input type="text" name="horse's name" placeholder="horse's name" required="required">${horse_name}<br>
    <input type="submit" value="save"><br>

</form>

<hr>

<c:forEach var="pair" items="${pairs}">
    <li>

            ${pair.toString()}

    </li>
</c:forEach>

<form action="/">
    <button>return</button>
</form>

</body>
</html>