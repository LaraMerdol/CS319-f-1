package Entity;
import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseId;
    private ArrayList<Integer> sectionId;


    public Course() {}

    public Course(String courseName, String courseId, ArrayList<Integer> sectionId)
    {
        this.courseName = courseName;
        this.courseId = courseId;
        this.sectionId = sectionId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Integer> getSectionId() {
        return sectionId;
    }

    public void setSectionId(ArrayList<Integer> sectionId) {
        this.sectionId = sectionId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
