<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="">
<head>
    <meta charset="UTF-8">
    <title>Pet List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center text-primary mb-4">🐾 Pet Adoption List 🐾</h2>

    <div class="table-responsive shadow-sm rounded">
        <table class="table table-bordered table-striped table-hover align-middle">
            <thead class="table-dark text-center">
            <tr>
                <th>Pet Name</th>
                <th>Type</th>
                <th>Age</th>
                <th>Breed</th>
                <th>Adoption Fee (Rupees)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ref" items="${listOfDto}">
                <tr>
                    <td>${ref.name}</td>
                    <td>${ref.type}</td>
                    <td>${ref.age}</td>
                    <td>${ref.breed}</td>
                    <td>${ref.adoptionFee}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
