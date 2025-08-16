<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="">
<head>
    <meta charset="UTF-8">
    <title>Passport Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="mb-4 text-center">Passport Details</h1>

    <c:choose>
        <c:when test="${not empty list}">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach var="ref" items="${list}">
                    <div class="col">
                        <div class="card shadow-sm h-100">
                            <div class="card-body">
                                <h5 class="card-title">${ref.name} ${ref.surname}</h5>
                                <p class="card-text mb-1"><strong>Passport ID:</strong> ${ref.passportId}</p>
                                <p class="card-text mb-1"><strong>Passport Office:</strong> ${ref.passportOffice}</p>
                                <p class="card-text mb-1"><strong>Date of Birth:</strong> ${ref.dob}</p>
                                <p class="card-text mb-1"><strong>Email:</strong> ${ref.email}</p>
                                <p class="card-text mb-1"><strong>Mobile:</strong> ${ref.mobile}</p>
                                <p class="card-text mb-1"><strong>Login ID:</strong> ${ref.loginId}</p>
                                <p class="card-text mb-1"><strong>LoginId Same As Email:</strong> ${ref.loginIdSameAsEmail}</p>
                                <p class="card-text mb-1"><strong>Password:</strong> ********</p>
                                <p class="card-text mb-1"><strong>Confirm Password:</strong> ********</p>
                                <p class="card-text mb-1"><strong>Hint Question:</strong> ${ref.hintQuestion}</p>
                                <p class="card-text mb-1"><strong>Hint Answer:</strong> ${ref.hintAnswer}</p>
                            </div>
                            <div class="card-footer d-flex justify-content-between">
                                <a href="view?id=${ref.passportId}" class="btn btn-info btn-sm">View</a>
                                <a href="edit?id=${ref.passportId}" class="btn btn-warning btn-sm">Edit</a>
                                <a href="delete?id=${ref.passportId}" class="btn btn-danger btn-sm"
                                   onclick="return confirm('Are you sure you want to delete this record?');">
                                    Delete
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-warning text-center fs-5 shadow-sm mt-4">
                No passport data available.
            </div>
        </c:otherwise>
    </c:choose>

    <div class="mt-4 text-center">
        <a href="returnToIndex" class="btn btn-outline-secondary">Home</a>
    </div>
</div>

<div class="container text-center mt-5">
    <form action="search" method="get">
        <input type="text" name="search" placeholder="Search by Name or Email" class="form-control w-50 mx-auto">
        <br>
        <input type="submit" value="Search" class="btn btn-primary">
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
