<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="i18n.messages" />
<html>
<head>
    <title>Deleting form</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="ServletForDeleting">
    <h2><fmt:message key="title.deleting"/></h2>
    <input type="number" name="years">
    <button type="submit"><fmt:message key="btn.delete"/></button>
</form>
<c:if test="${not empty error}">
    <c:out value="${error}"/>
</c:if>
</body>
</html>
