function sendMessage() {
  var message1 = document.getElementById("usermsg").value;
  var li = document.createElement("LI");  
  li.innerHTML = message1;
  li.value= message;
  if(li.innerHTML != ""){
    document.getElementById("messages").appendChild(li);
  }
  
  console.log(li.innerHTML);
  document.getElementById("usermsg").value = "";

}

function logoutSystem() {
    localStorage.clear();
}


//Pop up ınstructor start groyp formation
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("groupFormB");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
if(modal!== null){
  btn.onclick = function() {
    modal.style.display = "block";
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

function randomForm() {
    let size = parseInt(document.getElementById("quantity").value);
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    let section = localStorage.getItem("currentSection");
    httpRequest.open("GET", 'http://localhost:8080//GroupFormationController/randomGeneratorAllSections?size='+size);
    httpRequest.onload = function () {
        alert(httpRequest.responseText);
    }
    httpRequest.send();
}

function manualForm(){
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    let section = localStorage.getItem("currentSection");
    httpRequest.open("GET", 'http://localhost:8080//ProcessController/changeGroupFormation?size='+size);
    httpRequest.onload = function () {
        alert(httpRequest.responseText);
    }
    httpRequest.send();
}









//pop-up end



    //write your code here
    var group1={ name: "group1"};
    var group2={ name: "group2"};
    var group3={ name: "group3"};
    var group4={ name: "group4"};
   let groups1 = [group1, group2];
   let groups2 = [group3, group4];

   var section1 = { group: groups1 , name: "Section1" };
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
        if(document.getElementById("group-list").innerHTML!==""){
          document.getElementById("group-list").innerHTML="";

        }
        
        
        renew();
      };
      document.getElementById("section-list").appendChild(li);  
  });

  function renew () {
  currentSection.group.forEach(function(element){
    var li = document.createElement("LI");  
    li.value = element;
    console.log(currentSection.group[1].name);
    console.log(li);
    var buttonE = document.createElement('button');
    buttonE.innerText = element.name;
    li.append(buttonE);
     buttonE.onclick = function() { };  
     document.getElementById("group-list").appendChild(li);  
  });


}
