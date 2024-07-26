package com.yanader.mongodb.repository;

import org.bson.types.ObjectId;
import com.yanader.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
