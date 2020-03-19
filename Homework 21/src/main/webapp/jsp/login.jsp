<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search actors</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="login">
    <h3>Username</h3>
    <input type="text" name="username">
    <h3>Password</h3>
    <input type="password" name="password">
    <button type="submit">Login</button>
</form>
<c:if test="${not empty error}">
<c:out value="${error}"/>
</c:if>
</body>
</html>