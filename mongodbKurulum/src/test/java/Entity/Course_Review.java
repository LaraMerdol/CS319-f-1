package Entity;
public class Course_Review extends Review
{
    private String courseReviewId;

    public Course_Review() {}

    public Course_Review(int giverId, String receiverId, String courseReviewId)
    {
      super(giverId,receiverId,"course");
      this.courseReviewId = courseReviewId;
    }

    public String getCourseReviewId() {
        return courseReviewId;
    }

    public void setCourseReviewId(String courseReviewId) {
        this.courseReviewId = courseReviewId;
    }
}
