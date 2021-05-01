function clearContents(element) {
  element.value = '';
}

function addRateQuestion (){

  const question = { questionText: document.getElementById("RateQuestionQ").value , questionRate :  document.getElementById("selectedRate").value }; 

    let rate = parseInt(question.questionRate,10);
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/PeerReviewController/insertPointQuestion?question='+question.questionText+'&outOfGrade='+rate);
    httpRequest.onload = function () {
            alert("okey");
    }
    httpRequest.send();
   var li = document.createElement("LI");
   li.innerHTML =  question.questionText + "<br>"+ " Maximum Rate: "+ question.questionRate;
   document.getElementById("RatequestionList").appendChild(li);


}

function addOpenEndedQuestion (){

    const question = { questionText: document.getElementById("OpenEndedQ").value};
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/PeerReviewController/insertOpenEndedQuestion?question='+question.questionText);
    httpRequest.onload = function () {
        alert("openEnded");

    }
    httpRequest.send();
    var li = document.createElement("LI");
    li.innerHTML =  question.questionText ;
    document.getElementById("OpenEndedquestions").appendChild(li);
}


function addMultipleChoiceQuestion (){
    const lis = document.getElementById("answerList").innerText;
    var coices = "";
    var clist = new Array();
    var i = 0;
    var j= 5;
    var length =lis.length;
    var k = 0;
    while(j<= length){
        if( lis.substring(i,j+1) == "delete"){

            coices=coices +"-" +lis.substring(k,i);
            clist.push(lis.substring(k,i));
            k=j+1;
            i=i+6;
            j=j+6;
        }
        i++;
        j++;
    }

    let question = { questionText: document.getElementById("MultipleChoiceQ").value, choiceList: coices};

    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/PeerReviewController/insertMultipleChoiceQuestion?question='+question.questionText + '&choices='+coices );
    alert("aler1");
    httpRequest.onload = function () {

    }
    httpRequest.send();





    var li = document.createElement("LI");
    li.innerHTML =  question.questionText + "<br>"+ clist.join("<br>");
    document.getElementById("Choicequestions").appendChild(li);



}
function addItem(){

    let li = document.createElement("LI");
    let input = document.getElementById("ChoiceText");
    li.innerHTML = input.value;

    input.value = ChoiceText.innerHTML;
    li.value =ChoiceText.innerHTML;
    let buttonE = document.createElement('button');
    li.append(buttonE);
    buttonE.innerText = 'delete';
    buttonE.onclick = function() { // remove list item here
        li.remove();
        buttonE.remove();
    };
    document.getElementById("answerList").appendChild(li);




}
