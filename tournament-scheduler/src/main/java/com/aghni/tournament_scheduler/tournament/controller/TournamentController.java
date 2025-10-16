package com.aghni.tournament_scheduler.tournament.controller;

import com.aghni.tournament_scheduler.tournament.model.AddTournamentRequest;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentResponse;
import com.aghni.tournament_scheduler.tournament.model.TournamentDetailsResponse;
import com.aghni.tournament_scheduler.tournament.service.TournamentService;
import com.aghni.tournament_scheduler.tournament.service.TournamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin(origins = "http://localhost:3000")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    Logger logger = Logger.getLogger(TournamentServiceImpl.class.getName());

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping("/createTournament")
    public ResponseEntity<AddTournamentResponse> createTournament(@RequestBody AddTournamentRequest addTournamentRequest)  {
        AddTournamentResponse response =  tournamentService.createTournament(addTournamentRequest);

        if("success".equals(response.getStatus())){
            Integer tournamentId = response.getTournamentId();
            URI redirectUri = URI.create("/tournaments/" + tournamentId + "/details");
            return ResponseEntity.status(HttpStatus.SEE_OTHER).location(redirectUri).build();
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/{tournamentId}/details")
    public ResponseEntity<TournamentDetailsResponse> getTournamentDetails(@PathVariable("tournamentId") Integer tournamentId) {
        if(tournamentId != null){
            TournamentDetailsResponse response = tournamentService.getTournamentDetails(tournamentId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            logger.severe("tournamentId is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    }


