package Controller;
import Entity.*;
import DataBase.mongoDB;
public class ArtifactReviewController
{
    public static  mongoDB database;

    public ArtifactReviewController()
    {
        database = new mongoDB();
    }

    // the corner case of senderId is not in the group can be added but it can be also done in javascript
    public boolean insertArtifactReviewByComment(Artifact_Review ar)
    {
       // return database.insertArtifactReviewByComment(ar.getGroupName(),ar.getSenderId(),ar.getComment(),ar.getArtifactName());
        return true;
    }

}
