<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="">
<head>
    <title>✈️ Passport Seva ✈️</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4 text-primary">Passport Seva Registration</h2>

    <c:if test="${not empty message}">
        <p class="text-danger">${message}</p>
    </c:if>

    <form action="register" method="post" class="border p-4 rounded shadow-sm bg-light">

        <div class="mb-3">
            <label class="form-label">Passport Office</label>
            <select name="passportOffice" class="form-select w-50">
                <option>Bangalore</option>
                <option>Chennai</option>
                <option>Mumbai</option>
                <option>Hyderabad</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" value="${dto.name}" class="form-control w-50" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Surname</label>
            <input type="text" name="surname" value="${dto.surname}" class="form-control w-50">
        </div>

        <div class="mb-3">
            <label class="form-label">Date Of Birth</label>
            <input type="date" id="dob" name="dob" value="${dto.dob}" class="form-control w-50">
        </div>

        <div class="mb-3">
            <label class="form-label">E-mail</label>
            <input type="email" name="email" value="${dto.email}" id="email" class="form-control w-50" onblur="loginemail()">
            <div id="emailerror" class="text-danger small mt-1"></div>
        </div>

        <div class="mb-3">
            <label class="form-label">Phone Number</label>
            <input type="number" name="mobile" value="${dto.mobile}" id="mobile" class="form-control w-50" onblur="loginmobile()">
            <div id="mobileerror" class="text-danger small mt-1"></div>
        </div>

        <div class="mb-3">
            <label class="form-label d-block">Do you want your Login ID same as E-mail ID?</label>
            <div class="form-check form-check-inline">
                <input type="radio" name="loginIdSameAsEmail" value="true" class="form-check-input">
                <label class="form-check-label">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" name="loginIdSameAsEmail" value="false" class="form-check-input" checked>
                <label class="form-check-label">No</label>
            </div>
        </div>

        <div class="mb-3">
            <label class="form-label">Login ID</label>
            <input type="text" name="loginId" value="${dto.loginId}" id="loginId" class="form-control w-50" onblur="loginid()">
            <div id="loginiderror" class="text-danger small mt-1"></div>
        </div>

        <div class="mb-3"> <label class="form-label">Password</label>
            <input type="password" name="password" value="${dto.password}" class="form-control w-50">
        </div>

        <div class="mb-3">
            <label class="form-label">Confirm Password</label>
            <input type="password" name="confirmPassword" value="${dto.confirmPassword}" class="form-control w-50">
        </div>

        <div class="mb-3">
            <label class="form-label">Hint Question</label>
            <select name="hintQuestion" class="form-select w-50">
                <option>Birth City</option>
                <option>Favourite Colour</option>
                <option>Favourite Cricketer</option>
                <option>First School</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Hint Answer</label>
            <input type="text" name="hintAnswer" value="${dto.hintAnswer}" class="form-control w-50">
        </div>

        <button type="submit" class="btn btn-primary">Register</button>
    </form>

    <div class="text-center mt-3">
        <a href="index.jsp" class="btn btn-outline-dark">🏠 Home</a>
    </div>
</div>

<script>
    console.log("date",document.getElementById("dob").value);
        function loginemail(){
            const email = document.getElementById('email').value;
            if(email !== ""){
                var xhttp = new XMLHttpRequest();
                xhttp.open("GET","http://localhost:8080/passport-seva/loginemail?email=" + email);
                xhttp.send();
                xhttp.onload = function(){
                    document.getElementById("emailerror").innerHTML = this.responseText;
                }
            }
        }
    function loginmobile() {
    const mobile = document.getElementById('mobile').value;
    if (mobile !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/passport-seva/loginmobile?mobile=" + mobile);
        xhttp.send();
        xhttp.onload = function () {
            document.getElementById("mobileerror").innerHTML = this.responseText;
        }
    }
}

function loginid() {
    const loginId = document.getElementById('loginId').value;
    if (loginId !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/passport-seva/loginid?loginId=" + loginId);
        xhttp.send();
        xhttp.onload = function () {
            document.getElementById("loginiderror").innerHTML = this.responseText;
        }
    }
}

</script>

</body>
</html>
