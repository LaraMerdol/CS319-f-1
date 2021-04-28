package Entity;
import java.util.ArrayList;

/**
 * This is the TA Entity class of the application
 * It extends the User class.
 */
public class TA extends User {
    // Variables
    private ArrayList<String> groups;
    private ArrayList<String> sections;

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
     * @param groups groups that TA is assigned (group-f1, geoup-g2 etc.)
     * @param sections that TA is enrolled (1,3,4)
     */
    public TA(String name, String surname, String email, String password, int schoolID, ArrayList<String> groups, ArrayList<String> sections) {
        super(name,surname,email,password,schoolID,"TA");
        setGroups(groups);
        setSections(sections);
    }

    // Getters and Setters //
    /**
     * This method returns the groups that TA is assigned.
     * @return groups that TA is assigned in ArrayList<String> format
     */
    public ArrayList<String> getGroups() {
        return groups;
    }

    /**
     * This method sets the groups that TA is assigned
     * @param groups that TA is assigned in ArrayList<String> format
     */
    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }

    /**
     * This method returns the sections that TA is enrolled.
     * @return sections that TA is enrolled in ArrayList<String> format
     */
    public ArrayList<String> getSections() {
        return sections;
    }

    /**
     * This method sets the sections that TA is enrolled
     * @param sections that TA is enrolled in ArrayList<String> format
     */
    public void setSections(ArrayList<String> sections) {
        this.sections = sections;
    }
}
