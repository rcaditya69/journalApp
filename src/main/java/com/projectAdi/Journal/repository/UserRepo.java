package com.projectAdi.Journal.repository;

import com.projectAdi.Journal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);

    void deleteByUserName(String name);
}
