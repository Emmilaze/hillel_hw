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
<form method="post" action="login">
    <h3><fmt:message key="username"/></h3>
    <input type="text" name="username">
    <h3><fmt:message key="password"/></h3>
    <input type="password" name="password">
    <button type="submit"><fmt:message key="login"/></button>
</form>
<c:if test="${not empty error}">
<c:out value="${error}"/>
</c:if>
</body>
</html>