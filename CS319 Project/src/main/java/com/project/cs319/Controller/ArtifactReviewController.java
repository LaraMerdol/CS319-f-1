package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import java.util.Hashtable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ArtifactReviewController")
public class ArtifactReviewController
{
    public static  mongoDB database;

    public ArtifactReviewController()
    {
        database = new mongoDB();
    }

    @GetMapping("/giveArtifactReviewToGroup")
    public boolean giveArtifactReviewToGroup(String groupName, String artifactType, String answer, int giverID)
    {
        database = new mongoDB();
        return database.giveArtifactReviewToGroup(groupName, artifactType, answer, giverID);
    }

    @GetMapping("/getArtifactReviewFromGroup")
    public Hashtable<Integer,String> getArtifactReviewFromGroup(String groupName, String artifactType)
    {
        database = new mongoDB();
        return database.getArtifactReviewFromGroup(groupName,artifactType);
    }

}
