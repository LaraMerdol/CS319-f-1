package Entity;
import java.util.ArrayList;

public class Section
{
    private String sectionId;
    private ArrayList<String> groupIds;
    private Instructor instructor;
    private ArrayList<Integer> TAlist;
    private ArrayList<Integer> students;
    private String courseReviewsID;

    public Section() {}

    public Section(String sectionId, ArrayList<String> groupIds, Instructor instructor, ArrayList<Integer> TAlist,
                   ArrayList<Integer> students, String courseReviewsID)
    {
        this.sectionId = sectionId;
        this.groupIds = groupIds;
        this.instructor = instructor;
        this.TAlist = TAlist;
        this.students = students;
        this.courseReviewsID = courseReviewsID;
    }

    public ArrayList<Integer> getTAlist() {
        return TAlist;
    }

    public void setTAlist(ArrayList<Integer> TAlist) {
        this.TAlist = TAlist;
    }

    public ArrayList<Integer> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Integer> students) {
        this.students = students;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public ArrayList<String> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(ArrayList<String> groupIds) {
        this.groupIds = groupIds;
    }

    public String getCourseReviews() {
        return courseReviewsID;
    }

    public void setCourseReviews(ArrayList<Course_Review> courseReviews) {
        this.courseReviewsID = courseReviewsID;
    }

}
