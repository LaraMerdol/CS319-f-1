const buttonAssignRole = document.getElementById("buttonAssignRole");
const buttonCreateSection = document.getElementById("buttonCreateSection");
const buttonAddUser = document.getElementById("buttonAddUser");

buttonAssignRole.addEventListener("click", function (e) {
  e.preventDefault();
  let UserID = parseInt(document.getElementById("RoleUserID").value);
  let sectionNumber = document.getElementById("Options").value;
  console.log(UserID);
  console.log(sectionNumber);
});

buttonCreateSection.addEventListener("click", function (e) {
  e.preventDefault();
  let instructorID = parseInt(document.getElementById("InstructorID").value);
  let sectionNumber = parseInt(document.getElementById("sectionNumber").value);
  console.log(instructorID);
  console.log(sectionNumber);
});

buttonAddUser.addEventListener("click", function (e) {
  e.preventDefault();
  let userID = parseInt(document.getElementById("AssignUserID").value);
  let sectionNumber = parseInt(
    document.getElementById("AssignSectionNumber").value
  );
  console.log(userID);
  console.log(sectionNumber);
});
