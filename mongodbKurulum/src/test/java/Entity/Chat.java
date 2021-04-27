package Entity;
import java.util.ArrayList;
public class Chat
{
    private ArrayList<Integer> members;
    private String chatTitle;
    private ArrayList<Message> messages;


    public Chat( ArrayList<Integer> members, String chatTitle) {
        this.members = members;
        this.chatTitle = chatTitle;
    }

    public ArrayList<Integer> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Integer> members) {
        this.members = members;
    }

    public String getChatTitle() {
        return chatTitle;
    }

    public void setChatTitle(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    public boolean addMember(int userID) {
        return members.add(userID);
    }

    public boolean removeMember(int userID) {
        int index = members.get(userID);
        if (index != -1) {
            members.remove(index);
            return true;
        }
        return false;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    /*
    public boolean addMessage() {

    }
    */
}
