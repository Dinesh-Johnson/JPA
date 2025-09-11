<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>X-WORKZ (ODC)</title>
    <!-- Bootstrap 5 CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Your external CSS -->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body class="d-flex flex-column min-vh-100">

<!-- Header Navbar -->
<nav class="navbar navbar-expand-lg navbar-orange">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#" >
            <span class="logo-badge">
  <img src="images/img.png" alt="Logo" style="height:50px;"/><br>

</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon" ></span>
        </button>
        <button id="darkModeToggle" class="btn btn-outline-dark ms-3" type="button">
            <i class="bi bi-moon"></i> Dark Mode
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="login">Login</a>
                <a class="nav-link" href="register">Register</a>
                <img src="<c:url value='/uploads/${dto.filePath}' />"
                     alt="Profile"
                     class="rounded-circle me-2"
                     style="width:40px; height:40px; object-fit:cover;">
            </div>
        </div>
    </div>
</nav>

<div class="container my-5" style="max-width: 500px;">
    <div class="card shadow">
        <div class="card-header bg-warning text-dark">
            <h4 class="card-title mb-0">User Details</h4>
        </div>
        <div class="mt-3">
            <strong>Profile Picture:</strong><br>
            <img src="<c:url value='/uploads/${dto.filePath}' />" class="card-img-top" alt="Profile Image">
        </div>
        <div class="card-body">
            <p><strong>Name:</strong> ${dto.name}</p>
            <p><strong>Email:</strong> ${dto.email}</p>
            <p><strong>Phone:</strong> ${dto.mobile}</p>
            <p><strong>Date of Birth:</strong> ${dto.dob}</p>
            <p><strong>Gender:</strong> ${dto.gender}</p>
            <p><strong>State:</strong> ${dto.state}</p>
            <p><strong>City:</strong> ${dto.district}</p>
            <p><strong>Pincode:</strong> ${dto.pincode}</p>
            <p><strong>Address:</strong> ${dto.address}</p>
        </div>
        <div class="card-footer text-center">
            <a href="editProfile?email=${dto.email}" class="btn btn-primary">Edit Profile</a>
            <a href="deleteProfile?email=${dto.email}" class="btn btn-primary">Delete Profile</a>
            <a href="login" class="btn btn-secondary ms-2">Back to Log IN</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
<footer class="mt-auto bg-dark text-white text-center py-3 position-relative">
    X-Workz © 2025

    <!-- Social Icons bottom right -->
    <div class="social-icons position-absolute" style="right: 20px; bottom: 10px;">
        <a href="#" aria-label="Facebook"><i class="bi bi-facebook" style="font-size:32px; color:#fff; margin-left:10px;"></i></a>
        <a href="#" aria-label="Twitter"><i class="bi bi-twitter" style="font-size:32px; color:#fff; margin-left:10px;"></i></a>
        <a href="#" aria-label="Instagram"><i class="bi bi-instagram" style="font-size:32px; color:#fff; margin-left:10px;"></i></a>
        <a href="#" aria-label="LinkedIn"><i class="bi bi-linkedin" style="font-size:32px; color:#fff; margin-left:10px;"></i></a>
    </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/darkModeToggle.js" defer></script>

</body>
</html>
