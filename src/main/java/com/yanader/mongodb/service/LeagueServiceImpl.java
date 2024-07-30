package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;
import com.yanader.mongodb.model.User;
import com.yanader.mongodb.model.dto.NewLeagueDTO;
import com.yanader.mongodb.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueServiceImpl implements LeagueService{

    @Autowired
    private LeagueRepository leagueRepository;


    @Override
    public League getLeagueByName(String leagueName) {
        return leagueRepository.findByLeagueName(leagueName);
    }

    @Override
    public List<League> getLeagues() {
        return leagueRepository.findAll();
    }

    @Override
    public League addLeague(NewLeagueDTO newLeague) {
        if(!validLeague(newLeague)) return null;
        return leagueRepository.save(new League(newLeague.getLeagueName(), newLeague.getOwnerId()));
    }

    @Override
    public League deleteLeague(String id) {
        Optional<League> league = leagueRepository.findById(id);
        if(league.isPresent()) {
            leagueRepository.deleteById(id);
            return league.get();
        } else {
            return null;
        }
    }

    @Override
    public League updateLeague(String id, League updates) {
        Optional<League> optionalLeague = leagueRepository.findById(id);
        if(optionalLeague.isEmpty()) {
            return null;
        }
        League leagueToUpdate = optionalLeague.get();
        applyLeagueUpdates(leagueToUpdate, updates);
        leagueRepository.save(leagueToUpdate);
        return leagueToUpdate;
    }

    private boolean validLeague(NewLeagueDTO newLeague) {
        if (newLeague.getLeagueName() == null) return false;
        if (newLeague.getOwnerId() == null) return false;
        return true;
    }

    private void applyLeagueUpdates(League leagueToUpdate, League updates) {
        // Did i never write this? It just needs a line to change the league name
        // Might go and exist in "leagueAdmin"
    }
}
