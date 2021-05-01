package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GroupFormationController")
public class GroupFormationController {
    private  mongoDB database;
    private ArrayList<User> membersOfGroup;

    public GroupFormationController(){
        database = new mongoDB();
    }

    @GetMapping("/randomGeneratorAllSections")
    public void randomGeneratorAllSections(int size) throws JSONException {
        database = new mongoDB();
        SectionController s = new SectionController();
        String sectionNumbers = s.getAllSectionNames();
        JSONObject array = new JSONObject(sectionNumbers);
        ArrayList<Integer> remainStudents = new ArrayList<>();
        // For each section
        for (int i = 0; i < array.names().length(); i++) {
            // Assign remaining students to the students ArrayList
            // Print All Remaining Users
            System.out.println( randomGenerator(size, Integer.parseInt(array.getString("" + i))));

        }

    }


    @GetMapping("/randomGenerator")
    public  String randomGenerator(int size, int sectionID) {
        database = new mongoDB();
        int numberOfStudent = database.getNumberOfStudentsFromSection(sectionID);
        int groupSize = size;

        ArrayList<Integer> idOfStudentsInSection = database.getAllStudentsIdFromSection(sectionID);

        Collections.shuffle(idOfStudentsInSection, new Random());

        char groupName = 'a';
        int index =0;
        for (int i = 0; i < (Integer) (numberOfStudent / groupSize); i++, groupName++) {
            String groupID = "CS319-" + sectionID + groupName;

            // database
            database.createGroup(groupID);
            for (int whileIndex = 0; whileIndex < groupSize; whileIndex++, index++) {
                database.insertStudentToGroup(groupID, idOfStudentsInSection.get(whileIndex + groupSize * i), sectionID);
            }
        }
        if(index == numberOfStudent)
        {
            return null;
        }
        ArrayList<Integer> remainStudents = new ArrayList<Integer>();
        for(int i = index;  i < numberOfStudent; i++)
        {
            remainStudents.add(idOfStudentsInSection.get(i));

        }
        System.out.println((new JSONArray(remainStudents)).toString());
        return (new JSONArray(remainStudents)).toString();
    }

    @GetMapping("/notRandomGenerator")
    public void notRandomGenerator(int sectionID, int studentID)
    {
        database = new mongoDB();
        database.createGroupByUser(sectionID,studentID);
    }

    @GetMapping("/notRandomGeneratorAddMember")
    public void notRandomGeneratorAddMember(int studentID, String groupName,int sectionID) {
        database = new mongoDB();
        database.insertStudentToGroup(groupName,studentID,sectionID);
    }

    @GetMapping("/removeUserFromGroup")
    public boolean removeUserFromGroup(int studentID) {
        database = new mongoDB();
        return database.removeUserFromGroup(studentID);
    }

    @GetMapping("/removeGroup")
    public boolean removeGroup(String name) {
        Group gr = database.getGroup(name);
        for(int i=0; i<gr.getStudentIDs().size(); i++) {
            if(removeUserFromGroup(gr.getStudentIDs().get(i)) ) {
                System.out.println("User " + gr.getStudentIDs().get(i) + " couldn't removed from group.");
            }
        }

        return true;
    }

}
