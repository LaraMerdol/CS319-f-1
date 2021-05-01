package com.project.cs319.Entity;
import java.util.Date;
public class Notification
{
    private String message;
    private int senderId;
    private int receiverId;
    private Date date;

    public Notification(String message, int senderId, int receiverId, Date date)
    {
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}