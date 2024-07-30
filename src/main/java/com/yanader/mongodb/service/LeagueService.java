package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;

import java.util.List;

public interface LeagueService {
    League getLeagueByName(String leagueName);
    List<League> getLeagues();
    League addLeague(League league);
    League deleteLeague(String id);
    League updateLeague(String id, League league);
}
