<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
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
            </div>
        </div>
    </div>
</nav>
<form action="setPassword" method="post" id="form">
    <p style="color:red">${message}</p>
    <div class="mb-3">
        <label for="loginEmail" class="form-label">Email address</label>
        <input type="hidden" id="loginEmail" name="email" value="${email}" >
    </div>
<div class="mb-3">
    <label for="regPassword" class="form-label">Password</label>
    <input type="password" class="form-control" id="regPassword" name="password" value="${dto.password}" onblur="checkpassword()" required>
    <span id="errorpassword" style="color: red;"></span>
</div>
<div class="mb-3">
    <label for="regConfirmPassword" class="form-label">Confirm Password</label>
    <input type="password" class="form-control" id="regConfirmPassword" name="confirmPassword" value="${dto.confirmPassword}" onblur="checkpassword()" required>
    <span id="errorConfirmpassword" style="color: red;"></span>
</div>
    <button type="submit" class="btn btn-success w-100">Register</button>
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
<script src="js/validation.js" defer></script>
</body>
</html>
