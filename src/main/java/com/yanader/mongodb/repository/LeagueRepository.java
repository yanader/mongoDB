package com.yanader.mongodb.repository;

import com.yanader.mongodb.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, Integer> {
    League findByLeagueName(String leagueName);
}
