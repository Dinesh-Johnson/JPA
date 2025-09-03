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
      const errormail = document.getElementById("errormail").innerText.trim();
      const errormobile = document.getElementById("errormobile").innerText.trim();

      const submit = document.querySelector("#form button[type='submit']");

      if(errormail !== "" || errormobile !== ""){
          submit.disabled = true;
      } else {
          submit.disabled = false;
      }
  }


document.addEventListener("DOMContentLoaded", function () {
    console.log("✅ DOM is ready, script is running");

    const stateDropdown = document.getElementById("state");
    console.log("State dropdown found:", stateDropdown);

    // test add one option
    let testOpt = document.createElement("option");
    testOpt.value = "Test";
    testOpt.textContent = "Test State";
    stateDropdown.appendChild(testOpt);
});






