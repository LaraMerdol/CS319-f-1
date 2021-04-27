package DataBase;
import Entity.*;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.BsonArray;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.io.File;
import java.io.IOException;


public class mongoDB {
    public static  MongoClient mongoClient;
    public static MongoDatabase database;
    public static MongoCollection<Document> collectionUser;
    public static MongoCollection<Document> collectionReviewQuestions;
    public static MongoCollection<Document> collectionPeerFeedbacks;
    public static MongoCollection<Document> collectionGroups;
    public static MongoCollection<Document> collectionArtifactReviews;
    public static MongoCollection<Document> collectionSection;
    public static Hashtable userPasswords;


    public mongoDB() {
        try {
            mongoClient = MongoClients.create(
                    "mongodb+srv://berke:C-sSv!ABPHeUQ3p@peerreview.pixjl.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
             database = mongoClient.getDatabase("cs319");
             collectionUser = database.getCollection("user");
            collectionReviewQuestions = database.getCollection("reviewQuestions");
            collectionPeerFeedbacks = database.getCollection("peerReviews");
            collectionGroups = database.getCollection("groups");
            collectionSection = database.getCollection("section");
            userPasswords = new Hashtable();

             //System.out.println("bağlantı sağlandı");

            // Getting data from mongodb
/*
            MongoCursor<Document> doc = collection.find().iterator();

            while(doc.hasNext()){
                //System.out.println(doc.next().values()); // taking full data
                ArrayList<Object> property1 = new ArrayList(doc.next().values());
                System.out.println(property1.get(0));
                System.out.println(property1.get(1));
                System.out.println(property1.get(2));
                System.out.println(property1.get(3));
            }
*/
/*            // Uploading datas to mongodb
            Document d1 = new Document("_id", 2);
            d1.append("ad", "sagfsagas");
            d1.append("soyad", "sagsag");
            d1.append("numara", "32323232");
            collection.insertOne(d1);
*/

        } catch (Exception e) {

        }

    }

    public boolean insertUser(String name, String surname, String email, String password, int schoolID, String userRole) {

        // Uploading datas to mongodb
        try {
           if(getUser(schoolID) == null){
                MongoCursor<Document> doc = collectionUser.find().iterator();
                Document d1 = new Document();
                d1.append("name", name);
                d1.append("surname", surname);
                d1.append("email", email);
                d1.append("password", password);
                d1.append("id", schoolID);
                d1.append("userRole", userRole);
                collectionUser.insertOne(d1);
                System.out.println("ekleme tamam");
                return true;
           }
            else
            {
                System.out.println("ekleme olmadıı");
                return false;
          }

        } catch (Exception e) {
            System.out.println("insert user hatalı");
           // System.out.println(e);
            return false;
        }

    }
    public boolean createSection(int sectionNumber, int instructorID, ArrayList<Integer> TAlist)
    {

        Document doc = collectionSection.find( new Document("sectionNumber", sectionNumber)).first();
        if(doc != null)
        {
           return false;
        }
        MongoCursor<Document> doc1 = collectionSection.find().iterator();
        Document d1 = new Document();
        d1.append("sectionNumber", sectionNumber);
        d1.append("groupIds", new ArrayList<String>());
        d1.append("instructor", instructorID);
        d1.append("TAlist", TAlist);
        d1.append("students", new ArrayList<String>());
        collectionSection.insertOne(d1);
        System.out.println("ekleme tamam");
        return true;
    }


    public boolean insertStudentToSection(int schoolID, int sectionNumber) {
        if (getUser(schoolID) == null || !(getUser(schoolID).getUserRole().equals("student")))
        {
            return false;
        }
        try
        {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("sectionNumber", sectionNumber);

            MongoCursor<Document> cursor = collectionSection.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionSection.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> sections = new ArrayList(doc.next().values());

                if ((int)(sections.get(1)) == sectionNumber) {

                    Document str = cursor.next();
                    List<Integer> list = (List<Integer>)str.get("students");
                    if(list.contains(schoolID))
                    {
                        // Student already exist
                        return false;
                    }
                    list.add(schoolID);
                    Document found = (Document) collectionSection.find(new Document("sectionNumber", sectionNumber)).first();
                    Bson updateMember = new Document("students", list);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionSection.findOneAndUpdate(found,updateOperation);
                    System.out.println("Array ekleme tamam");
                    return true;
                }
            }
        }catch (Exception e)
        {
            System.out.println("Error" + e);
            return false;
        }
        System.out.println("Array ekleme yapılamadı");
        return false;
    }







    public User getUser(int id) {
        try{
            Document doc = collectionUser.find( new Document("id", id)).first();

            if(doc != null)
            {
                return new User(doc.getString("name"),
                        doc.getString("surname"),
                        doc.getString("email"),
                        doc.getString("password"),
                        doc.getInteger("id"),
                        doc.getString("userRole"));

            }
            else
            {

                return null;
            }

        }catch(Exception e)
        {
            System.out.println("get user hatalı");
        }
        return null;
    }

