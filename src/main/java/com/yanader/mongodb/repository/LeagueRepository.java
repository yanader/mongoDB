package com.yanader.mongodb.repository;

import com.yanader.mongodb.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, String> {
    League findByLeagueName(String leagueName);
}
