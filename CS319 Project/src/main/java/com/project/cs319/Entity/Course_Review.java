package com.project.cs319.Entity;

/**
 * This class is the Course_Review Entity class extended from Review class.
 */
public class Course_Review extends Review {
    // Variables
    private String courseReviewId;

    // constructors
    /**
     * This class is the default constructor of of Course_Review class.
     */
    public Course_Review() {}

    /**
     * This class is the main constructor of of Course_Review class.
     * @param giverId
     * @param receiverId
     * @param courseReviewId
     */
    public Course_Review(int giverId, String receiverId, String courseReviewId) {
      super(giverId,receiverId,"course");
      setCourseReviewId(courseReviewId);
    }

    // Getters and Setters //
    /**
     * 
     * @return courseReviewId
     */
    public String getCourseReviewId() {
        return courseReviewId;
    }

    /**
     * 
     * @param courseReviewId
     */
    public void setCourseReviewId(String courseReviewId) {
        this.courseReviewId = courseReviewId;
    }
}
