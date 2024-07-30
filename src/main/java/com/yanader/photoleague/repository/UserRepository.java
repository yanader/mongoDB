package com.yanader.photoleague.repository;

import com.yanader.photoleague.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
