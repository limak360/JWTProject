package com.kamilj.springjwtproject.dao;

import com.kamilj.springjwtproject.model.User;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

        Object profile = mongoCollection
                .find()
                .first();

        return new User(profile.toString().substring(49,54),profile.toString().substring(65,70));
    }
}
