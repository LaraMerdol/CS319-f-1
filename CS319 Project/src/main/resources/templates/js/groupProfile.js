let requests = new Array();
var request1={name:"Güven"};
var request2={name:"Lara"};
requests.push(request1);
requests.push(request2);

localStorage.setItem("myGroup","groupA");
function myFunction() {

	document.getElementById("Groupname").innerHTML =localStorage.getItem("viewGroupProfileName");
	if(document.getElementById("Groupname").innerHTML!== localStorage.getItem("myGroup")){
		document.getElementById("uploadedFile").style.visibility = "hidden";
		document.getElementById("reviewFiles").style.visibility = "hidden";		
		document.getElementById("row2").style.visibility = "hidden";
		document.getElementById("row3").style.visibility = "hidden";
		document.getElementById("row4").style.visibility = "hidden";
		document.getElementById("row5").style.visibility = "hidden";
	}
	else{
		document.getElementById("row1").style.visibility = "hidden";
	}
  requests.forEach(function (element){
      var li = document.createElement("LI");  
      li.innerText = element.name;
      var buttonE = document.createElement('button');
      buttonE.innerText = "Accept";
      buttonE.setAttribute("id","accept");
      li.append(buttonE);
      buttonE.onclick = function() { }
      var buttonA = document.createElement('button');
      buttonA.setAttribute("id","reject");
      buttonA.innerText = "Reject";
      li.append(buttonA);
      buttonE.onclick = function() { }
      document.getElementById("requests").appendChild(li);  
  });





}

