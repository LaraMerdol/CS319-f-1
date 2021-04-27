package Entity;
import java.util.ArrayList;

public class Instructor extends User
{

    private ArrayList<String> sections;
    private ArrayList<Integer> TAlist;

    public Instructor() {}


    public Instructor(String name, String surname, String email, String password, int schoolId, String userRole,
                      ArrayList<String> sections, ArrayList<Integer> TAlist)
    {
       super(name,surname,email,password, schoolId, userRole);
        this.sections = sections;
        this.TAlist = TAlist;
    }

    public ArrayList<Integer> getTAlist() {
        return TAlist;
    }

    public void setTAlist(ArrayList<Integer> taList) {
        this.TAlist = TAlist;
    }

    public ArrayList<String> getSections() {
        return sections;
    }

    public void setSections(ArrayList<String> sections) {
        this.sections = sections;
    }


}
