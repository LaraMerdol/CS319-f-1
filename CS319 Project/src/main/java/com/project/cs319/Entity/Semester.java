package com.project.cs319.Entity;

/**
 * This is the Semester Entity class of the application.
 * Since there will be only one course that will be using our application, 
 * only one course ID is used in parameter.
 */
public class Semester {
    // Variables
    private String semester;
    private String courseID;

    // Constructors
    /**
     * Default constructor of Semester class.
     */
    public Semester() {}

    /**
     * Main constructor of Semester class.
     * @param semester the semester
     * @param courseID the courseID
     */
    public Semester(String semester, String courseID) {
        setSemester(semester);
        setCourseID(courseID);
    }

    // Getters and Setters //
    /**
     * This method returns the semester in string format (2020-2021-Spring).
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * This method sets the semester.
     * @param semester semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * This method returns the course id that semester has. 
     * @return courseID that semester has
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * This method sets the course id that semester has.
     * @param courseID courseID that semester has
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
