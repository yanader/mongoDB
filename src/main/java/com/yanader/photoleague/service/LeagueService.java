package com.yanader.photoleague.service;

import com.yanader.photoleague.model.League;
import com.yanader.photoleague.model.dto.NewLeagueDTO;

import java.util.List;

public interface LeagueService {
    League getLeagueByName(String leagueName);
    List<League> getLeagues();
    League addLeague(NewLeagueDTO newLeague);
    League deleteLeague(String id);
    League updateLeague(String id, League league);
}
