<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="i18n.messages" />
<html>
<head>
    <title>Search actors</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="ServletForActorsByMovie">
    <h2><fmt:message key="title.actorsByFilm"/></h2>
    <input type="text" name="filmName">
    <button type="submit"><fmt:message key="btn.search"/></button>
</form>
</body>
</html>