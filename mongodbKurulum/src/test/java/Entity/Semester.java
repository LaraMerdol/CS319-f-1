package Entity;
public class Semester {

    private String semester;
    private String courseID;

    public Semester() {}

    public Semester(String semester, String courseID)
    {
        this.semester = semester;
        this.courseID = courseID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
