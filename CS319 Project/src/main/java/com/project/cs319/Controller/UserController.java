package com.project.cs319.Controller;

import com.project.cs319.DataBase.mongoDB;
import com.project.cs319.Entity.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    private mongoDB database = new mongoDB();

    public UserController()
    {
        database = new mongoDB();
    }

    public void assignRoleToUser(int schoolID,String role)
    {
       database.assignRoleToUser(schoolID,role);
    }
}
