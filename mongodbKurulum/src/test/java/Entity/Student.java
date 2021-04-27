package Entity;
import java.util.ArrayList;

public class Student extends User {
    private String section;
    private String groupId;


    public Student(String name, String surname, String email, String password, int schoolID, String userRole, String section, String groupId) {
        super(name, surname, email, password, schoolID, userRole);
        this.section = section;
        this.groupId = groupId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


}
