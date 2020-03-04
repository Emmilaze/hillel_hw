<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>Actors</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Actors, that have played in <c:out value="${number} "/>films:</h1>
<c:forEach var="item" items="${actors}" >
<p><c:out value="${item}"/><p>
    </c:forEach>
</body>
</html>
