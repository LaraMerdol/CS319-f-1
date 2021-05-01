package com.project.cs319.Entity;
import java.util.ArrayList;

public class Peer_Review extends Review
{
    private String peerReviewType;

    public Peer_Review(){ }

    public Peer_Review(int giverId, String receiverId, String peerReviewType, String answer) {
        super(giverId,receiverId,"student");
        this.peerReviewType = peerReviewType;
    }


    public String getPeerReviewType() {
        return peerReviewType;
    }

    public void setPeerReviewType(String peerReviewType) {
        this.peerReviewType = peerReviewType;
    }
}