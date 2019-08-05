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

    <form:form action="/edit-owner" method="post" modelAttribute="editedOwner">
        <form:hidden path="id"/>
        <tr>
            <th>First name:</th>
            <th><form:input path="firstName"/></th>
        </tr>
        <tr>
            <th>Last name:</th>
            <th><form:input path="lastName"/></th>
        </tr>
        <tr>
            <th>Address:</th>
            <th><form:input path="address"/></th>
        </tr>
        <tr>
            <th>City:</th>
            <th><form:input path="city"/></th>
        </tr>
        <tr>
            <th>Phone:</th>
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