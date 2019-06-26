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

<c:forEach var="pet" items="${petsList}">
    <c:out value="${pet.name}" />
    <c:out value="${pet.type}" />
    <c:out value="${pet.yearOfBirth}" />
</c:forEach>

</body>
</html>