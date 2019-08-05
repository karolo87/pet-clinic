<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Owners list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<form:form modelAttribute="newPet" method="post" action="/add-pet/${ownerId}">
    Name: <form:input path="name"/>
    Birth of date: <form:input path="birthDate"/>
    Type: <form:input path="type"/>
    <input type="submit" value="Dodaj" />
</form:form>

</body>
</html>