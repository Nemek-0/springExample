<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Справочник сотрудников компании</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/foundation.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app.css">
</head>
<body>

<h2>Сотрудники</h2>
<table>
    <tr>
        <th>ИД</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Должность</th>
        <th>ДР</th>
        <th>Действия</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.lastName}</td>
            <td>${employee.firstName}</td>
            <td>${employee.patronymic}</td>
            <td>${employee.position}</td>
            <td>${employee.dateBirth}</td>
            <td>
                <a href="/edit/${employee.id}">Изменить</a>
                <a href="/delete/${employee.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Добавление</h2>
<a href="/add">Добавить нового сотрудника</a>
</body>
</html>