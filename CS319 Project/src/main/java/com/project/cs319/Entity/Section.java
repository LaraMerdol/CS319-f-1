package com.project.cs319.Entity;
import java.util.ArrayList;

public class Section
{
    private int sectionId;
    private ArrayList<String> groupIds;
    private int instructorID;
    private ArrayList<Integer> TAlist;
    private ArrayList<Integer> students;
    private String courseReviewsID;

    public Section() {}

    public Section(int sectionId, ArrayList<String> groupIds, int instructorID, ArrayList<Integer> TAlist,
                   ArrayList<Integer> students, String courseReviewsID)
    {
        this.sectionId = sectionId;
        this.groupIds = groupIds;
        this.instructorID = instructorID;
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

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId( int sectionId) {
        this.sectionId = sectionId;
    }

    public int getInstructor() {
        return instructorID;
    }

    public void setInstructor(int instructorID) {
        this.instructorID = instructorID;
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
