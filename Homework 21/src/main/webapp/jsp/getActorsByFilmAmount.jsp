<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="i18n.messages" />
<html>
<head>
    <title>Actors</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1><fmt:message key="title.amountResult"/> <c:out value="${number} "/>films:</h1>
<c:forEach var="item" items="${actors}" >
<c:out value="${item}"/>
    </c:forEach>
</body>
</html>
