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

<%--Cześć ${visitList.pet.owner.name}!--%>
<%--Twój ${visitList.pet.type} - ${visitList.pet.name}--%>
<%--ma poniższe wizyty:<br />--%>

<c:forEach items="${visitList}" var="visit">
    ${visit.pet.owner.firstName}
    ${visit.pet.owner.lastName} |
    ${visit.pet.name} |
    ${visit.date} |
    ${visit.description} |
    <a href="/visits/edit-visit/${visit.id}">Edytuj</a>
    <br />

</c:forEach>

</body>
</html>