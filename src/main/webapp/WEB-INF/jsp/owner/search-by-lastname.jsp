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

<h2>Szukaj właściciela</h2>

<form:form action="/search-by-lastname" modelAttribute="filterForm" method="post">
    Last name:  <form:input path="lastName"/>
    <input type="submit" value="Szukaj"/>
</form:form>


</body>
</html>