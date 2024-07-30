package com.yanader.mongodb.controller;

import com.yanader.mongodb.model.League;
import com.yanader.mongodb.model.dto.NewLeagueDTO;
import com.yanader.mongodb.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photoleague/leagues")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @GetMapping
    public ResponseEntity<List<League>> getLeagues() {
        return new ResponseEntity<>(leagueService.getLeagues(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<League> addLeague(@RequestBody NewLeagueDTO newLeague) {
        League addedLeague = leagueService.addLeague(newLeague);
        if (addedLeague != null) {
            return new ResponseEntity<>(addedLeague, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "League creation failed");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<League> updateLeague(@PathVariable String id, @RequestBody League league) {
        League updatedLeague = leagueService.updateLeague(id, league);
        if (updatedLeague != null) {
            return new ResponseEntity<>(updatedLeague, HttpStatus.ACCEPTED);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "League update failed");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<League> deleteLeague(@PathVariable String id) {
        League deletedLeague = leagueService.deleteLeague(id);
        if (deletedLeague != null) {
            return new ResponseEntity<>(deletedLeague, HttpStatus.ACCEPTED);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "League deletion failed");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<League> getLeagueByName(@PathVariable String name) {
        League league = leagueService.getLeagueByName(name);
        if (league != null) {
            return new ResponseEntity<>(league, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "League not found");
        }
    }

}
