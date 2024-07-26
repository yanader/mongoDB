package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;

public interface LeagueService {
    public League getLeagueByName(String leagueName);
}
