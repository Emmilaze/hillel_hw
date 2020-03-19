<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search actors</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="ServletForActorsByMovie">
    <h2>Print name of film:</h2>
    <input type="text" name="filmName">
    <button type="submit">Search</button>
</form>
</body>
</html>