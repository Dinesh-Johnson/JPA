<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Album Register Page</title>
</head>
<body>
<form action="register" method="post">
    <p>${message}</p>

    <label>Title Name</label>
    <input type="text" name="title" value="${dto.title}" required><br><br>

    <label>Artist Name</label>
    <input type="text" name="artist" value="${dto.artist}" required><br><br>

    <label>Genre</label>
    <input type="text" name="genre" value="${dto.genre}" required><br><br>

    <label>Release Date</label>
    <input type="date" name="releaseDate" value="${dto.releaseDate}" required><br><br>

    <label>Price</label>
    <input type="number" step="0.01" name="price" value="${dto.price}" required><br><br>

    <label>Rating</label>
    <input type="number" step="0.1" min="0" max="5" name="rating" value="${dto.rating}" required><br><br>

    <input type="submit" value="Register"><br>

    <a href="returnToIndex">Home</a>

</form>
</body>
</html>