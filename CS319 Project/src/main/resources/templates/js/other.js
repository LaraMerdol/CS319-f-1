function goDash(){
  alert(localStorage.getItem("userRole"));
  if(localStorage.getItem(localStorage.getItem("userRole"))=== "student"){
    window.location.href = "../html/DashboardStudent.html";
  }
  else if(localStorage.getItem("userRole") === "instructor"
          || localStorage.getItem("userRole") === "TA") {
    window.location.href = "../html/DashboardInstructor.html";
  }
} 
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