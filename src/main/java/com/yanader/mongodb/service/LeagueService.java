package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;

import java.util.List;

public interface LeagueService {
    League getLeagueByName(String leagueName);
    List<League> getLeagues();
    League addLeague(League league);
    League deleteLeague(int id);
    League updateLeague(int id, League league);
}
