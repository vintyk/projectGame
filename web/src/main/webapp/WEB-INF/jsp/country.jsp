<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>--%>

<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GAME Analitic</title>
    <style type="text/css">
        div {
            background: url(${pageContext.request.contextPath}/resources/pic/backgrnd3.jpg)
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/foundation.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app.css">
</head>
<body>
<div class="row">
    <div class="large-12 columns">
        <h1 align="center">Добро пожаловать на сайт</h1>
        <h1 align="center">любителей киберспорта</h1>
    </div>
</div>

<div class="row">
    <div class="large-8 columns">
        <div class="callout">
            <img src= "${pageContext.request.contextPath}/resources/pic/003_wot.jpg">
<h1>Countries</h1>
<h3>Страны</h3>
<form method="post">

    <select name="listCountries" id="listCountries">
        <c:forEach items="${requestScope.listCountries}" var="listCountries">
            <option value="${listCountries.id}">${listCountries.name} </option>
        </c:forEach>
    </select>
    <br>
    <br>
    <h3>Привилегии</h3>
    <select name="listPrivilege" id="listPrivilege">
        <c:forEach items="${requestScope.listPrivilege}" var="listPrivilege">
            <option value="${listPrivilege.id}">${listPrivilege.namePrivilege} </option>
        </c:forEach>
    </select>
    <br>
    <br>
    <h3>Пользователи</h3>
    <%--<select name="listUser" id="listUser">--%>
    <%--<c:forEach items="${requestScope.listUser}" var="listUser">--%>
    <%--<option value="${listUser.id}">--%>
    <%--Имя: ${listUser.nameUser} ${listUser.familyUser} ${listUser.privilege.namePrivilege} </option>--%>
    <%--</c:forEach>--%>
    <%--</select>--%>
    <ol>
        <p>
            <c:forEach items="${requestScope.listUser}" var="listUser">
            <li>
        <p> Имя: ${listUser.nameUser} ${listUser.familyUser}  ${listUser.email}</p>
        <p> Привилегии: ${listUser.privilege.namePrivilege}  </p>
        <p> Пол: <c:if test="${requestScope.email.gender eq 'MALE'}"> Мужчина </c:if>
            <c:if test="${requestScope.email.gender eq 'FEMALE'}"> Женщина </c:if></p>
            </li>
            </c:forEach>
        </p>
    </ol>
    <br>
    <p> Название страны: ${requestScope.country_name.name}</p>
</form>
    </div>
</div>
</div>
</body>
</html>
