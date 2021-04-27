package Controller;
import Entity.*;
import DataBase.mongoDB;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class GroupFormationController {
    private  mongoDB database;
    private ArrayList<User> membersOfGroup;

    public GroupFormationController(){
        database = new mongoDB();
    }


    public  ArrayList<Integer> randomGenerator(int size){
       int numberOfStudent = database.getNumberOfStudent();
       int groupSize = size;
       ArrayList<Integer> idOfUsers = database.getAllStudentsId();
        Collections.shuffle(idOfUsers, new Random());
        int index = 0;
        int whileIndex = 0;
        int groupNameNumber = 1;
        for(int i = 0; i < (Integer)(numberOfStudent/groupSize); i++)
        {
            ArrayList<Integer> members = new ArrayList<Integer>();
            while(whileIndex < size)
            {
                members.add(idOfUsers.get(index));
                index++;
                whileIndex++;
            }
            whileIndex = 0;
            database.insertGroupByRandom(groupNameNumber,members);
            groupNameNumber++;
        }
        ArrayList<Integer> remainStudentsArray = new ArrayList<Integer>();
        if(numberOfStudent % size > 0)
        {
            int remainStudents = numberOfStudent % size;

            for(int i  = remainStudents; i >0; i--)
            {
                remainStudentsArray.add(idOfUsers.get(idOfUsers.size()-i));
            }
        }
        return remainStudentsArray;
    }

    public void notRandomGenerator(String groupName)
    {
        database.createEmptyGroup(groupName);
    }
    public void notRandomGeneratorAddMember(int id, String groupName)
    {
        database.insertGroupByMember(id,groupName);
    }



}
