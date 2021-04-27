package Entity;

import java.util.ArrayList;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;


/**
 * User class of peeray
 */
public class User {
    private String name;
    private String surname;
    private String password;
    private String email;
    private int schoolID;
    private String userRole;

    public User(){}

    /**
     *
     * @param name
     * @param surname
     * @param email
     * @param password
     * @param schoolID
     * @param userRole
     */
    public User (String name, String surname, String email, String password, int schoolID, String userRole) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.schoolID = schoolID;
        this.userRole = userRole;
    }
    // Getters and Setters //

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getSchoolId() {
        return schoolID;
    }

    /**
     *
     * @param schoolID
     */
    public void setSchoolId(int schoolID) {
        this.schoolID = schoolID;
    }

}