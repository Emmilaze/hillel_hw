<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="i18n.messages" />
<html>
<head>
    <title>Successful</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2><fmt:message key="title.deleted"/></h2>
<form method="get" action="mainPage">
    <h2><fmt:message key="title.return"/></h2>
    <button type="submit"><fmt:message key="btn.return"/></button>
</form>
</body>
</html>
