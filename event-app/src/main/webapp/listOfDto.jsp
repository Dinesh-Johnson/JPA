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
            <th>#</th>
            <th>Event Name</th>
            <th>Location</th>
            <th>Date</th>
            <th>Organizer</th>
            <th>Ticket Price</th>
            <th>View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ref" items="${listOfDto}">
            <tr>
                <td>${ref.id}</td>
                <td>${ref.name}</td>
                <td>${ref.location}</td>
                <td>${ref.date}</td>
                <td>${ref.organizer}</td>
                <td>${ref.ticketPrice}</td>
                <td class="text-center">
                    <a href="view?id=${ref.id}" class="btn btn-info btn-sm me-1">View</a>
                    <a href="edit?id=${ref.id}" class="btn btn-warning btn-sm me-1">Edit</a>
                    <a href="delete?id=${ref.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this pet?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<a href="returnToIndex">HOME</a>
<div class="mt-4">
    <form action="search" method="get" class="d-flex justify-content-center">
        <input type="text" name="search" placeholder="Search pets..."
               class="form-control w-50 me-2 shadow-sm" required>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
</div>
<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
