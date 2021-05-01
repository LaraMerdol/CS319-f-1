package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PeerReviewController")
public class PeerReviewController {

    public static  mongoDB database;

    public PeerReviewController()
    {
        database = new mongoDB();
    }

    @GetMapping("/insertOpenEndedQuestion")
    public boolean insertOpenEndedQuestion(String question) {
        database = new mongoDB();
        return database.insertOpenEndedQuestion(question);
    }

    @GetMapping("/insertMultipleChoiceQuestion")
    public boolean insertMultipleChoiceQuestion(String question,String choices)  {
        String[] parts = choices.split("-");


        ArrayList<String> list1 = new ArrayList<String>();
        for(String text:parts) {
            if(!text.equals("")) {
                list1.add(text);
            }
        }

        database = new mongoDB();
        return database.insertMultipleChoiceQuestion(question,list1);
    }

    @GetMapping("/insertPointQuestion")
    public boolean insertPointQuestion(String question, int outOfGrade) {
        database = new mongoDB();
        return database.insertPointQuestion(question,outOfGrade);
    }

    @GetMapping("/getPeerReviewQuestions")
    public ArrayList<Question> getPeerReviewQuestions()
    {
        database = new mongoDB();
        return database.getPeerReviewQuestions();
    }

    @GetMapping("/giveAnswerQuestions")
    public boolean giveAnswerQuestions(int giverId, int receiverId, ArrayList<String> answer) {
        database = new mongoDB();
        return database.giveAnswerQuestions(giverId,receiverId,answer);
    }

    @GetMapping("/getPeerReviewAnswers")
    public ArrayList<String> getPeerReviewAnswers(int giverID, int receiverID) {
        database = new mongoDB();
        return database.getPeerReviewAnswers(giverID,receiverID);
    }

}
