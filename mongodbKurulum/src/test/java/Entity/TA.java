package Entity;
import java.util.ArrayList;


public class TA extends User
{
    private ArrayList<String> groups;
    private ArrayList<String> sections;

    public TA() {}

    public TA(String name, String surname, String email, String password,int schoolID, String userRole, ArrayList<String> groups, ArrayList<String> sections) {
        super(name,surname,email,password,schoolID,userRole);
        this.groups = groups;
        this.sections = sections;

    }

    public ArrayList<String> getSections() {
        return sections;
    }

    public void setSections(ArrayList<String> sections) {
        this.sections = sections;
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }


}
