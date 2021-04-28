package Entity;
import java.util.ArrayList;

public class Group
{
    private ArrayList<Integer> studentIDs;
    private String groupId;
    private ArrayList<Peer_Review> peerReviews;

    public Group() {}

    public Group(ArrayList<Integer> studentIDs, String groupId, ArrayList<Peer_Review> peerReviews)
    {
        this.studentIDs = studentIDs;
        this.groupId = groupId;
        this.peerReviews = peerReviews;
    }

    public ArrayList<Integer> getStudentIDs() {
        return studentIDs;
    }

    public void setStudentIDs(ArrayList<Integer> studentIDs) {
        this.studentIDs = studentIDs;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ArrayList<Peer_Review> getPeerReviews() {
        return peerReviews;
    }

    public void setPeerReviews(ArrayList<Peer_Review> peerReviews) {
        this.peerReviews = peerReviews;
    }
}
