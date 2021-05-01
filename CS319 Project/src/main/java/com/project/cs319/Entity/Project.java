package com.project.cs319.Entity;
import java.util.ArrayList;

public class Project
{
    private ArrayList<Artifact> artifacts;
    private String groupName;
    private String projectDescription;
    private String projectRatingID;

    public Project() {}

    public Project(ArrayList<Artifact> artifacts, String groupName, String projectDescription, String projectRatingID)
    {
        setArtifacts(artifacts);
        setProjectDescription(projectDescription);
        setGroupName(groupName);
        setProjectRatingID(projectRatingID);
    }

    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(ArrayList<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectRatingID() {
        return projectRatingID;
    }

    public void setProjectRatingID(String projectRatingID) {
        this.projectRatingID = projectRatingID;
    }
}
