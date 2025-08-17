<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Adoption Edit Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4 text-primary">🐾 Pet Adoption Registration  Edit🐾</h2>

    <!-- Display message if exists -->
    <c:if test="${not empty message}">
        <div class="alert alert-info text-center">${message}</div>
    </c:if>

    <form action="register" method="post" class="p-4 bg-white rounded shadow-sm">
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" value="${dto.name}" class="form-control" >
        </div>

        <div class="mb-3">
            <label class="form-label">Type</label>
            <input type="text" name="type" value="${dto.type}" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Age</label>
            <input type="number" name="age" value="${dto.age}" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Breed</label>
            <input type="text" name="breed" value="${dto.breed}" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Adoption Fee</label>
            <input type="number" step="0.01" name="adoptionFee" value="${dto.adoptionFee}" class="form-control" required>
        </div>

        <div class="text-center">
            <input type="submit" value="submit" class="btn btn-success px-4">
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>