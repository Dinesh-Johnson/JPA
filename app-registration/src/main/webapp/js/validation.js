function checkname(){
    const name = document.getElementById('regName').value;
    const error= document.getElementById('errorname');
    if(name==""){
        error.textContent="Field is Empty"
    }else {
        error.textContent = "";
        }
}
function checkmail(){
    const email = document.getElementById('regEmail').value;
    const error= document.getElementById('errormail');
    if(email==""){
        error.textContent="Field is Empty"
    }else {
        error.textContent = "";
        }
}
function checkmobile(){
    const mobile = document.getElementById('regPhone').value;
    const error= document.getElementById('errormobile');
    if (mobile === "") {
        error.textContent = "Field is Empty";
    } else if (!/^\d{10}$/.test(mobile)) {
        error.textContent = "Enter valid 10-digit number";
    } else {
        error.textContent = "";
    }
}
function checkaddress(){
    const address = document.getElementById('exampleFormControlTextarea1').value;
    const error= document.getElementById('erroraddress');
    if(address==""){
        error.textContent="Field is Empty"
    }else {
        error.textContent = "";
        }
}
function checkpassword(){
    const password = document.getElementById('regPassword').value;
    const confirmPassword = document.getElementById('regConfirmPassword').value
    const error= document.getElementById('errorpassword');
    const errorconfirm = document.getElementById('errorConfirmpassword');
    if (password === "") {
        error.textContent = "Field is Empty";
    } else {
        error.textContent = "";
    }

    if (confirmPassword === "") {
        errorconfirm.textContent = "Field is Empty";
    } else if (password !== confirmPassword) {
        errorconfirm.textContent = "Passwords do not match";
    } else {
        errorconfirm.textContent = "";
    }
}
