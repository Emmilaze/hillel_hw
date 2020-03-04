<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Film amount</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form method="post" action="ServletForFilmAmount">
    <h2>Print the amount of films:</h2>
    <input type="number" name="number">
    <button type="submit">Search</button>
</form>
</body>
</html>
