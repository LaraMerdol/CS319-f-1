package Entity;
import java.util.ArrayList;
import java.util.Date;

public class Artifact {
    private String giverGroupName;
    private String name;
    private String description;
    private Date uploadDate;
    private double grade;
    private String artifactLink;
    private ArrayList<Artifact_Review> reviews;

    public Artifact(String giverGroupName, String name, String description, Date uploadDate,
                    double grade, ArrayList<Artifact_Review> reviews)
    {
        setDescription(description);
        this.uploadDate = uploadDate;
        this.name = name;
        this.giverGroupName = giverGroupName;
        this.grade = grade;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiverGroupName() {
        return giverGroupName;
    }

    public void setGiverGroupName(String giverGroupName) {
        this.giverGroupName = giverGroupName;
    }

    public void setReviews(ArrayList<Artifact_Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Artifact_Review> getReviews() {
        return reviews;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getArtifactLink() {
        return artifactLink;
    }

    public void setArtifactLink(String artifactLink) {
        this.artifactLink = artifactLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
