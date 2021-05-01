package com.project.cs319.DataBase;
import com.project.cs319.Entity.*;
import com.mongodb.BasicDBObject;
import com.project.cs319.Controller.*;
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
import java.sql.SQLOutput;
import java.util.*;
import java.io.File;
import java.io.IOException;


public class mongoDB {
    public static MongoClient mongoClient;
    public static MongoDatabase database;
    public static MongoCollection<Document> collectionUser;
    public static MongoCollection<Document> collectionSection;
    public static MongoCollection<Document> collectionGroups;
    public static MongoCollection<Document> collectionPeerReviewQuestions;
    public static MongoCollection<Document> collectionPeerReviewAnswer;
    public static MongoCollection<Document> collectionArtifactReviews;
    public static MongoCollection<Document> collectionCourseReviewQuestion;
    public static MongoCollection<Document> collectionCourseReviewAnswer;
    public static MongoCollection<Document> collectionProcess;
    public static MongoCollection<Document> collectionProjectRates;
    public static MongoCollection<Document> collectionCurrentSystemInfo;

    public static Hashtable userPasswords;


    public mongoDB() {
        try {
            mongoClient = MongoClients.create(
                    "mongodb+srv://berke:C-sSv!ABPHeUQ3p@peerreview.pixjl.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
            database = mongoClient.getDatabase("cs319");
            collectionUser = database.getCollection("user");
            collectionSection = database.getCollection("section");
            collectionGroups = database.getCollection("groups");
            collectionPeerReviewQuestions = database.getCollection("peerReviewQuestion");
            collectionPeerReviewAnswer = database.getCollection("peerReviewAnswer");
            collectionArtifactReviews = database.getCollection("artifactReviews");
            collectionCourseReviewQuestion = database.getCollection("courseReviewQuestion");
            collectionCourseReviewAnswer = database.getCollection("courseReviewAnswer");
            collectionProcess = database.getCollection("process");
            collectionProjectRates = database.getCollection("projectRates");
            collectionCurrentSystemInfo = database.getCollection("currentSystemInfo");
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
    //---------------------------------------------------------------------------------------------------
    // CurrentSystemInfoController
    //---------------------------------------------------------------------------------------------------
    public String getCurrentCourseName(String id)
    {
        try {
            Document doc = collectionCurrentSystemInfo.find(new Document("id", id)).first();

            if (doc != null) {
                return doc.getString("course");
            } else {
                return " ";
            }

        } catch (Exception e) {
            System.out.println("getCurrentCourseName hatalı");
        }
        return " ";
    }

    public String getCurrentSemester(String id)
    {
        try {
            Document doc = collectionCurrentSystemInfo.find(new Document("id", id)).first();

            if (doc != null) {
                return doc.getString("semester");
            } else {
                return " ";
            }

        } catch (Exception e) {
            System.out.println("getCurrentSemester hatalı");
        }
        return " ";
    }

    public void changeCurrentCourseName(String courseName)
    {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", "currentSystemInfo");

            MongoCursor<Document> cursor = collectionCurrentSystemInfo.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionCurrentSystemInfo.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> processes = new ArrayList(doc.next().values());

                if ((processes.get(1).equals("currentSystemInfo")))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionCurrentSystemInfo.find(new Document("id", "currentSystemInfo")).first();

                    Bson updateMember = new Document("course", courseName);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionCurrentSystemInfo.findOneAndUpdate(found, updateOperation);
                    System.out.println("changeCurrentCourseName ekleme tamam");
                }
            }
        } catch (Exception e) {
            System.out.println("changeCurrentCourseName olmadı");
        }
    }
    public void changeCurrentSemester(String semester)
    {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", "currentSystemInfo");

            MongoCursor<Document> cursor = collectionCurrentSystemInfo.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionCurrentSystemInfo.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> processes = new ArrayList(doc.next().values());

                if ((processes.get(1).equals("currentSystemInfo")))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionCurrentSystemInfo.find(new Document("id", "currentSystemInfo")).first();

                    Bson updateMember = new Document("semester", semester);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionCurrentSystemInfo.findOneAndUpdate(found, updateOperation);
                    System.out.println("changeCurrentSemester ekleme tamam");
                }
            }
        } catch (Exception e) {
            System.out.println("changeCurrentSemester olmadı");
        }
    }

    //---------------------------------------------------------------------------------------------------
    // ProjectRatingController
    //---------------------------------------------------------------------------------------------------
    public void giveRateToProject(String groupName, int rate)
    {
        if (getGroup(groupName) == null) {
            System.out.println("giveRateToProject ekleme olmadı");
        }
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("groupName", groupName);

            MongoCursor<Document> cursor = collectionProjectRates.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionProjectRates.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> groups = new ArrayList(doc.next().values());

                if ((groups.get(1).equals(groupName)))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionProjectRates.find(new Document("groupName", groupName)).first();

                    int projectRate = (int)found.get((String)"rate") + rate;
                    int projectRaterCount = (int)found.get((String)"raterCount") + 1;
                    System.out.println(projectRate);
                    System.out.print(projectRaterCount);
                    Bson updateMember = new Document("rate", projectRate);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionProjectRates.findOneAndUpdate(found, updateOperation);
                    found = (Document) collectionProjectRates.find(new Document("groupName", groupName)).first();
                    Bson updateMember2 = new Document("raterCount", projectRaterCount);
                    Bson updateOperation2 = new Document("$set", updateMember2);
                    collectionProjectRates.findOneAndUpdate(found, updateOperation2);
                    System.out.println("giveRateToProject ekleme tamam");
                }
            }
        } catch (Exception e) {
            System.out.println("giveRateToProject olmadı");
        }
    }

    public double getRateOfProject(String groupName)
    {
        try {
            Document doc = collectionProjectRates.find(new Document("groupName", groupName)).first();

            if (doc != null) {
                int rate = doc.getInteger("rate");
                int raterCount = doc.getInteger("raterCount");
                return rate/raterCount;
            } else {
                return -1;
            }

        } catch (Exception e) {
            System.out.println("getRateOfProject hatalı");
        }
        return -1;
    }
    //---------------------------------------------------------------------------------------------------
    // ProcessController
    //---------------------------------------------------------------------------------------------------
    public void changeGroupFormation(String status)
    {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", "process");

            MongoCursor<Document> cursor = collectionProcess.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionProcess.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> processes = new ArrayList(doc.next().values());

                if ((processes.get(1).equals("process")))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionProcess.find(new Document("id", "process")).first();

                    Bson updateMember = new Document("groupFormation", status);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionProcess.findOneAndUpdate(found, updateOperation);
                    System.out.println("changeGroupFormation ekleme tamam");
                }
            }
        } catch (Exception e) {
            System.out.println("changeGroupFormation olmadı");
        }
    }
    public void changePeerReview(String status)
    {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", "process");

            MongoCursor<Document> cursor = collectionProcess.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionProcess.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> processes = new ArrayList(doc.next().values());

                if ((processes.get(1).equals("process")))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionProcess.find(new Document("id", "process")).first();

                    Bson updateMember = new Document("peerReview", status);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionProcess.findOneAndUpdate(found, updateOperation);
                    System.out.println("changePeerReview ekleme tamam");
                }
            }
        } catch (Exception e) {
            System.out.println("changePeerReview olmadı");
        }
    }

    public void changeCourseReview(String status)
    {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", "process");

            MongoCursor<Document> cursor = collectionProcess.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionProcess.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> processes = new ArrayList(doc.next().values());

                if ((processes.get(1).equals("process")))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionProcess.find(new Document("id", "process")).first();

                    Bson updateMember = new Document("courseReview", status);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionProcess.findOneAndUpdate(found, updateOperation);
                    System.out.println("changePeerReview ekleme tamam");
                }
            }
        } catch (Exception e) {
            System.out.println("changePeerReview olmadı");
        }
    }

    public void changeProjectRating(String status)
    {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", "process");

            MongoCursor<Document> cursor = collectionProcess.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionProcess.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> processes = new ArrayList(doc.next().values());

                if ((processes.get(1).equals("process")))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionProcess.find(new Document("id", "process")).first();

                    Bson updateMember = new Document("projectRating", status);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionProcess.findOneAndUpdate(found, updateOperation);
                    System.out.println(" changeProjectRating ekleme tamam");
                }
            }
        } catch (Exception e) {
            System.out.println("changeProjectRating olmadı");
        }
    }
    public String getGroupFormationStatus(String id)
    {
        try {
            Document doc = collectionProcess.find(new Document("id", id)).first();

            if (doc != null) {
                return doc.getString("groupFormation");
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("getGroupFormationStatus hatalı");
        }
        return null;
    }

    public String isPeerReviewOnOrOff(String id)
    {
        try {
            Document doc = collectionProcess.find(new Document("id", id)).first();

            if (doc != null) {
                return doc.getString("peerReview");
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("isPeerReviewOnOrOff hatalı");
        }
        return null;
    }

    public String isCourseReviewOnOrOff(String id)
    {
        try {
            Document doc = collectionProcess.find(new Document("id", id)).first();

            if (doc != null) {
                return doc.getString("peerReview");
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("isPeerReviewOnOrOff hatalı");
        }
        return null;
    }

    public String isProjectRatingOnOrOff(String id)
    {
        try {
            Document doc = collectionProcess.find(new Document("id", id)).first();

            if (doc != null) {
                return doc.getString("projectRating");
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("isProjectRatingOnOrOff hatalı");
        }
        return null;
    }

    //---------------------------------------------------------------------------------------------------
    // UserController
    //---------------------------------------------------------------------------------------------------
    public void assignRoleToUser(int schoolID, String userRole)
    {
        if (getUser(schoolID) == null) {
            System.out.println("assignRoleToUser ekleme olmadı");
        }
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", schoolID);

            MongoCursor<Document> cursor = collectionUser.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionUser.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> users = new ArrayList(doc.next().values());

                if ((users.get(5).equals(schoolID)))
                {
                    Document str = cursor.next();
                    Document found = (Document) collectionUser.find(new Document("id", schoolID)).first();

                    Bson updateMember = new Document("userRole", userRole);
                    Bson updateOperation = new Document("$set", updateMember);
                    collectionUser.findOneAndUpdate(found, updateOperation);
                    System.out.println("assignRoleToUser ekleme tamam");
                    return;
                }


            }
        } catch (Exception e) {
            System.out.println("assignRoleToUser olmadı");
        }
        System.out.println("assignRoleToUser olmadı");
    }


    //---------------------------------------------------------------------------------------------------
    // signUpController
    //---------------------------------------------------------------------------------------------------

    public boolean insertUser(User user) {
        // Uploading data to mongodb
        try {
            if (getUser(user.getSchoolId()) == null) {
                MongoCursor<Document> doc = collectionUser.find().iterator();
                Document d1 = new Document();
                d1.append("name", user.getName());
                d1.append("surname", user.getSurname());
                d1.append("email", user.getEmail());
                d1.append("password", user.getPassword());
                d1.append("id", user.getSchoolId());
                d1.append("userRole", user.getUserRole());

                System.out.println("ekleme tamam");
                collectionUser.insertOne(d1);
                return true;
            } else {
                System.out.println("ekleme olmadıı");
                return false;
            }

        } catch (Exception e) {
            System.out.println("insert user hatalı");
            // System.out.println(e);
            return false;
        }
    }

    public String secretPassword(String password) {
        String secretPassword;
        int hashCode = password.hashCode();
        secretPassword = String.valueOf(hashCode);
        return secretPassword;
    }

    public User getUser(int id) {
        try {
            Document doc = collectionUser.find(new Document("id", id)).first();

            if (doc != null) {
                return new User(doc.getString("name"),
                        doc.getString("surname"),
                        doc.getString("email"),
                        doc.getString("password"),
                        doc.getInteger("id"),
                        doc.getString("userRole"));
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("get user hatalı");
        }
        return null;
    }

    //---------------------------------------------------------------------------------------------------
    // SectionController
    //---------------------------------------------------------------------------------------------------
    public int getSectionOfStudent(int schoolID) {
        ArrayList<Integer> allSections = getAllSectionNames();

        for (int i = 0; i < allSections.size(); i++) {
            int sectionNumber = allSections.get(i);
            ArrayList<Integer> sectionIDs = getAllStudentsIdFromSection(sectionNumber);

            for (int a = 0; a < sectionIDs.size(); a++) {
                if (sectionIDs.get(a).equals(schoolID)) {
                    return sectionNumber;
                }
            }
        }

        return -1;
    }

    public ArrayList<Integer> getAllSectionsOfInstructor(int instructorID) {
        ArrayList<Integer> sections = new ArrayList<Integer>();

        MongoCursor<Document> doc = collectionSection.find().iterator();
        while (doc.hasNext()) {

            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(3).equals(instructorID)) {
                System.out.println(property1.get(1));
                sections.add((int) property1.get(1));
            }
        }
        if (sections.size() != 0) {
            return sections;
        }
        return null;
    }

    public boolean createSection(int sectionNumber, int instructorID) {

        Document doc = collectionSection.find(new Document("sectionNumber", sectionNumber)).first();
        if (doc != null) {
            return false;
        }
        MongoCursor<Document> doc1 = collectionSection.find().iterator();
        Document d1 = new Document();
        d1.append("sectionNumber", sectionNumber);
        d1.append("groupIds", new ArrayList<String>());
        d1.append("instructor", instructorID);
        d1.append("TAlist", new ArrayList<Integer>());
        d1.append("students", new ArrayList<Integer>());
        collectionSection.insertOne(d1);
        System.out.println("ekleme tamam");
        return true;
    }

    public boolean insertUserToSection(int schoolID, int sectionNumber) {

        User u = getUser(schoolID);
        String userRole = u.getUserRole();
        if (u == null ) {
            System.out.println("insertUserToSection ekleme olmadı");
            return false;
        }
        if (!userRole.equals("user")) {
            System.out.println("insertUserToSection ekleme olmadi. Orgenci ya user, ya instr, ya da TA");
            return false;
        }
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("sectionNumber", sectionNumber);

            MongoCursor<Document> cursor = collectionSection.find(whereQuery).iterator();

            MongoCursor<Document> doc = collectionSection.find().iterator();
            while (doc.hasNext()) {
                ArrayList<Object> sections = new ArrayList(doc.next().values());

                if ((int) (sections.get(1)) == sectionNumber) {
                    Document str = cursor.next();
                    List<Integer> list;
                    if (userRole.equals("TA")) {
                        list = (List<Integer>) str.get("TAlist");
                    } else {
                        list = (List<Integer>) str.get("students");
                    }

                    if (list.contains(schoolID)) {
                        // user already exist
                        System.out.println(" ekleme olmadı");
                        return false;
                    }
                    list.add(schoolID);
                    Document found = (Document) collectionSection.find(new Document("sectionNumber", sectionNumber)).first();
                    if (userRole.equals("TA")) {
                        Bson updateMember = new Document("TAlist", list);
                        Bson updateOperation = new Document("$set", updateMember);
                        collectionSection.findOneAndUpdate(found, updateOperation);
                        System.out.println("TA ekleme tamam");
                        return true;
                    } else if (userRole.equals("user")) {
                        Bson updateMember = new Document("students", list);
                        Bson updateOperation = new Document("$set", updateMember);
                        collectionSection.findOneAndUpdate(found, updateOperation);
                        System.out.println("Student ekleme tamam");
                        assignRoleToUser(schoolID, "student");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
        System.out.println("Array ekleme yapılamadı");
        return false;
    }

    public ArrayList<String> getGroupsOfSection(int sectionNumber)
    {
        MongoCursor<Document> doc = collectionSection.find().iterator();

        while (doc.hasNext()) {
            //System.out.println(doc.next().values()); // taking full data
            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(1).equals(sectionNumber)) {
                return ((ArrayList<String>) (property1.get(2)));
            }
        }

        return null;
    }

    public ArrayList<Integer> getAllSectionNames()
    {
        ArrayList<Integer> allSections = new ArrayList<Integer>();

        MongoCursor<Document> doc = collectionSection.find().iterator();
        while (doc.hasNext()) {

            ArrayList<Object> property1 = new ArrayList(doc.next().values());
            allSections.add((int)property1.get(1));
        }
        if(allSections.size() != 0)
        {
            return allSections;
        }
        return null;
    }


    //---------------------------------------------------------------------------------------------------
    // GroupFormationController
    //---------------------------------------------------------------------------------------------------

    public int getNumberOfStudentsFromSection(int sectionID) {
        MongoCursor<Document> doc = collectionSection.find().iterator();

        while (doc.hasNext()) {
            //System.out.println(doc.next().values()); // taking full data
            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(1).equals(sectionID)) {
                return ((ArrayList<Integer>) (property1.get(5))).size();
            }
        }
        return 0;
    }

    public ArrayList<Integer> getAllStudentsIdFromSection(int sectionID) {
        ArrayList<Integer> allStudentsId = new ArrayList<Integer>();

        MongoCursor<Document> doc = collectionSection.find().iterator();

        while (doc.hasNext()) {
            //System.out.println(doc.next().values()); // taking full data
            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(1).equals(sectionID)) {
                return ((ArrayList<Integer>) (property1.get(5)));
            }
        }

        return null;
    }

    public boolean insertStudentToGroup(String groupID, int studentID, int sectionID) {
        // User validation
        User user1 = getUser(studentID);
        if (user1 == null || !(user1.getUserRole().equals("student"))) {
            return false;
        }
        // Section validation
        Section sec1 = getSection(sectionID);
        if (sec1 == null) {
            return false;
        }
        // Group validation
        boolean groupExist = false;
        for (int i = 0; i < sec1.getGroupIds().size(); i++) {

            if (sec1.getGroupIds().get(i).equals(groupID)) {
                groupExist = true;
                break;
            }
        }
        if (!(groupExist)) {
            return false;
        }

        if (userHasGroup(studentID)) {
            return false;
        }

        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("groupName", groupID);
            MongoCursor<Document> cursor = collectionGroups.find(whereQuery).iterator();


            Document str = cursor.next();
            ArrayList<Integer> list = (ArrayList<Integer>) str.get("groupMembersId");
            list.add(studentID);
            Document found = (Document) collectionGroups.find(new Document("groupName", groupID)).first();
            Bson updateMember = new Document("groupMembersId", list);
            Bson updateOperation = new Document("$set", updateMember);
            collectionGroups.findOneAndUpdate(found, updateOperation);
            System.out.println("student ekleme tamam");

            BasicDBObject whereQuery1 = new BasicDBObject();
            whereQuery1.put("id", studentID);

            MongoCursor<Document> cursor1 = collectionUser.find(whereQuery1).iterator();

            MongoCursor<Document> doc1 = collectionUser.find().iterator();
            while (doc1.hasNext()) {
                ArrayList<Object> users = new ArrayList(doc1.next().values());

                if (users.get(5).equals(studentID)) {

                    Document found1 = (Document) collectionUser.find(new Document("id", studentID)).first();

                    Bson updateMember1 = new Document("groupName", groupID);
                    Bson updateOperation1 = new Document("$set", updateMember1);
                    collectionUser.findOneAndUpdate(found1, updateOperation1);
                    System.out.println("Student grupname eklendi");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("insert student to group hatalı");
            return false;
        }
        return false;
    }

    public boolean userHasGroup(int studentID) {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", studentID);

            MongoCursor<Document> cursor = collectionUser.find(whereQuery).iterator();

            while (cursor.hasNext()) {
                ArrayList<Object> user = new ArrayList(cursor.next().values());

                if (!(user.get(7).equals(""))) {
                    System.out.println("User has group");
                    return true;
                }

            }
        }catch(Exception e)
        {
            return false;
        }
        return false;
    }

    public boolean createGroup(String groupID)
    {
        Group group = getGroup(groupID);
        int sectionNumber = (groupID.charAt(groupID.length() - 2) - '0');
        if(group != null)
        {
            System.out.println("group already exist");
            return false;
        }
        try {
            MongoCursor<Document> doc = collectionGroups.find().iterator();
            Document d1 = new Document();
            d1.append("groupName",groupID);
            d1.append("groupMembersId", new ArrayList<Integer>());
            d1.append("peerReviews", new ArrayList<String>());
            collectionGroups.insertOne(d1);
            System.out.println(" Group ekleme tamam");

            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("sectionNumber", sectionNumber);

            MongoCursor<Document> cursor = collectionSection.find(whereQuery).iterator();
            Document str = cursor.next();
            List<String> list;

            list = (List<String>)str.get("groupIds");

            list.add(groupID);
            Document found = (Document) collectionSection.find(new Document("sectionNumber", sectionNumber)).first();

            Bson updateMember = new Document("groupIds", list);
            Bson updateOperation = new Document("$set", updateMember);
            collectionSection.findOneAndUpdate(found,updateOperation);
            System.out.println("Group IDs ekleme tamam");
            return true;
        } catch (Exception e) {
            System.out.println("insert group hatalı");
            return false;
        }

    }

    public Section getSection(int sectionID)
    {
        try{
            Document doc = collectionSection.find( new Document("sectionNumber", sectionID)).first();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("sectionNumber", sectionID);

            if(doc != null)
            {
                MongoCursor<Document> cursor = collectionSection.find(whereQuery).iterator();
                Document str = cursor.next();
                List<String>  list = (ArrayList<String>)str.get("groupIds");
                List<Integer> lis2 = (ArrayList<Integer>)str.get("TAlist");


                return new Section(doc.getInteger("sectionNumber"),
                        (ArrayList<String>)str.get("groupIds"),
                        doc.getInteger("instructor"),
                        (ArrayList<Integer>)str.get("TAlist"),
                        (ArrayList<Integer>)str.get("students"),
                        "");
            }
        }catch(Exception e)
        {
            System.out.println("get section hatalı");
        }
        return null;

    }

    public Group getGroup(String groupID)
    {
        try{
            Document doc = collectionGroups.find( new Document("groupName", groupID)).first();

            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("groupName", groupID);

            if(doc != null)
            {
                MongoCursor<Document> cursor = collectionGroups.find(whereQuery).iterator();
                Document str = cursor.next();
                return new Group((ArrayList<Integer>)str.get("groupMembersId"),
                        doc.getString("groupName"),
                        (ArrayList<String>)str.get("peerReviews"));
            }
            else
            {
                return null;
            }

        }catch(Exception e)
        {
            System.out.println("get group hatalı");
        }
        return null;
    }

    public boolean createGroupByUser(int sectionID, int studentID)
    {
        if(userHasGroup(studentID))
        {
            return false;
        }
        Group g = null;
        char ch;
        for( ch = 'a'; ch <= 'z'; ch++)
        {
            g = getGroup("CS319-" + sectionID + ch);
            if(g == null)
            {
                createGroup("CS319-" + sectionID + ch);
                insertStudentToGroup("CS319-" + sectionID + ch,studentID,sectionID);
                return true;
            }
        }
        return false;
    }

    public boolean removeUserFromGroup(int studentID) {
        // student group
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("id", studentID);

            MongoCursor<Document> cursor = collectionUser.find(whereQuery).iterator();
            String groupName = "";
            while (cursor.hasNext()) {
                ArrayList<Object> user = new ArrayList(cursor.next().values());
                groupName = user.get(7).toString();
                if(groupName.equals("")) {
                    System.out.println("group does not exits in use");
                    return false;
                }
            }

            // Delete groupID from User
            Document found = (Document) collectionUser.find(new Document("id", studentID)).first();
            Bson updateMember = new Document("groupName", "");
            Bson updateOperation = new Document("$set", updateMember);
            collectionUser.findOneAndUpdate(found, updateOperation);
            System.out.println("userdan grup silindi");

            // Delete user from Group
            try {
                whereQuery = new BasicDBObject();
                whereQuery.put("groupName", groupName);

                cursor = collectionGroups.find(whereQuery).iterator();

                MongoCursor<Document> doc = collectionGroups.find().iterator();
                while (doc.hasNext()) {
                    ArrayList<Object> groups = new ArrayList(doc.next().values());

                    if (groups.get(1).equals(groupName)) {
                        System.out.println("Evet");
                        Document str = cursor.next();
                        List<Integer> list = (List<Integer>) str.get("groupMembersId");

                        ArrayList<Integer> newList = new ArrayList<>();
                        for(int i=0; i<list.size(); i++) {
                            if(!list.get(i).equals(studentID)) {
                                newList.add(list.get(i));
                            }
                        }

                        found = (Document) collectionGroups.find(new Document("groupName", groupName)).first();
                        updateMember = new Document("groupMembersId", newList);
                        updateOperation = new Document("$set", updateMember);
                        collectionGroups.findOneAndUpdate(found, updateOperation);
                        System.out.println("ogrenci silindi.");
                        if(newList.size() == 0) {
                            removeGroup(groupName);
                        }
                        return true;
                    }
                }
            }catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        return false;
        // group collection student
    }

    public boolean removeGroup(String groupName) {
        try {
            collectionGroups.deleteOne(Filters.eq("groupName", groupName));

            int section = groupName.charAt( groupName.length()-2) - '0';
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("sectionNumber", section);
            MongoCursor<Document> cursor = collectionSection.find(whereQuery).iterator();

            Document str = cursor.next();
            ArrayList<String> list = (ArrayList<String>) str.get("groupIds");
            ArrayList<String> newList = new ArrayList<String>();
            for(int i=0; i<list.size(); i++) {
                if(!list.get(i).equals(groupName)) {
                    newList.add(list.get(i));
                }
            }
            Document found = (Document) collectionSection.find(new Document("sectionNumber", section)).first();
            Bson updateMember = new Document("groupIds", newList);
            Bson updateOperation = new Document("$set", updateMember);
            collectionSection.findOneAndUpdate(found, updateOperation);
            System.out.println("grup silme tmm sectiondan");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    //---------------------------------------------------------------------------------------------------
    // PeerReviewController
    //---------------------------------------------------------------------------------------------------


    public boolean insertOpenEndedQuestion(String question)
    {
        // Uploading data to mongodb
        try {

            MongoCursor<Document> doc = collectionPeerReviewQuestions.find().iterator();
            Document d1 = new Document();
            d1.append("questionType", "open-ended");
            d1.append("question", question);
            System.out.println("insertOpenEndedQuestion addition okey");
            collectionPeerReviewQuestions.insertOne(d1);
            return true;

        }catch (Exception e) {
            System.out.println("insertOpenEndedQuestion  hatalı");
            // System.out.println(e);
            return false;
        }
    }

    public boolean insertMultipleChoiceQuestion(String question, ArrayList<String> choices)
    {
        // Uploading data to mongodb
        try {
            MongoCursor<Document> doc = collectionPeerReviewQuestions.find().iterator();
            Document d1 = new Document();
            d1.append("questionType", "multiple-choice");
            d1.append("question", question);
            d1.append("choices",choices);
            System.out.println("insertMultipleChoiceQuestion addition okey");
            collectionPeerReviewQuestions.insertOne(d1);
            return true;

        }catch (Exception e) {
            System.out.println("insertMultipleChoiceQuestion  hatalı");
            // System.out.println(e);
            return false;
        }
    }

    public boolean insertPointQuestion(String question, int outOfGrade)
    {
        // Uploading data to mongodb
        try {
            MongoCursor<Document> doc = collectionPeerReviewQuestions.find().iterator();
            Document d1 = new Document();
            d1.append("questionType", "point");
            d1.append("question", question);
            d1.append("outOfGrade", outOfGrade);
            System.out.println("insertPointQuestion addition okey");
            collectionPeerReviewQuestions.insertOne(d1);
            return true;

        }catch (Exception e) {
            System.out.println("insertPointQuestion  hatalı");
            // System.out.println(e);
            return false;
        }
    }

    public ArrayList<Question> getPeerReviewQuestions() {
        ArrayList<Question> allQuestions = new ArrayList<Question>();

        MongoCursor<Document> doc = collectionPeerReviewQuestions.find().iterator();
        while (doc.hasNext()) {

            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(1).equals("open-ended")) {
                OpenEndedQuestion openEnded = new OpenEndedQuestion(((String) (property1.get(2))));
                allQuestions.add(openEnded);
            } else if (property1.get(1).equals("multiple-choice")) {
                MultipleChoiceQuestion multipleChoice = new MultipleChoiceQuestion((String) (property1.get(2)), (ArrayList<String>) property1.get(3));
                allQuestions.add(multipleChoice);
            } else if (property1.get(1).equals("point")) {
                PointQuestion point = new PointQuestion((String) (property1.get(2)), (int) (property1.get(3)));
                allQuestions.add(point);
            }
        }
        if(allQuestions.size() != 0)
        {
            return allQuestions;
        }
        return null;
    }

    public String getGroupNameFromStudent(int studentID)
    {
        Document doc = collectionUser.find(new Document("id", studentID)).first();
        if (doc != null) {
            return doc.getString("groupName");
        } else {
            return "";
        }
    }

    public boolean giveAnswerQuestions(int giverId,int receiverId, ArrayList<String> answer)
    {
        if(getGroupNameFromStudent(giverId).equals(""))
        {
            System.out.println("öğrencinin grubu yok");
            return false;
        }
        else if (!getGroupNameFromStudent(giverId).equals(getGroupNameFromStudent(receiverId)))
        {
            System.out.println("öğrenciler aynı grupta değil");
            return false;
        }
        try {
            MongoCursor<Document> doc = collectionPeerReviewAnswer.find().iterator();
            Document d1 = new Document();
            d1.append("groupName", getGroupNameFromStudent(giverId));
            d1.append("giver-id", giverId);
            d1.append("receiver-id", receiverId);
            d1.append("answers", answer);
            System.out.println("giveAnswerQuestions addition okey");
            collectionPeerReviewAnswer.insertOne(d1);
            return true;
        }catch (Exception e) {
            System.out.println("giveAnswerQuestions  hatalı");
            return false;
        }
    }

    public ArrayList<String> getPeerReviewAnswers(int giverID,int receiverID)
    {
        ArrayList<String> allPeerReviewAnswers = new ArrayList<String >();

        MongoCursor<Document> doc = collectionPeerReviewAnswer.find().iterator();
        while (doc.hasNext()) {

            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if(property1.get(2).equals(giverID) && property1.get(3).equals(receiverID))
            {
                allPeerReviewAnswers =(ArrayList<String>)(property1.get(4));
            }
        }
        if(allPeerReviewAnswers.size() != 0)
        {
            return allPeerReviewAnswers;
        }
        return null;
    }


    //---------------------------------------------------------------------------------------------------
    // ProfileController
    //---------------------------------------------------------------------------------------------------

    public Student getStudentInformation(int studentID)
    {
        User u = getUser(studentID);
        if(u == null)
        {
            return null;
        }
        return new Student( u.getName(), u.getSurname(), u.getEmail(), u.getPassword(),u.getSchoolId(),
                (getGroupNameFromStudent(studentID).charAt(getGroupNameFromStudent(studentID).length()-2))-'0', getGroupNameFromStudent(studentID));
    }

    public Instructor getInstructorInformation (int instructorID) {
        User u = getUser(instructorID);
        if (u == null) {
            return null;
        }
        ArrayList<Integer> instructorSections = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> TAs = new ArrayList<ArrayList<Integer>>();

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("instructor", instructorID);

        MongoCursor<Document> cursor = collectionSection.find(whereQuery).iterator();
        while (cursor.hasNext()) {
            ArrayList<Object> section = new ArrayList(cursor.next().values());
            instructorSections.add((Integer) section.get(1));
            TAs.add((ArrayList<Integer>)section.get(4));
        }
        return new Instructor(u.getName(), u.getSurname(), u.getEmail(), u.getPassword(), u.getSchoolId(),
                instructorSections, TAs);
    }

    public TA getTAInformation(int TAid)
    {
        User u = getUser(TAid);
        if (u == null) {
            return null;
        }
        ArrayList<Integer> TaSections = new ArrayList<Integer>();

        MongoCursor<Document> cursor = collectionSection.find().iterator();
        while (cursor.hasNext()) {
            ArrayList<Object> section = new ArrayList(cursor.next().values());
            for(int i = 0; i < ((ArrayList<Integer>)(section.get(4))).size(); i++)
            {
                if( ((ArrayList<Integer>)(section.get(4))).get(i).equals(TAid))
                {
                    TaSections.add((int) section.get(1));
                }
            }
        }
        return new TA(u.getName(), u.getSurname(), u.getEmail(),u.getPassword(),u.getSchoolId(),TaSections);
    }

    public  Hashtable<Integer,ArrayList<String >> getSpecificPeerReviewOfStudent(int receiverID)
    {
        Hashtable<Integer,ArrayList<String> > peerReviewsOfStudent = new Hashtable<>();

        MongoCursor<Document> doc = collectionPeerReviewAnswer.find().iterator();

        while (doc.hasNext()) {
            //System.out.println(doc.next().values()); // taking full data
            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(3).equals(receiverID)) {
                peerReviewsOfStudent.put((Integer) property1.get(2), (ArrayList<String>) property1.get(4));
            }
        }
        if(peerReviewsOfStudent.size() == 0)
        {
            return null;
        }

        return peerReviewsOfStudent;
    }

    //-------------------------------------------------------------------------------------
    // ArtifactReviewController
    //-------------------------------------------------------------------------------------

    public boolean giveArtifactReviewToGroup(String groupName, String artifactType, String answer, int giverID)
    {
        Group group = getGroup(groupName);
        for(int i = 0; i < group.getStudentIDs().size(); i++)
        {
            if(group.getStudentIDs().get(i).equals(giverID))
            {
                return false;
            }
        }

        try {
            MongoCursor<Document> doc = collectionArtifactReviews.find().iterator();
            Document d1 = new Document();
            d1.append("groupName", groupName);
            d1.append("giver-id", giverID);
            d1.append("artifact-type", artifactType);
            d1.append("answers", answer);
            System.out.println("giveArtifactReviewToGroup addition okey");
            collectionArtifactReviews.insertOne(d1);
            return true;
        }catch (Exception e) {
            System.out.println("giveArtifactReviewToGroup  hatalı");
            return false;
        }

    }

    public Hashtable<Integer,String> getArtifactReviewFromGroup(String groupName, String artifactType)
    {
        Hashtable<Integer,String> artifactReviews = new Hashtable<>();

        MongoCursor<Document> doc = collectionArtifactReviews.find().iterator();

        while (doc.hasNext()) {

            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(3).equals(artifactType) && property1.get(1).equals(groupName)) {
                artifactReviews.put((Integer) property1.get(2), (String) property1.get(4));
            }
        }
        if(artifactReviews.size() == 0)
        {
            return null;
        }

        System.out.println("getArtifactReviewFromGroup çalışıyor");
        return artifactReviews;
    }

    //---------------------------------------------------------------------------------------------------
    // CourseReviewController
    //---------------------------------------------------------------------------------------------------


    public boolean insertOpenEndedQuestionCourse(String question)
    {
        // Uploading data to mongodb
        try {
            MongoCursor<Document> doc = collectionCourseReviewQuestion.find().iterator();
            Document d1 = new Document();
            d1.append("questionType", "open-ended");
            d1.append("question", question);
            System.out.println("insertOpenEndedQuestionCourse addition okey");
            collectionCourseReviewQuestion.insertOne(d1);
            return true;

        }catch (Exception e) {
            System.out.println("insertOpenEndedQuestionCourse  hatalı");
            return false;
        }
    }

    public boolean insertMultipleChoiceQuestionCourse(String question, ArrayList<String> choices)
    {
        // Uploading data to mongodb
        try {
            MongoCursor<Document> doc = collectionCourseReviewQuestion.find().iterator();
            Document d1 = new Document();
            d1.append("questionType", "multiple-choice");
            d1.append("question", question);
            d1.append("choices",choices);
            System.out.println("insertMultipleChoiceQuestionCourse addition okey");
            collectionCourseReviewQuestion.insertOne(d1);
            return true;

        }catch (Exception e) {
            System.out.println("insertMultipleChoiceQuestionCourse  hatalı");
            // System.out.println(e);
            return false;
        }
    }

    public boolean insertPointQuestionCourse(String question, int outOfGrade)
    {
        // Uploading data to mongodb
        try {
            MongoCursor<Document> doc = collectionCourseReviewQuestion.find().iterator();
            Document d1 = new Document();
            d1.append("questionType", "point");
            d1.append("question", question);
            d1.append("outOfGrade", outOfGrade);
            System.out.println("insertPointQuestionCourse addition okey");
            collectionCourseReviewQuestion.insertOne(d1);
            return true;

        }catch (Exception e) {
            System.out.println("insertPointQuestionCourse  hatalı");
            // System.out.println(e);
            return false;
        }
    }

    public ArrayList<Question> getCourseReviewQuestions() {
        ArrayList<Question> allQuestions = new ArrayList<Question>();

        MongoCursor<Document> doc = collectionCourseReviewQuestion.find().iterator();
        while (doc.hasNext()) {

            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            if (property1.get(1).equals("open-ended")) {
                OpenEndedQuestion openEnded = new OpenEndedQuestion(((String) (property1.get(2))));
                allQuestions.add(openEnded);
            } else if (property1.get(1).equals("multiple-choice")) {
                MultipleChoiceQuestion multipleChoice = new MultipleChoiceQuestion((String) (property1.get(2)), (ArrayList<String>) property1.get(3));
                allQuestions.add(multipleChoice);
            } else if (property1.get(1).equals("point")) {
                PointQuestion point = new PointQuestion((String) (property1.get(2)), (int) (property1.get(3)));
                allQuestions.add(point);
            }
        }
        if(allQuestions.size() != 0)
        {
            return allQuestions;
        }
        return null;
    }

    public boolean giveAnswerQuestionsCourse(int giverId, ArrayList<String> answer)
    {
        try {
            MongoCursor<Document> doc = collectionCourseReviewAnswer.find().iterator();
            Document d1 = new Document();
            d1.append("giver-id", giverId);
            d1.append("answers", answer);
            System.out.println("giveAnswerQuestionsCourse addition okey");
            collectionCourseReviewAnswer.insertOne(d1);
            return true;
        }catch (Exception e) {
            System.out.println("giveAnswerQuestionsCourse  hatalı");
            return false;
        }
    }

    public ArrayList<ArrayList<String>> getCourseReviewAnswers()
    {
        ArrayList<ArrayList<String>> allCourseReviewAnswers = new ArrayList<ArrayList<String> >();

        MongoCursor<Document> doc = collectionCourseReviewAnswer.find().iterator();
        while (doc.hasNext()) {

            ArrayList<Object> property1 = new ArrayList(doc.next().values());

            allCourseReviewAnswers.add((ArrayList<String >)(property1.get(2)));
        }
        if(allCourseReviewAnswers.size() != 0)
        {
            return allCourseReviewAnswers;
        }
        return null;
    }
}
