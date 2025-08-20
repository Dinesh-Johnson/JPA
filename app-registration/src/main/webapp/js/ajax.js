function loginemail() {
        const email = document.getElementById('regEmail').value;
        if (email !== "") {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/app-registration/loginemail?regEmail=" + email, true);
            xhttp.send();
            xhttp.onload = function () {
                document.getElementById("errormail").innerHTML = this.responseText;
                toggleSubmit();
            }
        } else {
            document.getElementById("errormail").innerHTML = "";

        }
    }

    function loginmobile() {
        const mobile = document.getElementById('regPhone').value;
        if (mobile !== "") {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/app-registration/loginmobile?regPhone=" + mobile, true);
            xhttp.send();
            xhttp.onload = function () {
                document.getElementById("errormobile").innerHTML = this.responseText;
                toggleSubmit();
            }
        } else {
            document.getElementById("errormobile").innerHTML = "";
        }
    }

    function toggleSubmit(){
        const errormail= document.geElementById("errormail").innerText.trim();
        const errormobile= document.geElementById("errormobile").innerText.trim();

        const submit= document.querySelector("#form button[type='submit']");

        if(errormail !== "" || errormobile!== ""){
            submit.disable=true;
        }else{
            submit.disable=false;
        }

    }