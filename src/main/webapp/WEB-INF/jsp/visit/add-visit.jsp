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

<form:form method="post" modelAttribute="newVisit" action="/add-visit/${petId}">
<%--    <form:hidden path="id"/>--%>
    Data wizyty: <form:input path="date"/><br/><br/>
    Opis wizyty: <form:input path="description" cssStyle="width: 300px; height: 200px"/><br/>
    <input type="submit" value="Dodaj wizytę" />
</form:form>

</body>
</html>