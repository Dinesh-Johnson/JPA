<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pet Adoption List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="returnToIndex">🐾 Pet Shelter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a href="returnToIndex" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="addPet" class="nav-link">Add Pet</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container mt-5">

    <div class="card shadow-sm">
        <div class="card-header bg-dark text-white text-center">
            <h3 class="mb-0">🐾 Pet Adoption List 🐾</h3>
        </div>
        <div class="card-body">

            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle">
                    <thead class="table-dark text-center">
                    <tr>
                        <th>Pet ID</th>
                        <th>Pet Name</th>
                        <th>Type</th>
                        <th>Age</th>
                        <th>Breed</th>
                        <th>Adoption Fee (₹)</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ref" items="${listOfDto}">
                        <tr>
                            <td>${ref.id}</td>
                            <td>${ref.name}</td>
                            <td>${ref.type}</td>
                            <td>${ref.age}</td>
                            <td>${ref.breed}</td>
                            <td>${ref.adoptionFee}</td>
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

        </div>
    </div>

    <!-- Search Form -->
    <div class="mt-4">
        <form action="search" method="get" class="d-flex justify-content-center">
            <input type="text" name="search" placeholder="Search pets..."
                   class="form-control w-50 me-2 shadow-sm" required>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
