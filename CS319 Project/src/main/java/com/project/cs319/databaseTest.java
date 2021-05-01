package com.project.cs319;

import com.project.cs319.DataBase.mongoDB;
import com.project.cs319.Entity.*;
import com.project.cs319.Controller.*;
import org.json.JSONException;

public class databaseTest {

    public static void main(String[] args) throws JSONException {
        mongoDB db = new mongoDB();
        UserController ct = new UserController();
        SectionController sc = new SectionController();

//        User instructor = new User("Aynur", "Adayanik","ayananik@bilkent.com", "pass",200,"user");
//        User st1 = new User("Mert","Yildirim","mert2bilejnt.edu.tr","pass", 201,"user");
//        User st2 = new User("Cagtay","Kutlu","ck@bilejnt.edu.tr","pass", 202,"user");
//        User st3 = new User("Elif","Tugay","et@bilejnt.edu.tr","pass", 203,"user");
////        // Add Students
//        db.insertUser(instructor);
//        db.insertUser(st1);
//        db.insertUser(st2);
//        db.insertUser(st3);
////
////        // Assign role to Instructor
//        ct.assignRoleToUser(200, "instructor");
////
////        // Add section
//        sc.addSection(3, 200);
////
////        // Ass students to section
//        sc.addUserToSection(201, 3);
//        sc.addUserToSection(202, 3);
//        sc.addUserToSection(203, 3);

            GroupFormationController df = new GroupFormationController();
//            df.randomGeneratorAllSections(3);
            db.removeGroup("CS319-3a");
//            df.removeUserFromGroup(201);
//            df.removeUserFromGroup(202);
    }
}
