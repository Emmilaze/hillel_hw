<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="i18n.messages" />
<html>
<head>
    <title>Film amount</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form method="post" action="ServletForFilmAmount">
    <h2><fmt:message key="title.amount"/></h2>
    <input type="number" name="number">
    <button type="submit"><fmt:message key="btn.search"/></button>
</form>
</body>
</html>
