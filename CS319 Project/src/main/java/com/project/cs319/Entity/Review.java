package com.project.cs319.Entity;
import java.util.ArrayList;
public class Review {

        private int giverId;
        private String receiverId;
        private String receiverType;

        public Review() { }

        public Review(int giverId, String  receiverId, String receiverType)
        {
            setGiverId(giverId);
            setReceiverId(receiverId);
            setReceiverType(receiverType);
        }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public int getGiverId() {
        return giverId;
    }

    public void setGiverId(int giverId) {
        this.giverId = giverId;
    }

}