    public int getNumberOfStudent()
    {
        int studentCount = 0;
        MongoCursor<Document> doc = collectionUser.find().iterator();

        while(doc.hasNext()){
            //System.out.println(doc.next().values()); // taking full data
            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if(property1.get(6).equals( "student"))
            {
                studentCount = studentCount + 1;

            }
        }
        return studentCount;
    }

    public boolean insertReviewQuestion(String question, String questionType, ArrayList<String> questionChoices, int questionMaxRate)
    {
        // Uploading datas to mongodb
        try {
                MongoCursor<Document> doc = collectionUser.find().iterator();
                Document d1 = new Document();
                d1.append("question", question);
                d1.append("questionType", questionType);
                d1.append("questionChoices", questionChoices);
                d1.append("questionMaxRate", questionMaxRate);

                collectionReviewQuestions.insertOne(d1);
                System.out.println("ekleme tamam");
                return true;

        } catch (Exception e) {
            System.out.println("insert review question hatalı");
            // System.out.println(e);
            return false;
        }

    }

    public boolean insertPeerReview(int senderId, int receiverId, String reviewType, ArrayList<String> answer)
    {
        // Uploading datas to mongodb
        try {
            MongoCursor<Document> doc = collectionPeerFeedbacks.find().iterator();
            Document d1 = new Document();
            d1.append("senderStudentId", senderId);
            d1.append("receiverStudentId", receiverId);
            d1.append("review-type", reviewType);
            d1.append("reviewAnswers", answer);


            collectionPeerFeedbacks.insertOne(d1);
            System.out.println("ekleme tamam");
            return true;

        } catch (Exception e) {
            System.out.println("insert peer feedback hatalı");
            // System.out.println(e);
            return false;
        }
    }

    public boolean insertArtifactReviewByComment(String groupName,int senderId, String comment,String artifactName)
    {
        // Uploading datas to mongodb
        try {
            MongoCursor<Document> doc = collectionArtifactReviews.find().iterator();
            Document d1 = new Document();
            d1.append("group-name", groupName);
            d1.append("senderId", senderId);
            d1.append("comment", comment);
            d1.append("artifact-name",artifactName);


            collectionArtifactReviews.insertOne(d1);
            System.out.println("ekleme tamam");
            return true;

        } catch (Exception e) {
            System.out.println("insert artifact review by comment hatalı");
            // System.out.println(e);
            return false;
        }
    }

    /*
    public ArrayList<Question> getReviewQuestions()
    {
        try{
            ArrayList<Question> peerFeedbackQuestions = new ArrayList<Question>();
            MongoCursor<Document> doc = collectionReviewQuestions.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> property= new ArrayList(doc.next().values());
                Question q = new Question();
                q.setQuestion(property.get(1).toString());
                q.setQuestionType(property.get(2).toString());
                q.setChoices((ArrayList<String>) property.get(3));
                q.setOutOfGrade((int)property.get(4));
                peerFeedbackQuestions.add(q);
            }

            return peerFeedbackQuestions;

        }catch(Exception e)
        {
            System.out.println("get question hatalı");
        }

        return null;
    }
*/

    void printDatas() {

        try {
            MongoCursor<Document> doc = collectionUser.find().iterator();
            while (doc.hasNext()) {
                System.out.println(doc.next().values()); // taking full data

            }
        } catch (Exception e) {
            System.out.println("print data hatalı");
           // System.out.println(e);
        }


    }


    /*
    public ArrayList<PeerReview> getUserPeerReviews(int id)
    {
        try{
            ArrayList<PeerReview> peerReviews = new ArrayList<PeerReview>();
            MongoCursor<Document> doc = collectionPeerFeedbacks.find().iterator();

            while(doc.hasNext()) {
                ArrayList<Object> property = new ArrayList(doc.next().values());

                if (property.get(2).equals(id)) {
                    PeerReview pr = new PeerReview();
                    pr.setAnswers((ArrayList<String>) property.get(4));
                    pr.setPeerFeedbackType((String) property.get(3));
                    pr.setReceiverId(id);
                    pr.setGiverId((int) property.get(1));
                    peerReviews.add(pr);
                }
            }

            return peerReviews;
        }catch(Exception e)
        {
            System.out.println("get user peer reviews hatalı");
        }
        return null;

    }
    */


    public String findGroupNameOfUser(int id)
    {
        try{
            MongoCursor<Document> doc = collectionGroups.find().iterator();

            while(doc.hasNext()) {
                ArrayList<Object> property = new ArrayList(doc.next().values());
                ArrayList<Integer> groupMemberIds = new ArrayList<Integer>();
                groupMemberIds = (ArrayList<Integer>) property.get(2);
                for (int i = 0; i < groupMemberIds.size(); i++)
                {
                    if (groupMemberIds.get(i) == id )
                    {
                        return (String)property.get(1);
                    }
                }
            }

            return "no-group";
        }catch(Exception e)
        {
            System.out.println("get user peer reviews hatalı");
        }
        return "no-group";
    }

