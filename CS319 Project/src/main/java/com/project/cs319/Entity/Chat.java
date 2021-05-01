package com.project.cs319.Entity;
import java.util.ArrayList;

/**
 * This class is the entity class of Chat.
 */
public class Chat {
    // Variables
    private ArrayList<Integer> members;
    private String chatTitle;
    private ArrayList<String> messages;

    // constructors
    /**
     * This class is the main constructor of of Chat class.
     */
    public Chat(ArrayList<Integer> members, String chatTitle, ArrayList<String> messages) {
        setMembers(members);
        setChatTitle(chatTitle);
        setMessages(messages);
    }

    // Getters and Setters //
    /**
     * 
     * @return members
     */
    public ArrayList<Integer> getMembers() {
        return members;
    }

    /**
     * 
     * @param members
     */
    public void setMembers(ArrayList<Integer> members) {
        this.members = members;
    }

    /**
     * 
     * @return chatTitle
     */
    public String getChatTitle() {
        return chatTitle;
    }

    /**
     * 
     * @param chatTitle
     */
    public void setChatTitle(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    /**
     * 
     * @return messages
     */
    public ArrayList<String> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages
     */
    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
}
