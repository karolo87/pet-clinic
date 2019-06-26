<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj zwierzaka</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<form:form method="post" action="/add-pet" modelAttribute="newPet" >
    Imię zwierzaka: <form:input path="name"/><br />
    Gatunek: <form:input path="type"/><br />
    Rok urodzenia: <form:input path="yearOfBirth"/><br />
    Id właściciela: <form:select path="owner" itemValue="id"/><br />
    <input type="submit" value="Dodaj"/>
</form:form>

</body>
</html>