import DataBase.*;
import Controller.*;
import Entity.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        mongoDB database = new mongoDB();


       SignUpController c1 = new SignUpController();

        User user1 = new User("berke", "ceran","berke.ceran@gmail.com", "1234", 2222,"admin");
       // c1.signUp(user1.getName(), user1.getSurname(),user1.getEmail(), user1.getPassword(),user1.getSchoolId(),user1.getUserRole());


        SectionController s1 = new SectionController();
       // s1.addSection(1,1234,null);
        //s1.addSection(2,1234,null);
        s1.addSection(3,12,null);
        s1.addStudentToSection(21703920,3);

     //  database.printDatas();
/*

        System.out.println(database.getUser(user1.getId()));

        database.insertUser(user2.getId(), user2.getUserName(),user2.getName(), user2.getSurname(),user2.getEmail(),"instructor");

        SignUpController sign1 = new SignUpController();
        System.out.println(sign1.getUser(1233232).getName());
        sign1.createUser(543,"sılber","osman","akca","fsafasfas.com","student", "fsagfsagsagsa");
        sign1.createUser(112,"sılber","osman","akca","fsafasfas.com","student", "1234142");

        AssignPeerReviewController a = new AssignPeerReviewController();
        OpenEndedQuestion q = new OpenEndedQuestion("what would you like to do");
        a.insertOpenEndedQuestion(q);

        PointQuestion q2 = new PointQuestion("bıdı",10,-1);
        a.insertPointQuestion(q2);

        ArrayList<String> answers = new ArrayList<String>();
        answers.add("bıdı");
        answers.add("bıdı2");
        PeerFeedback pf = new PeerFeedback(2183425,3253,answers);
        PeerReviewController b = new PeerReviewController();
        b.insertPeerReview(pf);

        // to reach the students id from javascript the groups will be in the database with the group ids and it will reach each id from that ?


      */
   // GroupFormationController gfc = new GroupFormationController();
   // gfc.randomGenerator(1);
   // gfc.notRandomGenerator("krallar");
       // gfc.notRandomGenerator("cs310");
      //  gfc.notRandomGeneratorAddMember(1, "cs310");
       // gfc.notRandomGeneratorAddMember(345, "cs310");

        //gfc.notRandomGenerator("mami");
     //   gfc.notRandomGeneratorAddMember(1,"mami");
       // gfc.notRandomGeneratorAddMember(999,"mami");
       // gfc.notRandomGeneratorAddMember(112,"mami");
       // gfc.notRandomGeneratorAddMember(345,"mami");
        /*
        AssignPeerReviewController as = new AssignPeerReviewController();
        OpenEndedQuestion q = new OpenEndedQuestion("What would you like to do");
        PointQuestion q1 = new PointQuestion("which one ?",10);
        as.insertPointQuestion(q1);
        as.insertOpenEndedQuestion(q);

        PeerReviewController pc = new PeerReviewController();
        ArrayList<Question> questions = pc.getAllReviewQuestion();
        int a = 0;
        while (a < questions.size())
        {
            System.out.println(questions.get(a).getQuestion());
            a = a + 1;
        }


        ArtifactReview ar = new ArtifactReview();
        ar.setSenderId("21803313");
        ar.setGroupName("group-f");
        ar.setArtifactName("analysis-report");
        ar.setComment("Not good");
        ArtifactReviewController c = new ArtifactReviewController();
        c.insertArtifactReviewByComment(ar);


         */




    }
}



