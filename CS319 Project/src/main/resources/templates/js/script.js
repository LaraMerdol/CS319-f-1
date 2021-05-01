let user;

function loginToSystem() {
    // Variables
    let pass =document.getElementById("Pass").value;
    let userName = parseInt(document.getElementById("Uname").value);
    // Http Protocol
    let result = "false";
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/SignUpController/validateUser?schoolID='+userName+'&password='+pass);
    httpRq.onload = function () {
        result = httpRq.responseText;
        if(result === "true") {
            let httpRequest = new XMLHttpRequest();
            httpRequest.overrideMimeType("application/json");
            httpRequest.open("GET", 'http://localhost:8080/SignUpController/login?schoolID='+parseInt(document.getElementById("Uname").value));
            httpRequest.onload = function () {
                user = JSON.parse(httpRequest.responseText);
                localStorage.setItem("id", document.getElementById("Uname").value);
                localStorage.setItem("name",user["name"]);
                localStorage.setItem("surname", user["surname"]);
                localStorage.setItem("email", user["email"]);
                localStorage.setItem("userRole",user["userRole"]);
                if(user["userRole"] === "student") {
                    let httpRequest1 = new XMLHttpRequest();
                    httpRequest1.overrideMimeType("application/json");
                    httpRequest1.open("GET", 'http://localhost:8080/SectionController/getSectionOfStudent?studentID='+parseInt(document.getElementById("Uname").value));
                    httpRequest1.onload = function () {
                        let section = httpRequest1.responseText;
                        localStorage.setItem("section", section);
                    }
                    httpRequest1.send();
                } else if(user["userRole"] === "instructor") {
                    let httpRequest2 = new XMLHttpRequest();
                    httpRequest2.overrideMimeType("application/json");
                    httpRequest2.open("GET", 'http://localhost:8080/SectionController/getAllSectionsOfInstructor?instructorID='+parseInt(document.getElementById("id").value));
                    httpRequest2.onload = function () {
                        let sections = httpRequest2.responseText;
                        localStorage.setItem("sections", sections);
                        if(Object.keys(JSON.parse(sections)).length != 0 ) {
                            localStorage.setItem("currentSection", sections[0]);
                        }
                    }
                    httpRequest2.send();
                }
                goDash();
            }
            httpRequest.send();
        } else {
            alert("Invalid Username or Password.");
            document.getElementById("Pass").innerText = "";
            document.getElementById("Uname").innerText = "";
        }
    }
    httpRq.send();
}

function signUp() {
    let name = document.getElementById("Name").value;
    let surname = document.getElementById("Surname").value;
    let id = parseInt(document.getElementById("ID").value,10);
    let pass= document.getElementById("sign_up_pass").value;
    let confirmpass = document.getElementById("ConfirmPass").value;
    let email = document.getElementById("EMail").value;
    let userRole = "user";
    if(confirmpass == pass) {
        let httpRequest = new XMLHttpRequest();
        httpRequest.overrideMimeType("application/json");
        httpRequest.open("GET", 'http://localhost:8080/SignUpController/signUp?name='+name+'&surname='+surname
            +'&email='+email+'&password='+pass+'&schoolID='+id+'&userRole='+userRole);
        httpRequest.onload = function () {
        }
        httpRequest.send();
    } else {
        alert("Passwords are not matching!");
    }
}

function goDash(){
    if(localStorage.getItem("userRole")=== "student"){
        window.location.href = "DashboardStudent.html";
    }
    else if(localStorage.getItem("userRole")=== "instructor" || localStorage.getItem("userRole")=== "TA" ){
        window.location.href = "DashboardInstructor.html";
    }
    else {
        alert("Ups.. Since you are not enrolled to any course, you cannot enter the system.");
    }
} 