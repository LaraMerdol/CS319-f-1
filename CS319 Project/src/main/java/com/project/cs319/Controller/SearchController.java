
package com.project.cs319.Controller;
import com.project.cs319.Entity.*;
import com.project.cs319.DataBase.*;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SearchController")
public class SearchController {
    private  mongoDB database;

    public SearchController(){
        database = new mongoDB();
    }

    @GetMapping("/searchUser")
    public User searchUser(int studentId)
    {
        database = new mongoDB();
        return database.getUser(studentId);
    }

    @GetMapping("/searchGroup")
    public Group searchGroup(String groupName)
    {
        database = new mongoDB();
        return database.getGroup(groupName);
    }


}
