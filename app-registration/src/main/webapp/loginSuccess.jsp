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
                <a href="viewProfile?email=${dto.email}">
                    <img src="images/default.png"
                         alt="Profile"
                         class="rounded-circle me-2"
                         style="width:40px; height:40px; object-fit:cover;">
                </a>
            </div>
        </div>
    </div>
</nav>

<div class="container my-5" style="max-width: 500px;">
    <div class="alert alert-success alert-dismissible fade show mt-3" role="alert">
        <img src="images/default.png" alt="Success" style="height:24px; width:24px; margin-right:5px;">
        <strong>✅ Successfully Logged In!</strong>
        Click your profile picture to view your details.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
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
