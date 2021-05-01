package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/CurrentSystemInfoController")
public class CurrentSystemInfoController {

    public static mongoDB database;

    public CurrentSystemInfoController()
    {
        database = new mongoDB();
    }

    @GetMapping("/getCurrentCourseName")
    public String getCurrentCourseName()
    {
        return database.getCurrentCourseName("currentSystemInfo");
    }

    @GetMapping("/getCurrentSemester")
    public String getCurrentSemester()
    {
        return database.getCurrentSemester("currentSystemInfo");
    }

    @GetMapping("/changeCurrentCourseName")
    public void changeCurrentCourseName(String courseName)
    {
        database.changeCurrentCourseName(courseName);
    }

    @GetMapping("/changeCurrentSemester")
    public void changeCurrentSemester(String semester)
    {
        database.changeCurrentSemester(semester);
    }
}


