package com.aghni.tournament_scheduler.tournament.service;

import com.aghni.tournament_scheduler.team.entity.Team;
import com.aghni.tournament_scheduler.tournament.entity.Tournament;
import com.aghni.tournament_scheduler.tournament.exception.TournamentNotFoundException;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentRequest;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentResponse;
import com.aghni.tournament_scheduler.tournament.model.Matchup;
import com.aghni.tournament_scheduler.tournament.model.TournamentDetailsResponse;
import com.aghni.tournament_scheduler.tournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class TournamentServiceImpl implements TournamentService {

    Logger logger = Logger.getLogger(TournamentServiceImpl.class.getName());

    @Autowired
    private TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public AddTournamentResponse createTournament(AddTournamentRequest addTournamentRequest) {

        Tournament tournament = new Tournament();
        tournament.setTournamentName(addTournamentRequest.getTournamentName());
        tournament.setNumberOfTeams(addTournamentRequest.getNumberOfTeams());
        tournament.setTypeOfSchedule(addTournamentRequest.getTypeOfSchedule());

        List<Team> teams = new ArrayList<>();
        for(int i=1; i<=addTournamentRequest.getNumberOfTeams(); i++){
            Team team = new Team("Team"+i+" "+addTournamentRequest.getTournamentName());
            team.setTournament(tournament);
            teams.add(team);
        }
        tournament.setTeams(teams);


        Tournament savedTournament = tournamentRepository.save(tournament);
        logger.info("Saved Tournament of name : " + savedTournament.getTournamentName());
        AddTournamentResponse response = new AddTournamentResponse();
        if (savedTournament != null && savedTournament.getTournamentId() != null) {
            response.setTournamentId(savedTournament.getTournamentId());
            response.setDate(LocalDate.now());
            response.setMessage("Tournament created successfully");
            response.setStatus("success");
        } else {
            response.setDate(LocalDate.now());
            response.setMessage("Tournament creation failed");
            response.setStatus("failure");
        }

        return response;
    }

    public Integer returnTournamentIdUsingName(String tournamentName) {
        return tournamentRepository.findTournamentByTournamentName(tournamentName).getTournamentId();
    }

    @Override
    public TournamentDetailsResponse getTournamentDetails(Integer tournamentId) throws TournamentNotFoundException {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() ->new TournamentNotFoundException("Tournament not found for the mentioned id :"+tournamentId));
        List<Team> teams = tournament.getTeams();
        List<Matchup> matchups = new ArrayList<>();

        if ("round robin".equalsIgnoreCase(tournament.getTypeOfSchedule())) {
            for (int i = 0; i < teams.size(); i++) {
                for (int j = i + 1; j < teams.size(); j++) {
                    matchups.add(new Matchup(teams.get(i).getTeamName(), teams.get(j).getTeamName()));
                }
            }
        } else if ("elimination".equalsIgnoreCase(tournament.getTypeOfSchedule())) {
            for (int i = 0; i < teams.size(); i += 2) {
                if (i + 1 < teams.size()) {
                    matchups.add(new Matchup(teams.get(i).getTeamName(), teams.get(i + 1).getTeamName()));
                } else {
                    matchups.add(new Matchup(teams.get(i).getTeamName(), "BYE"));
                }
            }
        }

        TournamentDetailsResponse response = new TournamentDetailsResponse();
        response.setTournamentName(tournament.getTournamentName());
        response.setTournamentType(tournament.getTypeOfSchedule());
        response.setTeams(teams.stream().map(Team::getTeamName).collect(Collectors.toList()));
        response.setMatchUp(matchups);

        return response;
    }


}
