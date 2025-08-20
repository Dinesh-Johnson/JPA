function checkname(){
    const name = document.getElementById('regName').value.trim();
    const error = document.getElementById('errorname');
    if (name === "") {
        error.textContent = "Name field is empty";
    } else if (name.length < 4) {
        error.textContent = "Name must be at least 4 characters";
    } else {
        error.textContent = "";
    }
}
function checkmail(){
    const email = document.getElementById('regEmail').value.trim();
    const error = document.getElementById('errormail');
    if (email === "") {
        error.textContent = "Email field is empty";
    } else if (!/^\S+@\S+\.\S+$/.test(email)) {
        error.textContent = "Enter a valid email address";
    } else {
        error.textContent = "";
    }
}
function checkmobile(){
    const mobile = document.getElementById('regPhone').value.trim();
    const error = document.getElementById('errormobile');
    if (mobile === "") {
        error.textContent = "Mobile field is empty";
    } else if (!/^\d{10}$/.test(mobile)) {
        error.textContent = "Enter a valid 10-digit mobile number";
    } else {
        error.textContent = "";
    }
}
function checkaddress(){
    const address = document.getElementById('exampleFormControlTextarea1').value.trim();
    const error = document.getElementById('erroraddress');
    if (address === "") {
        error.textContent = "Address field is empty";
    } else {
        error.textContent = "";
    }
}
function checkpassword(){
    const password = document.getElementById('regPassword').value;
    const confirmPassword = document.getElementById('regConfirmPassword').value;
    const error = document.getElementById('errorpassword');
    const errorconfirm = document.getElementById('errorConfirmpassword');
    if (password === "") {
        error.textContent = "Password field is empty";
    } else if (password.length < 6) {
        error.textContent = "Password must be at least 6 characters";
    } else {
        error.textContent = "";
    }

    if (confirmPassword === "") {
        errorconfirm.textContent = "Confirm password field is empty";
    } else if (password !== confirmPassword) {
        errorconfirm.textContent = "Passwords do not match";
    } else {
        errorconfirm.textContent = "";
    }
}
