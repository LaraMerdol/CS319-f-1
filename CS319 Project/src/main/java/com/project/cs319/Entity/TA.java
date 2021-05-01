package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This is the TA Entity class of the application
 * It extends the User class.
 */
public class TA extends User {
    // Variables
    private ArrayList<Integer> sections;

    // Constructors
    /**
     * Default constructor of TA class.
     */
    public TA() {}

    /** 
     * This is the main constructor of TA object
     * @param name name of the TA
     * @param surname surname of the TA
     * @param email email of TA's account
     * @param password password of TA's account
     * @param schoolID school id of the TA
     * @param sections that TA is enrolled (1,3,4)
     */
    public TA(String name, String surname, String email, String password, int schoolID, ArrayList<Integer> sections) {
        super(name,surname,email,password,schoolID,"TA");
        setSections(sections);
    }

    // Getters and Setters //
    /**
     * This method returns the sections that TA is enrolled.
     * @return sections that TA is enrolled in ArrayList<String> format
     */
    public ArrayList<Integer> getSections() {
        return sections;
    }

    /**
     * This method sets the sections that TA is enrolled
     * @param sections that TA is enrolled in ArrayList<String> format
     */
    public void setSections(ArrayList<Integer> sections) {
        this.sections = sections;
    }
}
