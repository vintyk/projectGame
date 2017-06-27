<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vinty
  Date: 25.06.2017
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%--<meta charset="UTF-8">--%>
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GAME Analitic</title>
    <style type="text/css">
        div {
            background: url(/resources/pic/backgrnd3.jpg)
        }
    </style>
    <link rel="stylesheet" href="/resources/css/foundation.css">
    <link rel="stylesheet" href="/resources/css/app.css">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/country">
    <label>Наименование страны</label>
    <input type="text" name="name"/>
    <%--<label>Release year</label>--%>
    <%--<input type="text" name="releaseYear"/>--%>
    <%--<label>Genre</label>--%>
    <%--<select name="genre">--%>
        <%--<option value="COMEDY">Comedy</option>--%>
        <%--<option value="THRILLER">Thriller</option>--%>
        <%--<option value="ACTION">Action</option>--%>
    <%--</select>--%>
    <button type="submit">Сохранить</button>
</form>
</body>
</html>
