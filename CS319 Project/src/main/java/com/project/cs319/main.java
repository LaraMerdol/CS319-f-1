package com.project.cs319;

import com.mongodb.client.*;
import org.bson.Document;

public class main {
    public static void main(String [] args)
    {
        try
        {
            MongoClient mongoClient;
            MongoDatabase database;

            mongoClient = MongoClients.create(
                    "mongodb+srv://berke:C-sSv!ABPHeUQ3p@peerreview.pixjl.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
            database = mongoClient.getDatabase("cs319");
            MongoCollection<Document> a = database.getCollection("peerReviewQuestion");
            MongoCursor<Document> doc = a.find().iterator();
            Document d1 = new Document();
            d1.append("name", "asdasfasfasfsafsaasf");
            a.insertOne(d1);

        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
