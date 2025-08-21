<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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

<main class="flex-fill container my-4">
    <h1>Welcome To X-Workz!</h1>
    <div class="row align-items-center">

        <!-- Left Column: Image -->
        <div class="col-md-6 text-center">
            <img src="https://raw.githubusercontent.com/xworkzodc/Gallery/master/images/56.jpeg"
                 alt="about"
                 class="img-fluid rounded shadow">
        </div>

        <!-- Right Column: Text -->
        <div class="col-md-6">
            <p>
                We are professionals from IT industry, having vast experience in development and training of JAVA and various UI related technologies.
            </p>
            <h3>Enterprise Application Expertise Team</h3>
            <p>
                We have been training and placing students over a decade now in various training institutes, we are the pioneers who introduced different training models which not only focus on theory but on practical implementations.
            </p>
            <p>
                We have been training and placing students over a decade now in various training institutes, we are the pioneers who introduced different training models which not only focus on theory but on practical implementations.
            </p>
        </div>
    </div>
</main>

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
