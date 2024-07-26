package com.yanader.mongodb.repository;

import org.bson.types.ObjectId;
import com.yanader.mongodb.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, ObjectId> {
}
