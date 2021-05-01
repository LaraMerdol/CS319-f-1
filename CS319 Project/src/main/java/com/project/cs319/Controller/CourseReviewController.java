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
@RequestMapping("/CourseReviewController")
public class CourseReviewController {

    public static  mongoDB database;

    public CourseReviewController()
    {
        database = new mongoDB();
    }

    @GetMapping("/insertOpenEndedQuestionCourse")
    public boolean insertOpenEndedQuestionCourse(String question)
    {
        database = new mongoDB();
        return database.insertOpenEndedQuestionCourse(question);
    }

    @GetMapping("/insertMultipleChoiceQuestionCourse")
    public boolean insertMultipleChoiceQuestionCourse(String question, ArrayList<String> choices)
    {
        database = new mongoDB();
        return database.insertMultipleChoiceQuestionCourse(question,choices);
    }

    @GetMapping("/insertPointQuestionCourse")
    public boolean insertPointQuestionCourse(String question, int outOfGrade)
    {
        database = new mongoDB();
        return database.insertPointQuestionCourse(question,outOfGrade);
    }

    @GetMapping("/getCourseReviewQuestions")
    public ArrayList<Question> getCourseReviewQuestions()
    {
        database = new mongoDB();
        return database.getCourseReviewQuestions();
    }

    @GetMapping("/giveAnswerQuestionsCourse")
    public boolean giveAnswerQuestionsCourse(int giverId, ArrayList<String> answer)
    {
        database = new mongoDB();
        return database.giveAnswerQuestionsCourse(giverId,answer);
    }

    @GetMapping("/getCourseReviewAnswers")
    public ArrayList<ArrayList<String>> getCourseReviewAnswers()
    {
        database = new mongoDB();
        return database.getCourseReviewAnswers();
    }

}
