package com.yanader.mongodb.service;

import com.yanader.mongodb.model.League;
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
    public League addLeague(League league) {
        if(!validLeague(league)) return null;
        return leagueRepository.save(league);
    }

    @Override
    public League deleteLeague(int id) {
        Optional<League> league = leagueRepository.findById(id);
        if(league.isPresent()) {
            leagueRepository.deleteById(id);
            return league.get();
        } else {
            return null;
        }
    }

    @Override
    public League updateLeague(int id, League updates) {
        Optional<League> optionalLeague = leagueRepository.findById(id);
        if(optionalLeague.isEmpty()) {
            return null;
        }
        League leagueToUpdate = optionalLeague.get();
        applyLeagueUpdates(leagueToUpdate, updates);
        leagueRepository.save(leagueToUpdate);
        return leagueToUpdate;
    }

    private boolean validLeague(League league) {
        return league.getLeagueName() != null;
    }

    private void applyLeagueUpdates(League leagueToUpdate, League updates) {

    }
}