    public ArrayList<String> getUserDetails(int id)
    {
        try{
            ArrayList<String> details = new ArrayList<String>();
            Document doc = collectionUser.find( new Document("id", id)).first();
            details.add(doc.getString("username"));
            details.add(doc.getString("name"));
            details.add(doc.getString("surname"));
            details.add(doc.getString("email"));
            details.add(doc.getString("roll"));
            if(details != null)
            {
                return details;
            }
            else
            {

                return null;
            }

        }catch(Exception e)
        {
            System.out.println("get user details hatalı");
        }
        return null;
    }

    public String secretPassword(String password)
    {
        String secretPassword;
        int hashCode = password.hashCode();
        secretPassword = String.valueOf(hashCode);
        return secretPassword;
    }



    public ArrayList<Integer> getAllStudentsId()
    {
        ArrayList<Integer> allStudentsId = new ArrayList<Integer>();

        MongoCursor<Document> doc = collectionUser.find().iterator();

        while(doc.hasNext()){
            //System.out.println(doc.next().values()); // taking full data
            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if(property1.get(1).equals( "student"))
            {
                allStudentsId.add((Integer)(property1.get(2)));

            }
        }

        return allStudentsId;
    }


    public boolean insertGroupByRandom(int groupNumber, ArrayList<Integer> memberIds) {

        // Uploading datas to mongodb
        try {
                Document d1 = new Document();
                String groupName = "Group-" + groupNumber;
                d1.append("groupName", groupName);
                d1.append("groupMembersId",memberIds);
                collectionGroups.insertOne(d1);
                System.out.println("ekleme tamam");
                return true;

        } catch (Exception e) {
            System.out.println("insert user hatalı");
            // System.out.println(e);
            return false;
        }

    }
    public boolean createEmptyGroup(String groupName)
    {

        boolean groupExist = false;
        MongoCursor<Document> doc = collectionGroups.find().iterator();

        while(doc.hasNext()){
            ArrayList<Object> property1 = new ArrayList(doc.next().values());
            if(property1.get(1).equals(groupName))
            {
                groupExist = true;

            }
        }

        if(groupExist == false)
        {
            ArrayList<Integer> members = new ArrayList<Integer>();
            Document d1 = new Document();
            d1.append("groupName",groupName);
            d1.append("groupMembersId", members);
            collectionGroups.insertOne(d1);
            return true;
        }
        return false;
    }

    public boolean insertGroupByMember(int id, String groupName)
    {
        boolean idExist = false;
        MongoCursor<Document> doc = collectionUser.find().iterator();
        while(doc.hasNext()){
            ArrayList<Object> property1 = new ArrayList(doc.next().values());
            if(property1.get(2).equals(id))
            {
                idExist = true;

            }
        }
        if(idExist == true) {

            try
            {
                BasicDBObject whereQuery = new BasicDBObject();
                whereQuery.put("groupName", groupName);

                MongoCursor<Document> cursor = collectionGroups.find(whereQuery).iterator();

                while (cursor.hasNext()) {
                    Document str = cursor.next();

                    List<Integer> list = (List<Integer>)str.get("groupMembersId");
                    boolean memberExist = false;

                    for(int i = 0; i < list.size(); i++)
                    {
                        if(list.get(i).equals(id))
                        {
                            memberExist = true;
                        }
                    }

                    if(memberExist == false)
                    {
                        list.add(id);
                        Document found = (Document) collectionGroups.find(new Document("groupName", groupName)).first();
                        Bson updateMember = new Document("groupMembersId", list);
                        Bson updateOperation = new Document("$set", updateMember);
                        collectionGroups.findOneAndUpdate(found,updateOperation);
                        System.out.println("ekleme tamam");
                        return true;
                    }
                    else
                    {
                        System.out.println("Kullanıcı zaten grupta var");
                        return false;
                    }

                }

            }catch (Exception e)
            {
                System.out.println("eklemede hata oluştu");
                return false;

            }
        }
        System.out.println("Eklenme olmadı kullanıcı bulunamadı");
        return false;
    }


    /* üstte bunun aynısı ama dursun burda lazım olur belki

    public boolean insertGroupByMember2(int id, String groupName)
    {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("groupName", groupName);

        MongoCursor<Document> cursor = collectionGroups.find(whereQuery).iterator();

        while (cursor.hasNext()) {
            Document str = cursor.next();

            List<Integer> list = (List<Integer>)str.get("groupMembersId");
            ArrayList<Integer> member = new ArrayList<Integer>();
            list.add(id);

            Document found = (Document) collectionGroups.find(new Document("groupName", groupName)).first();
            Bson updateMember = new Document("groupMembersId", list);
            Bson updateOperation = new Document("$set", updateMember);
            collectionGroups.findOneAndUpdate(found,updateOperation);

        }

        return true;
    }

*/


}
