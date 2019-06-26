<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add owner</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<table>

    <form:form action="/add-owner" method="post" modelAttribute="newOwner">
        <tr>
            <th>Imię:</th>
            <th><form:input path="firstName"/></th>
        </tr>
        <tr>
            <th>Nazwisko:</th>
            <th><form:input path="lastName"/></th>
        </tr>
        <tr>
            <th>Adres:</th>
            <th><form:input path="address"/></th>
        </tr>
        <tr>
            <th>Miasto:</th>
            <th><form:input path="city"/></th>
        </tr>
        <tr>
            <th>Telefon:</th>
            <th><form:input path="phone"/></th>
        </tr>
        <tr>
            <th></th>
            <th><input type="submit" value="Dodaj"/></th>
        </tr>

    </form:form>

</table>


</body>
</html>