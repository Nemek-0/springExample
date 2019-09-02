<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Справочник сотрудников компании</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/foundation.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app.css">
</head>
<body>
    <form id="edit" action="/edit" method="POST">
        <input type="hidden" name="id" value="${employee.id}">
        <label for="lastName">Фамилия</label>
        <input type="text" name="lastName" value="${employee.lastName}" required>
        <label for="firstName">Имя</label>
        <input type="text" name="firstName"  value="${employee.firstName}" required>
        <label for="patronymic">Отчество</label>
        <input type="text" name="patronymic"  value="${employee.patronymic}">
        <label for="date">День рождения</label>
        <input type="date" name="date"  value="${employee.birthday}">
        <input type="submit" value="Сохранить">
    </form>
</body>
</html>