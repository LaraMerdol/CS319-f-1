package Entity;
import java.util.Date;

public class Message {

    private int senderid;
    private String message;
    private Date date;
    private boolean deleted;

    public Message(int senderid, String message, Date date, boolean deleted )
    {
        this.senderid = senderid;
        this.message = message;
        this.date = date;
        this.deleted = deleted;
    }

    public int getSenderid() {
        return senderid;
    }

    public void setSenderid(int senderid) {
        this.senderid = senderid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
