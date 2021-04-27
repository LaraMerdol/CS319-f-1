package Controller;
import Entity.*;
import DataBase.mongoDB;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;

public class AssignPeerReviewController {

    public static  mongoDB database;

    public AssignPeerReviewController()
    {
        database = new mongoDB();
    }
    /*
    inserting review question from the interface to controller to database of the system
    open-ended question: questionChoices and questionMaxRate will be 0
    multipleChoice question: questionMaxRate will be 0
    ratequestion: questionchoices will be 0
     */

    public void insertOpenEndedQuestion(OpenEndedQuestion q)
    {
        database.insertReviewQuestion(q.getQuestion(), "open-ended",null, 0);
    }

    public void insertPointQuestion(PointQuestion q)
    {
        database.insertReviewQuestion(q.getQuestion(), "point-question", null, q.getOutOfGrade());
    }

    public void insertMultipleChoiceQuestion(MultipleChoiceQuestion q)
    {
        database.insertReviewQuestion(q.getQuestion(), "multiple-choice",q.getChoices(),0);
    }

   /* public ArrayList<Question> getAllReviewQuestion()
    {
        return database.getReviewQuestions();
    }
    */

}
