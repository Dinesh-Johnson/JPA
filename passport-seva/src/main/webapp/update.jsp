<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Edit Passport Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h2 class="text-center mb-4">Edit Passport Details</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-info text-center">${message}</div>
        </c:if>

        <form action="updatePassport" method="post">
            <div class="mb-3">
                <label class="form-label">Passport ID:</label>
                <input type="text" name="passportId" value="${ref.passportId}" class="form-control" readonly>
            </div>

            <div class="mb-3">
                <label class="form-label">Passport Office:</label>
                <input type="text" name="passportOffice" value="${ref.passportOffice}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Name:</label>
                <input type="text" name="name" value="${ref.name}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Surname:</label>
                <input type="text" name="surname" value="${ref.surname}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Date of Birth:</label>
                <input type="date" name="dob" value="${ref.dob}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email:</label>
                <input type="email" name="email" id="email" value="${ref.email}" class="form-control" required onblur="validateEmail()">
                <div id="emailerror" class="text-danger small mt-1"></div>
            </div>

            <div class="mb-3">
                <label class="form-label">Mobile:</label>
                <input type="number" name="mobile" id="mobile" value="${ref.mobile}" class="form-control" required onblur="validateMobile()">
                <div id="mobileerror" class="text-danger small mt-1"></div>
            </div>

            <div class="mb-3">
                <label class="form-label">Login ID:</label>
                <input type="text" name="loginId" id="loginId" value="${ref.loginId}" class="form-control" required onblur="validateLoginId()">
                <div id="loginiderror" class="text-danger small mt-1"></div>
            </div>

            <div class="mb-3">
                <label class="form-label d-block">Do you want your Login ID same as E-mail ID?</label>
                <div class="form-check form-check-inline">
                    <input type="radio" name="loginIdSameAsEmail" value="true" class="form-check-input"
                    <c:if test="${ref.loginIdSameAsEmail == 'true'}">checked</c:if>>
                    <label class="form-check-label">Yes</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="radio" name="loginIdSameAsEmail" value="false" class="form-check-input"
                    <c:if test="${ref.loginIdSameAsEmail == 'false'}">checked</c:if>>
                    <label class="form-check-label">No</label>
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">Password:</label>
                <input type="password" name="password" value="${ref.password}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Confirm Password:</label>
                <input type="password" name="confirmPassword" value="${ref.confirmPassword}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Hint Question:</label>
                <select name="hintQuestion" class="form-select" required>
                    <option value="Birth City" <c:if test="${ref.hintQuestion == 'Birth City'}">selected</c:if>>Birth City</option>
                    <option value="Favourite Colour" <c:if test="${ref.hintQuestion == 'Favourite Colour'}">selected</c:if>>Favourite Colour</option>
                    <option value="Favourite Cricketer" <c:if test="${ref.hintQuestion == 'Favourite Cricketer'}">selected</c:if>>Favourite Cricketer</option>
                    <option value="First School" <c:if test="${ref.hintQuestion == 'First School'}">selected</c:if>>First School</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Hint Answer:</label>
                <input type="text" name="hintAnswer" value="${ref.hintAnswer}" class="form-control" required>
            </div>

            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-primary btn-lg">Update</button>
            </div>
        </form>

        <div class="mt-4 d-flex justify-content-between">
            <a href="returnToIndex" class="btn btn-outline-secondary">🏠 Home</a>
            <a href="getAllDatas" class="btn btn-outline-info">📋 View All Passports</a>
        </div>
    </div>
</div>

<script>
    function validateEmail() {
        const email = document.getElementById('email').value;
        const passportId = document.getElementsByName('passportId')[0].value;
        if (email !== "") {
            fetch("http://localhost:8080/passport-seva/loginemail?email=" + encodeURIComponent(email) + "&passportId=" + encodeURIComponent(passportId))
                .then(resp => resp.text())
                .then(data => document.getElementById("emailerror").innerHTML = data);
        }
    }

    function validateMobile() {
        const mobile = document.getElementById('mobile').value;
        const passportId = document.getElementsByName('passportId')[0].value;
        if (mobile !== "") {
            fetch("http://localhost:8080/passport-seva/loginmobile?mobile=" + encodeURIComponent(mobile) + "&passportId=" + encodeURIComponent(passportId))
                .then(resp => resp.text())
                .then(data => document.getElementById("mobileerror").innerHTML = data);
        }
    }

    function validateLoginId() {
        const loginId = document.getElementById('loginId').value;
        const passportId = document.getElementsByName('passportId')[0].value;
        if (loginId !== "") {
            fetch("http://localhost:8080/passport-seva/loginid?loginId=" + encodeURIComponent(loginId) + "&passportId=" + encodeURIComponent(passportId))
                .then(resp => resp.text())
                .then(data => document.getElementById("loginiderror").innerHTML = data);
        }
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
