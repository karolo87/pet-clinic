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
                <th><a href="owner/delete/${owner.id}">Usuń</a></th>
                <th><a href="edit-owner/${owner.id}">Edytuj</a></th>
                <th><a href="add-pet/${owner.id}">Dodaj zwierzaka</a></th>
                <th><a href="owner/pet-list/${owner.id}">Pokaż zwierzaki</a></th>
            </tr>
            <tr>
                <th></th>
                <th colspan="3" align="left">
                    <c:forEach items="${owner.petList}" var="pet">
                        ${pet.id}
                        ${pet.name}
                        ${pet.birthDate}
                        ${pet.type} |
                        <a href="/edit-pet/${pet.owner.id}/${pet.id}">Edytuj</a>
                        <a href="/add-visit/${pet.id}">Dodaj wizytę</a>
                        <a href="/visits/${pet.id}">Wizyty</a>
                        <br />
                    </c:forEach>

                </th>
            </tr>
        </c:forEach>
    </table>


</body>
</html>