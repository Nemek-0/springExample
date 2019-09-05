<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Справочник сотрудников компании</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/foundation.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app.css">
</head>
<body>
    <form id="edit" action="/add" method="POST">

        <label for="lastName">Фамилия</label>
        <input type="text" name="lastName" required>
        <label for="firstName">Имя</label>
        <input type="text" name="firstName" required>
        <label for="patronymic">Отчество</label>
        <input type="text" name="patronymic">
        <label for="date">День рождения</label>
        <input type="date" name="birthday">
        <input type="submit" value="Сохранить">
    </form>
</body>
</html>