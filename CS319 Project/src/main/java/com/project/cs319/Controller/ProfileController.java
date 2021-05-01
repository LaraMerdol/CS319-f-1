package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProfileController")
public class ProfileController {

    private mongoDB database;

    public ProfileController()
    {
        database = new mongoDB();
    }


    // Student-------------------------------------------------------------------------
    @GetMapping("/getStudentInformation")
    public Student getStudentInformation(int studentID)
    {
        database = new mongoDB();
        return database.getStudentInformation(studentID);
    }

    // Instructor-------------------------------------------------------------------------
    @GetMapping("/getInstructorInformation")
    public Instructor getInstructorInformation(int instructorID) {
        database = new mongoDB();
        return  database.getInstructorInformation(instructorID);
    }

    // TA-------------------------------------------------------------------------
    @GetMapping("/getTAInformation")
    public TA getTAInformation(int TAid)
    {
        database = new mongoDB();
        return database.getTAInformation(TAid);
    }

    //-------------------------------------------------------------------------
    @GetMapping("/getSpecificPeerReviewOfStudent")
    public Hashtable<Integer,ArrayList<String >> getSpecificPeerReviewOfStudent(int receiverID) {
        database = new mongoDB();
        return database.getSpecificPeerReviewOfStudent(receiverID);
    }


}
