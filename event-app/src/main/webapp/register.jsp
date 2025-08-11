<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Package Form</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<h2>Enter Event Details</h2>

<form action="register" method="post">
    <p>${message}</p>
    <label>Event Name:</label>
    <input type="text" name="packageName" value="${dto.name}" required><br><br>

    <label>Location:</label>
    <input type="text" name="location" value="${dto.location}" required><br><br>

    <label>Date:</label>
    <input type="date" name="date" value="${dto.date}"><br><br>

    <label>Organizer Name:</label>
    <input type="text" name="organizer" value="${dto.organizer}" required><br><br>

    <label>Ticket Price:</label>
    <input type="number" step="0.01" name="ticketPrice" value="${dto.ticketPrice}" required><br><br>

    <input type="submit" value="Submit">

</form>

</body>
</html>
