package com.kamilj.springjwtproject.dao;


import com.kamilj.springjwtproject.model.AuthenticationRequest;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class UserDAOImpl implements UserDAO {

    @Override
    public void getUser() {
        //from database
        // Creating a Mongo client
        MongoClient mongo = new MongoClient("localhost", 27017);

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("myDb");


        // Retieving a collection
        MongoCollection<Document> collection = database.getCollection("myCollection");

        //save in user class

        Document myDoc = collection.find().first();
        AuthenticationRequest request = new AuthenticationRequest();

    }
}
