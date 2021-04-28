package Entity;
import java.util.ArrayList;
// Section neden string


/**
 * This is the Student Entity class of the application
 * It extends the User class.
 */
public class Student extends User {
    // Variables
    private String section;
    private String groupId;

    // Constructors
    /**
     * Default constructor of Student class.
     */
    public Student() {}

    /** 
     * This is the main constructor of TA object
     * @param name name of the TA new Student()
     * @param surname surname of the TA
     * @param email email of TA's account
     * @param password password of TA's account
     * @param schoolID school id of the TA
     * @param section section that is enrolled (1)
     * @param groupId that Student is assigned (group-1f)
     */
    public Student(String name, String surname, String email, String password, int schoolID, String section, String groupId) {
        super(name, surname, email, password, schoolID, "student");
        setSection(section);
        setGroupId(groupId);
    }

    // Getters and Setters //
    /**
     * This method returns the section that Student is enrolled.
     * @return section that Student is enrolled in String format
     */
    public String getSection() {
        return section;
    }
    
    /**
     * This method sets the section that Student is enrolled
     * @param section that Student is enrolled in String format
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * This method returns the groupId that Student is assigned.
     * @return groupId that Student is assigned in String format
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method sets the groupId that Student is assigned
     * @param groupId that Student is assigned in String format
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
