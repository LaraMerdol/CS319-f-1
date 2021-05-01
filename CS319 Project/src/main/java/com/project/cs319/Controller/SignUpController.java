package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/SignUpController")
public class SignUpController {

    private mongoDB database = new mongoDB();

    public SignUpController()
    {
        database = new mongoDB();
    }

    @GetMapping("/signUp")
    public void signUp( String name, String surname, String email, String password, int schoolID,String userRole){
        User u = new User(name, surname, email, database.secretPassword(password), schoolID,userRole);
        database.insertUser(u);
    }

    @GetMapping("/login")
    public String login(int schoolID) throws JSONException {
        System.out.println(schoolID);
        User u1 = database.getUser(schoolID);

        JSONObject obj = new JSONObject();
        obj.put("name",u1.getName());
        obj.put("surname", u1.getSurname());
        obj.put("email", u1.getEmail());
        obj.put("password", u1.getPassword());
        obj.put("userRole",u1.getUserRole());
        System.out.println(obj);
        return obj.toString();
    }

    @GetMapping("/validateUser")
    public String validateUser(int schoolID, String password) {
        System.out.println(schoolID + "    " + password);
        User u1 = database.getUser(schoolID);
        System.out.println(u1.getPassword() + "   " + password);
        if(u1.getPassword().equals(password)) {
            return "true";
        }
        return "false";
    }
}