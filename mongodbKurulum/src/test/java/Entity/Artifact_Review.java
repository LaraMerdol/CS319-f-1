package Entity;
import java.io.File;
import java.util.ArrayList;

/**
 * This class is the entity class of ArtifactReview extended from Review class.
 * @author group-1f
 * @version 07.05.2021
 */
public class Artifact_Review extends Review
{
    private String comment;
    private File reviewFile;

    /**
     * This is the constructor of ArtifactReview class
     * @param giverId the id of the giver.
     * @param receiverId the receiver's id.
     * @return newArray the sorted output array.
     */
    public Artifact_Review(int giverId, String receiverId, String receiverType, String comment, File reviewFile)
    {
        super(giverId, receiverId, "group");
        setComment(comment);
        setReviewFile(reviewFile);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public File getReviewFile() {
        return reviewFile;
    }

    public void setReviewFile(File reviewFile) {
        this.reviewFile = reviewFile;
    }
}