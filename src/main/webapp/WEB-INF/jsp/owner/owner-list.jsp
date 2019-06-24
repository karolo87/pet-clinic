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

<h2>Owners list</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Adres</th>
            <th>Miasto</th>
            <th>Nr tel.</th>
            <th></th>
        </tr>

        <c:forEach items="${ownerList}" var="owner">

            <tr>
                <th><c:out value="${owner.id}" /></th>
                <th><c:out value="${owner.firstName}" /></th>
                <th><c:out value="${owner.lastName}" /></th>
                <th><c:out value="${owner.address}" /></th>
                <th><c:out value="${owner.city}" /></th>
                <th><c:out value="${owner.phone}" /></th>
                <th>
                    <a href="delete-owner?id=${owner.id}">Usuń</a>
                    <a href="edit-owner?id=${owner.id}">Edytuj</a>
                </th>
            </tr>
        </c:forEach>
    </table>


</body>
</html>