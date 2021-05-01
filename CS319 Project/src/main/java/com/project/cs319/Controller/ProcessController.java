package com.project.cs319.Controller;

import com.project.cs319.DataBase.mongoDB;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/ProcessController")
public class ProcessController
{
    public static mongoDB database;

    public ProcessController()
    {
        database = new mongoDB();
    }

    @GetMapping("/getGroupFormationStatus")
    public String getGroupFormationStatus()
    {
        return database.getGroupFormationStatus("process");
    }

    @GetMapping("/isPeerReviewONOrOff")
    public String isPeerReviewONOrOff()
    {
        return database.isPeerReviewOnOrOff("process");
    }

    @GetMapping("/isCourseReviewONOrOff")
    public String isCourseReviewONOrOff()
    {
        return database.isCourseReviewOnOrOff("process");
    }

    @GetMapping("/isProjectRatingOnOrOff")
    public String isProjectRatingOnOrOff()
    {
        return database.isProjectRatingOnOrOff("process");
    }

    @GetMapping("/changeGroupFormation")
    public void changeGroupFormation(String status)
    {
        database.changeGroupFormation(status);
    }

    @GetMapping("/changePeerReview")
    public void changePeerReview(String status)
    {
        database.changePeerReview(status);
    }

    @GetMapping("/changeCourseReview")
    public void changeCourseReview(String status)
    {
        database.changeCourseReview(status);
    }

    @GetMapping("/changeProjectRating")
    public void changeProjectRating(String status)
    {
        database.changeProjectRating(status);
    }
}
