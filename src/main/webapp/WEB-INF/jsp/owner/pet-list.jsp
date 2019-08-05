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

<c:if test="${empty petList}">
    <h3>Brak zwierzaków....</h3>
</c:if>

<c:forEach items="${petList}" var="pet">
    Imię: ${pet.name} <br />
    Data urodzenia: ${pet.birthDate} <br />
    Gatunek: ${pet.type} <br />
</c:forEach>


</body>
</html>