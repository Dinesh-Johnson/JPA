<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html xmlns:c="">
<head>
    <title>Album List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="mb-4 text-center text-primary">Album Details</h1>

    <table class="table table-bordered table-striped table-hover">
        <thead class="table-dark">
        <tr>
            <th>Event Name</th>
            <th>Location</th>
            <th>Date</th>
            <th>Organizer</th>
            <th>Ticket Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ref" items="${listOfDto}">
            <tr>
                <td>${ref.name}</td>
                <td>${ref.location}</td>
                <td>${ref.date}</td>
                <td>${ref.organizer}</td>
                <td>${ref.ticketPrice}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
