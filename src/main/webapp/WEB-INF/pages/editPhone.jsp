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
    <form:form action="/edit/phone" method="POST" modelAttribute="phone">
        <form:hidden path="id"/>
        <form:hidden path="employee.id"/>
        <label >Тип</label>
        <form:input  path="type"/>
        <label >Номер</label>
        <form:input  path="number"/>
        <input type="submit" value="Сохранить"/>
    </form:form>