package Entity;
import java.util.ArrayList;

/**
 * This class is the Instructor Entity extended from User class.
 */
public class Instructor extends User {
    // Variables
    private ArrayList<Integer> sections;
    private ArrayList<Integer> TAlist;

    // constructors
    /**
     * This class is the default constructor of Instructor class.
     */
    public Instructor() {}


    public Instructor(String name, String surname, String email, String password, int schoolId,
                      ArrayList<Integer> sections, ArrayList<Integer> TAlist)
    {
       super(name,surname,email,password, schoolId, "instructor");
        this.sections = sections;
        this.TAlist = TAlist;
    }

    public ArrayList<Integer> getTAlist() {
        return TAlist;
    }

    public void setTAlist(ArrayList<Integer> taList) {
        this.TAlist = TAlist;
    }

    public ArrayList<Integer> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Integer> sections) {
        this.sections = sections;
    }
}
