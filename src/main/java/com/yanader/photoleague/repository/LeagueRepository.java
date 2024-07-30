package com.yanader.photoleague.repository;

import com.yanader.photoleague.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, String> {
    League findByLeagueName(String leagueName);
}
