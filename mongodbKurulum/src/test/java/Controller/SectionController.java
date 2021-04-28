package Controller;
import Entity.*;
import DataBase.*;

import java.util.ArrayList;

public class SectionController {
    private  mongoDB database;

    public SectionController(){ database = new mongoDB();}

    public boolean addSection(int sectionNumber, int instructorID, ArrayList<Integer> TAlist)
    {
        return database.createSection(sectionNumber, instructorID, TAlist);
    }
    public boolean addStudentToSection(int schoolID, int sectionNumber)
    {
        return database.insertStudentToSection(schoolID,sectionNumber);
    }

}
