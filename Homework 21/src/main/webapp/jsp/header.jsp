<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose function</title>
</head>
<body>
<h3><a href="ServletForNewMovies">Show recent movies</a></h3>
<h3><a href="ServletForActorsByMovie">Show actors by movie</a></h3>
<h3><a href="ServletForFilmAmount">Show actors, that played in N movies</a></h3>
<h3><a href="ServletForActorsDirectors">Show actors that were directors</a></h3>

<c:choose>
    <c:when test="${not empty user}">
        <h3><a href="ServletForDeleting">Delete movies that older then N years</a></h3>
        <br>
        Hello, ${user.username}!
        <h2><a href="logout">Logout</a></h2>
    </c:when>
    <c:otherwise>
        <h2><a href="login">Login</a></h2>
    </c:otherwise>
</c:choose>
</body>
</html>