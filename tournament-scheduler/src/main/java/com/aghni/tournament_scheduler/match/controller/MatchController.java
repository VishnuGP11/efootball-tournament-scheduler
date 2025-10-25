package com.aghni.tournament_scheduler.match.controller;

import com.aghni.tournament_scheduler.match.service.MatchService;
import com.aghni.tournament_scheduler.match.model.Matchup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
@CrossOrigin(origins = "http://localhost:3000")
public class MatchController {

    Logger logger = LoggerFactory.getLogger(MatchController.class);

    @Autowired
    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/match-details/{matchId}")
    public ResponseEntity<Matchup> getMatchDetails(@PathVariable("matchId") Integer matchId) {
        Matchup matchUp = matchService.getMatchDetails(matchId);
        logger.info("Match found with match id " + matchUp.getMatchId());
        return new ResponseEntity<>(matchUp, HttpStatus.OK);
    }
}
