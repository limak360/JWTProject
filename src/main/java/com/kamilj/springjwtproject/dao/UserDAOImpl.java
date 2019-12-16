package com.kamilj.springjwtproject.dao;


import com.kamilj.springjwtproject.model.AuthenticationRequest;
import com.kamilj.springjwtproject.model.User;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl
        implements UserDAO {

    @Override
    public User getUser() {
        //from database
        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase database = mongo.getDatabase("myDb");

        MongoCollection mongoCollection = database.getCollection("User");

       return new User("Kamil","admin"); //(User) mongoCollection.find().first();
    }
}
