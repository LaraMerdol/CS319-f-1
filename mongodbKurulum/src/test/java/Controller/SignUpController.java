package Controller;
import Entity.*;
import DataBase.mongoDB;
import org.bson.Document;

public class SignUpController {

   private mongoDB database;

    public SignUpController()
    {
        database = new mongoDB();

    }

    public void signUp( String name, String surname, String email, String password , int schoolID, String userRole){
        User u = new User(name, surname, email, database.secretPassword(password), schoolID, userRole);
        database.insertUser(u);

    }

    public User login(int schoolID) {
        return database.getUser(schoolID);
    }

}
