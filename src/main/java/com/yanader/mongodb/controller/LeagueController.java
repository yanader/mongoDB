package com.yanader.mongodb.controller;

import com.yanader.mongodb.model.League;
import com.yanader.mongodb.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photoleague/leagues")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @GetMapping
    public List<League> getLeagues() {
        return leagueService.getLeagues();
    }

    @PostMapping
    public League addLeague(@RequestBody League league) {
        return leagueService.addLeague(league);
    }

    @PutMapping("/{id}")
    public League updateLeague(@PathVariable int id, @RequestBody League league) {
        return leagueService.updateLeague(id, league);
    }

    @DeleteMapping("/{id}")
    public League deleteLeague(@PathVariable int id) {
        return leagueService.deleteLeague(id);
    }

    @GetMapping("/{name}")
    public League getLeagueByName(@PathVariable String name) {
        return leagueService.getLeagueByName(name);
    }

}
