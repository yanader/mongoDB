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
        return leagueRepository.save(league);
    }

    @Override
    public League deleteLeague(int id) {
        Optional<League> league = leagueRepository.findById(id);
        leagueRepository.deleteById(id);
        return league.orElse(null);
    }

    @Override
    public League updateLeague(int id, League league) {
        League leagueToUpdate = leagueRepository.findById(id).get();
        leagueToUpdate.setLeagueName(league.getLeagueName());
        leagueRepository.save(leagueToUpdate);
        return leagueToUpdate;
    }
}
