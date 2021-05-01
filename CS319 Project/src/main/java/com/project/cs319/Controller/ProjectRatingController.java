package com.project.cs319.Controller;
import com.project.cs319.DataBase.mongoDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProjectRatingController")
public class ProjectRatingController {

    private mongoDB database;

    public ProjectRatingController()
    {
        database = new mongoDB();
    }

    @GetMapping("/giveRateToProject")
    public void giveRateToProject(String groupName, int rate)
    {
        database.giveRateToProject(groupName, rate);
    }

    @GetMapping("/getRateOfProject")
    public double getRateOfProject(String groupName)
    {
        return database.getRateOfProject(groupName);
    }
}
