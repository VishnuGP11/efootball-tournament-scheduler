package com.aghni.tournament_scheduler.team.controller;

import com.aghni.tournament_scheduler.team.model.TeamDetailsResponse;
import com.aghni.tournament_scheduler.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

    @Autowired
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team-details/{teamId}")
    public ResponseEntity<TeamDetailsResponse> getTeamDetails(@PathVariable int teamId) {
        TeamDetailsResponse teamDetailsResponse = teamService.getTeamDetails(teamId);

        return new ResponseEntity<>(teamDetailsResponse, HttpStatus.OK);
    }
}
