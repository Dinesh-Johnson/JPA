<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>View Passport Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">Passport Details</h2>

    <c:if test="${not empty ref}">
        <div class="card shadow-lg rounded-4 mx-auto" style="max-width: 600px;">
            <div class="card-body">
                <h5 class="card-title mb-4">${ref.name} ${ref.surname}</h5>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Passport ID:</strong> ${ref.passportId}</li>
                    <li class="list-group-item"><strong>Passport Office:</strong> ${ref.passportOffice}</li>
                    <li class="list-group-item"><strong>Date of Birth:</strong> ${ref.dob}</li>
                    <li class="list-group-item"><strong>Email:</strong> ${ref.email}</li>
                    <li class="list-group-item"><strong>Mobile:</strong> ${ref.mobile}</li>
                    <li class="list-group-item"><strong>Login ID:</strong> ${ref.loginId}</li>
                    <li class="list-group-item"><strong>LoginId Same As Email:</strong> ${ref.loginIdSameAsEmail}</li>
                    <li class="list-group-item"><strong>Password:</strong> ********</li>
                    <li class="list-group-item"><strong>Confirm Password:</strong> ********</li>
                    <li class="list-group-item"><strong>Hint Question:</strong> ${ref.hintQuestion}</li>
                    <li class="list-group-item"><strong>Hint Answer:</strong> ${ref.hintAnswer}</li>
                </ul>
            </div>
        </div>
    </c:if>

    <div class="mt-4 text-center">
        <a href="getAllDatas" class="btn btn-outline-primary">Back to All Passports</a>
        <a href="returnToIndex" class="btn btn-outline-secondary">Home</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
