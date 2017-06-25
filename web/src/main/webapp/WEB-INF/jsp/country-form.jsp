<%--
  Created by IntelliJ IDEA.
  User: Vinty
  Date: 25.06.2017
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
