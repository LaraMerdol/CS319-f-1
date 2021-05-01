package com.project.cs319.Entity;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class is the entity class of Artifact.
 */
public class Artifact {
    // Variables
    private String giverGroupName;
    private String name;
    private String description;
    private Date uploadDate;
    private double grade;
    private ArrayList<String> reviews;

    // Constructor
    /**
     * This is the constructor of Artifact class
     * @param giverGroupName 
     * @param name 
     * @param description 
     * @param uploadDate 
     * @param grade 
     * @param reviews
     */
    public Artifact(String giverGroupName, String name, String description, Date uploadDate,
                    double grade, ArrayList<String> reviews) {
        setGiverGroupName(giverGroupName);
        setName(name);
        setDescription(description);
        setUploadDate(uploadDate);
        setGrade(grade);
        setReviews(reviews);
    }

    // Getters and Setters //
    /**
     * 
     * @return giverGroupName
     */
    public String getGiverGroupName() {
        return giverGroupName;
    }

    /**
     * 
     * @param giverGroupName
     */
    public void setGiverGroupName(String giverGroupName) {
        this.giverGroupName = giverGroupName;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return uploadDate
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * 
     * @param uploadDate
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * 
     * @return grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * 
     * @param grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * 
     * @return reviews
     */
    public ArrayList<String> getReviews() {
        return reviews;
    }

    /**
     * 
     * @param reviews
     */
    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }
}
