<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Справочник сотрудников компании</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/foundation.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app.css">
</head>
<body>
    <form:form action="/add" method="POST" modelAttribute="employee" >
        <form:hidden path="id"/>
        <label >Фамилия</label>
        <form:input  path="lastName"/>
        <label >Имя</label>
        <form:input  path="firstName"/>
        <label >Отчество</label>
        <form:input path="patronymic"/>
        <label >День рождения</label>
        <form:input type="date" path="birthday"/>
        <label >Должность</label>
        <form:select path="position">
            <form:option selected="selected" value="" label="Выберите должность"/>
            <c:forEach var="position" items="${positions}">
                <form:option value="${position.id}">${position.name}</form:option>
            </c:forEach>
        </form:select>
        <input type="submit" value="Сохранить">
    </form:form>
</body>
</html>