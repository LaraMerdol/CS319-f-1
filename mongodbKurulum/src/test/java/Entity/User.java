package Entity;

import java.util.ArrayList;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;


/**
 * This is the User Entity class of the application
 */
public class User {
    // Variables
    private String name;
    private String surname;
    private String password;
    private String email;
    private int schoolID;
    private String userRole;

    // Constructors
    /**
     * Default constructor of User Object
     */
    public User(){}

    /** 
     * This is the main constructor of User object
     * @param name name of the user
     * @param surname surname of the user
     * @param email email of user's account
     * @param password password of user's account
     * @param schoolID school id of the user
     * @param userRole the role of the user (student, ta, instructor, admin)
     */
    public User (String name, String surname, String email, String password, int schoolID, String userRole) {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
        setSchoolID(schoolID);
        setUserRole(userRole);
    }
    
    // Getters and Setters //
    /**
     * This method returns the name of the user.
     * @return name of the user in String format
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the user
     * @param name name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the surname of the user.
     * @return surname of the user in String format
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This method sets the surname of the user
     * @param surname surname of the user
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * This method returns the email of the user.
     * @return email of user's account
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the email of the user
     * @param email email of user's account
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns the password of the user.
     * @return passwrod of user's account
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the password of the user
     * @param password password of user's account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the school id of the user.
     * @return school id of user in int type
     */
    public int getSchoolId() {
        return schoolID;
    }

    /**
     * This method sets school id the of the user
     * @param schoolID school id of the user
     */
    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    /**
     * This method returns the user role of the user.
     * @return userrole of the user in String format (student, ta, instructor, admin)
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * This method sets the user role of the user
     * @param userRole the role of the user (student, ta, instructor, admin)
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}