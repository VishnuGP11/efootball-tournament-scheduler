package com.aghni.tournament_scheduler.tournament.service;

import com.aghni.tournament_scheduler.match.entity.Match;
import com.aghni.tournament_scheduler.match.repository.MatchRepository;
import com.aghni.tournament_scheduler.team.entity.Team;
import com.aghni.tournament_scheduler.tournament.entity.Tournament;
import com.aghni.tournament_scheduler.tournament.exception.TournamentNotFoundException;
import com.aghni.tournament_scheduler.tournament.mapper.TournamentMapper;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentRequest;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentResponse;
import com.aghni.tournament_scheduler.match.model.Matchup;
import com.aghni.tournament_scheduler.tournament.model.TeamDetailsDTO;
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

    @Autowired
    private MatchRepository matchRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, MatchRepository matchRepository) {
        this.tournamentRepository = tournamentRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public AddTournamentResponse createTournament(AddTournamentRequest addTournamentRequest) {

        Tournament tournament = new Tournament();
        tournament.setTournamentName(addTournamentRequest.getTournamentName());
        tournament.setNumberOfTeams(addTournamentRequest.getNumberOfTeams());
        tournament.setTypeOfSchedule(addTournamentRequest.getTypeOfSchedule());

        // for setting team name according to number of teams
        List<Team> teams = new ArrayList<>();
        for(int i=1; i<=addTournamentRequest.getNumberOfTeams(); i++){
            Team team = new Team("Team"+i+" "+addTournamentRequest.getTournamentName());
            team.setTournament(tournament);
            teams.add(team);
        }
        tournament.setTeams(teams);


        Tournament savedTournament = tournamentRepository.save(tournament);
        logger.info("Saved Tournament of name : " + savedTournament.getTournamentName());

        List<Match> matches = generateMatches(savedTournament);
        // saving all matches to match repository
        logger.info("saving all matches to match repository");
        matchRepository.saveAll(matches);

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

    private List<Match> generateMatches(Tournament savedTournament) {
        List<Match> matches = new ArrayList<>();

        List<Team> teams = savedTournament.getTeams();
        String type = savedTournament.getTypeOfSchedule();

        if ("round robin".equalsIgnoreCase(type)) {
            for (int i = 0; i < teams.size(); i++) {
                for (int j = i + 1; j < teams.size(); j++) {
                    Matchup matchup = new Matchup(teams.get(i).getTeamName(), teams.get(j).getTeamName(), 0, 0);
                    Match match = TournamentMapper.toMatchEntity(matchup);
                    match.setTournament(savedTournament);
                    matches.add(match);
                }
            }
        } else if ("elimination".equalsIgnoreCase(type)) {
            for (int i = 0; i < teams.size(); i += 2) {
                Matchup matchup;
                if (i + 1 < teams.size()) {
                    matchup = new Matchup(teams.get(i).getTeamName(), teams.get(i + 1).getTeamName(), 0, 0);
                } else {
                    matchup = new Matchup(teams.get(i).getTeamName(), "BYE", 0, 0);
                }
                Match match = TournamentMapper.toMatchEntity(matchup);
                match.setTournament(savedTournament);
                matches.add(match);
            }
        }

        return matches;
    }




    public Integer returnTournamentIdUsingName(String tournamentName) {
        return tournamentRepository.findTournamentByTournamentName(tournamentName).getTournamentId();
    }

    @Override
    public TournamentDetailsResponse getTournamentDetails(Integer tournamentId)
            throws TournamentNotFoundException {

        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new TournamentNotFoundException(
                        "Tournament not found for the mentioned id :" + tournamentId));

        // ✅ Only FETCH existing matches — no creation
        List<Match> existingMatches = matchRepository.findByTournament_TournamentId(tournamentId);
        logger.info("list of matches fetched : " + existingMatches.toString());
        List<Matchup> matchups = existingMatches.stream()
                .map(TournamentMapper::toMatchupDTO)
                .collect(Collectors.toList());

        logger.info("list of matchups fetched : " + matchups.toString());

        TournamentDetailsResponse response = new TournamentDetailsResponse();
        response.setTournamentId(tournamentId);
        response.setTournamentName(tournament.getTournamentName());
        response.setTournamentType(tournament.getTypeOfSchedule());
        response.setTeams(tournament.getTeams().stream()
                .map(team -> new TeamDetailsDTO(team.getId(), team.getTeamName()))
                .collect(Collectors.toList()));
        response.setMatchUp(matchups);
        logger.info("response of tournament details fetched : " + response.toString());

        return response;
    }

}
