<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add owner</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<form:form action="/edit-pet/${ownerId}/${petId}" modelAttribute="editedPet" method="post">
    <form:hidden path="id"/>
    Imię: <form:input path="name"/>
    Data urodzenia: <form:input path="birthDate"/>
    Gatunek: <form:input path="type"/>
    <input type="submit" value="Edytuj"/>
</form:form>


</body>
</html>