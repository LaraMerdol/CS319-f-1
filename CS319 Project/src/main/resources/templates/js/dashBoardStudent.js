
function getInformation() {
    setCourseName();
    setSemesterName();
    document.getElementById("studentFullName").innerHTML = localStorage.getItem("name") + " " + localStorage.getItem("surname");
}

function setCourseName() {
    let result;
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentCourseName');
    httpRq.onload = function () {
        result = httpRq.responseText;
        document.getElementById("courseName").innerHTML = result;
    }
    httpRq.send();
}

function logoutSystem() {
    localStorage.clear();
}

function setSemesterName() {
    let result;
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentSemester');
    httpRq.onload = function () {
        result = httpRq.responseText;
        document.getElementById("semesterName").innerHTML = result;
    }
    httpRq.send();
}

function sendMessage() {
    var message1 = document.getElementById("usermsg").value;
    var li = document.createElement("LI");
    li.innerHTML = message1;
    li.value= message;
    if(li.innerHTML != "") {
        document.getElementById("messages").appendChild(li);
    }

    console.log(li.innerHTML);
    document.getElementById("usermsg").value = "";

}

let groups = new Array();
let groups2 = new Array();
groups2.push("group1");
groups2.push("group2");
var section1 = { group: groups , name: "Section1" };
var section2 = { group: groups2 , name: "Section2" };
var currentSection =section1 ;
let sections = new Array();
sections.push(section1);
sections.push(section2);
sections.forEach(function (element){
    var li = document.createElement("LI");
    li.value = element;
    var buttonE = document.createElement('button');
    buttonE.innerText = element.name;
    li.append(buttonE);
    buttonE.onclick = function() {
        currentSection={ group: element.group, name: element.name};
        if(document.getElementById("group-list").innerHTML!=="") {
            document.getElementById("group-list").innerHTML = "";
        }
        renew();
    };
    document.getElementById("section-list").appendChild(li);
});

function renew () {
    currentSection.group.forEach(function(element){
        var li = document.createElement("LI");
        li.value = element;
        var buttonE = document.createElement('button');
        buttonE.innerText = element;
        li.append(buttonE);
        buttonE.onclick = function() {
            localStorage.setItem("viewGroupProfileName", element);
            window.location.href = "GroupProfile.html";
        };
        document.getElementById("group-list").appendChild(li);
    });
}

var formmationStyle = 0;

function createGroup(){
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    // section is 1, needs to be replaced
    httpRequest.open("GET", 'http://localhost:8080//GroupFormationController/randomGenerator?size='+size+'&sectionID='+localStorage.getItem("section"));
    httpRequest.onload = function () {
        alert(httpRequest.responseText);
    }
    httpRequest.send();
    var group = "groupA";
    groups.push(group);
    modal.style.display = "none";
}

var modal = document.getElementById("myModal");

// Get the button that opens the modal
var createGroup = document.getElementById("groupCreate");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
if(modal!== null){
    createGroup.onclick = function() {
        modal.style.display = "block";
        let size = parseInt(document.getElementById("quantity").value);
        let httpRequest = new XMLHttpRequest();
        httpRequest.overrideMimeType("application/json");
        // section is 1, needs to be replaced
        httpRequest.open("GET", 'http://localhost:8080//GroupFormationController/randomGenerator?size='+size+'&sectionID='+localStorage.getItem("section"));
        httpRequest.onload = function () {
            alert(httpRequest.responseText);
        }
        httpRequest.send();
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

function gotoGroupProfile(){
    onclick=localStorage.setItem("viewGroupProfileName","groupA");
    window.location="GroupProfile.html";
}