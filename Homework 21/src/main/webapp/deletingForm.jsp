<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Deleting form</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="ServletForDeleting">
    <h2>Print the number of years:</h2>
    <input type="number" name="years">
    <button type="submit">Delete</button>
</form>
</body>
</html>
