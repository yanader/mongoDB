package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;
import com.yanader.mongodb.model.User;

import java.util.List;

public interface LeagueService {
    public League getLeagueByName(String leagueName);
    public List<League> getLeagues();
    public League addLeague(League league);
    public League deleteLeague(int id);
    public League updateLeague(int id, User user);
}
