function myFunction() {
    document.getElementById("name").innerHTML =" Name : "+ localStorage.getItem("name");
    document.getElementById("surname").innerHTML =" Surname : "+ "Merdol";//localStorage.getItem("name");
    document.getElementById("Email").innerHTML =" Email : "+ "lara.merdol@gmail.com";//localStorage.getItem("Email");
    document.getElementById("Course").innerHTML =" Course : "+ "CS319";//localStorage.getItem("Course");
    document.getElementById("Semester").innerHTML =" Semester : "+ "2020-2021 Spring";//localStorage.getItem("Semester");
    document.getElementById("Section").innerHTML =" Section : "+ "3";//localStorage.getItem("Section");
    document.getElementById("Group").innerHTML =" Group : "+ "group-f";//localStorage.getItem("Group");
    //yukarıdaki kodları düzeltmeyi unutma

}
//for show how to use

/*
var student1={ name: "student1"};
var student2={ name: "student2"};
var student3={ name: "student3"};
var student4={ name: "student4"};

var currentSection =student1 ;
let groupmembers = new Array();
groupmembers.push(student1);
groupmembers.push(student2);
groupmembers.push(student3);
groupmembers.push(student4);
*/
//write your code here
let reviews = new Array();
reviews.push("Peer1 Review");
reviews.push("Peer2 Review");
reviews.push("Peer3 Review");
reviews.push("Peer4 Review");
var student1PeerReview={ name: "Student 1 Peer Review:"};
var student2PeerReview={ name: "Student 2 Peer Review"};
var student3PeerReview={ name: "Student 3 Peer Review"};
var student4PeerReview={ name: "Student 4 Peer Review"};

var student1 = { review: reviews , name: "Student1" };
var student2 = { review: reviews , name: "Student2" };
var student3 = { review: reviews , name: "Student3" };
var student4 = { review: reviews , name: "Student4" };

var currentStudent =student1 ;
let students = new Array();
students.push(student1);
students.push(student2);
students.push(student3);
students.push(student4);

students.forEach(function (element){
    var li = document.createElement("LI");
    li.value = element;
    var buttonE = document.createElement('button');
    buttonE.innerText = element.name;
    li.append(buttonE);
    buttonE.onclick = function() {
        currentStudent={ review: element.review, name: element.name};
        if(document.getElementById("reviews").innerHTML!==""){
            document.getElementById("reviews").innerHTML=""; //group list

        }


        renew();
    };
    document.getElementById("students").appendChild(li);  //sectionlist
});



function renew () {
    currentStudent.review.forEach(function(element){
        var li = document.createElement("LI");
        li.value = element;
        var buttonE = document.createElement('button');
        buttonE.innerText = element;
        li.append(buttonE);
        buttonE.onclick = function() { };
        document.getElementById("reviews").appendChild(li);
    });

}