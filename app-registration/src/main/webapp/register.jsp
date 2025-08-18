<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Orange Header & Sticky Footer</title>
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
  <img src="images/img.png" alt="Logo" style="height:50px;"/>

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

<!-- Main content -->
<div class="container my-5" style="max-width:500px;">
    <h2 class="mb-4 text-center">Registration</h2>
    <form action="register" method="post">
        <div class="mb-3">
            <label for="regName" class="form-label">Name</label>
            <input type="text" class="form-control" id="regName" name="name" value="${dto.name}" onblur="checkname()" required>
            <span id="errorname" style="color: red;"></span>
        </div>
        <div class="mb-3">
            <label for="regEmail" class="form-label">Email</label>
            <input type="email" class="form-control" id="regEmail" name="email" value="${dto.email}" onblur="checkmail(); loginemail(); " required>
            <span id="errormail" style="color: red;"></span>
        </div>
        <div class="mb-3">
            <label for="regPhone" class="form-label">Phone Number</label>
            <input type="tel" class="form-control" id="regPhone" name="mobile" pattern="[0-9]{10}" maxlength="10" value="${dto.mobile}" onblur="checkmobile(); loginmobile();" required>
            <span id="errormobile" style="color: red;"></span>
        </div>
        <div class="mb-3">
            <label for="regDOB" class="form-label">Date of Birth</label>
            <input type="date" class="form-control" id="regDOB" name="dob" value="${dto.dob}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Gender</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderMale"
                       value="Male" ${dto.gender == 'Male' ? 'checked' : ''} required>
                <label class="form-check-label" for="genderMale">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderFemale"
                       value="Female" ${dto.gender == 'Female' ? 'checked' : ''}>
                <label class="form-check-label" for="genderFemale">Female</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderOther"
                       value="Other" ${dto.gender == 'Other' ? 'checked' : ''}>
                <label class="form-check-label" for="genderOther">Other</label>
            </div>
        </div>
        <div class="mb-3">
            <label for="regState" class="form-label">State</label>
            <select class="form-select" id="regState" name="state" value="${dto.state}" required>
                <option value="">Select State</option>
                <option value="Karnataka">Karnataka</option>
                <option value="Maharashtra">Maharashtra</option>
                <option value="Tamil Nadu">Tamil Nadu</option>
                <option value="Kerala">Kerala</option>
                <option value="Telangana">Telangana</option>
                <option value="Andhra Pradesh">Andhra Pradesh</option>
                <option value="West Bengal">West Bengal</option>
                <option value="Gujarat">Gujarat</option>
                <option value="Rajasthan">Rajasthan</option>
                <option value="Punjab">Punjab</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label" >Address</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="address" value="${dto.address}" onblur="checkaddress()" required></textarea>
            <span id="erroraddress" style="color: red;"></span>
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
    </form>
    <div class="mt-3 text-center">
        <a href="login">Already have an account? Login</a>
    </div>
</div>

<!-- Sticky Footer (always at bottom) -->
<footer class="mt-auto bg-dark text-white text-center py-3 position-relative">
    X-Workz © 2025
</footer>

<!-- Social Icons bottom right -->
<div class="social-icons">
    <a href="#" aria-label="Facebook"><i class="bi bi-facebook" style="font-size:32px; color:#fff;"></i></a>
    <a href="#" aria-label="Twitter"><i class="bi bi-twitter" style="font-size:32px; color:#fff;"></i></a>
    <a href="#" aria-label="Instagram"><i class="bi bi-instagram" style="font-size:32px; color:#fff;"></i></a>
    <a href="#" aria-label="LinkedIn"><i class="bi bi-linkedin" style="font-size:32px; color:#fff;"></i></a>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/darkModeToggle.js" defer></script>
<script src="js/validation.js" defer></script>
<script src="js/ajax.js" defer></script>
</body>
</html>
