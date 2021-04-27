package Controller;
import Entity.*;
import DataBase.mongoDB;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;

public class PeerReviewController
{
    public static  mongoDB database;

    public PeerReviewController()
    {
        database = new mongoDB();
    }

    /*
    public ArrayList<Question> getAllReviewQuestion()
    {
        return database.getReviewQuestions();
    }
    */


    public boolean insertPeerReview(Peer_Review pf)
    {
       // return database.insertPeerReview(pf.getGiverId(), pf.getReceiverId(), pf.getPeerFeedbackType(), pf.getAnswers());
        return true;
    }


}
