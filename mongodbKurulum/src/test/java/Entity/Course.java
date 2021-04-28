package Entity;
import java.util.ArrayList;

/**
 * This class is the Course Entity class.
 */
public class Course {
    // Variables
    private String courseName;
    private String courseId;
    private ArrayList<String> sectionId;

    // constructors
    /**
     * This class is the default constructor of Course class.
     */
    public Course() {}

    
    /**
     * This class is the main constructor of of Course class.
     * @param courseName
     * @param courseId
     * @param sectionId
     */
    public Course(String courseName, String courseId, ArrayList<String> sectionId)
    {
        setCourseName(courseName);
        setCourseId(courseId);
        setSectionId(sectionId);
    }

    // Getters and Setters //
    /**
     * 
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 
     * @return courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * 
     * @return sectionId
     */
    public ArrayList<String> getSectionId() {
        return sectionId;
    }

    /**
     * 
     * @param sectionId
     */
    public void setSectionId(ArrayList<String> sectionId) {
        this.sectionId = sectionId;
    }


}
