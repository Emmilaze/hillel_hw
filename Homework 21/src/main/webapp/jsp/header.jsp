<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="i18n.messages" />

<html>
<head>
    <meta charset="UTF-8">
    <title>Choose function</title>
</head>
<body>
<select onchange="window.location.href=this.options[this.selectedIndex].value">
    <option><fmt:message key="language"/></option>
    <option VALUE="/Homework 21/changeLangToENG">English</option>
    <option VALUE="/Homework 21/changeLangToRU">Русский</option>
</select>
<h3><a href="ServletForNewMovies"><fmt:message key="menu.newMovies"/></a></h3>
<h3><a href="ServletForActorsByMovie"><fmt:message key="menu.actorsByFilm"/></a></h3>
<h3><a href="ServletForFilmAmount"><fmt:message key="menu.filmAmount"/></a></h3>
<h3><a href="ServletForActorsDirectors"><fmt:message key="menu.actorsDirectors"/></a></h3>

<c:choose>
    <c:when test="${not empty user}">
        <h3><a href="ServletForDeleting"><fmt:message key="menu.deleteFilms"/></a></h3>
        <br>
        <fmt:message key="greeting"/>, ${user.username}!
        <h2><a href="logout"><fmt:message key="logout"/></a></h2>
    </c:when>
    <c:otherwise>
        <h2><a href="login"><fmt:message key="login"/></a></h2>
    </c:otherwise>
</c:choose>
</body>
</html>