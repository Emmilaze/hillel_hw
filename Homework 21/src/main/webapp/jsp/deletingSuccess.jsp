<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Successful</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h2>Deleting was successful</h2>
<form method="get" action="mainPage">
    <h2>Return to main page</h2>
    <button type="submit">Return</button>
</form>
</body>
</html>
