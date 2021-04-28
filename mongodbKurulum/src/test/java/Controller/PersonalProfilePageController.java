package Controller;
import Entity.*;
import DataBase.mongoDB;
import java.util.ArrayList;

public class PersonalProfilePageController
{
    public static  mongoDB database;

    public PersonalProfilePageController()
    {
        database = new mongoDB();
    }

    public ArrayList<String> getUserDetails(int id)
    {
         return database.getUserDetails(id);
    }

    public ArrayList<Peer_Review> getUserPeerReviews(int id)
    {
        return getUserPeerReviews(id);
    }

    public String getUserGroupName(int id)
    {
        return database.findGroupNameOfUser(id);
    }
}
