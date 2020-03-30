<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="i18n.messages" />
<html>
<head>
    <title>Recent movies</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2><fmt:message key="title.recent"/></h2>
<c:forEach var="item" items="${movies}">
<c:out value="${item}"/>
    </c:forEach>
</body>
</html>