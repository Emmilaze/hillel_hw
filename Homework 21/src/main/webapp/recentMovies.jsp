<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Recent movies</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Film, that released this year and last year:</h2>
<c:forEach var="item" items="${movies}">
<p><c:out value="${item}"/><p>
    </c:forEach>
</body>
</html>