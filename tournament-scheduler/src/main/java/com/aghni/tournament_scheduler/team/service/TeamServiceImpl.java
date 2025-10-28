package com.aghni.tournament_scheduler.team.service;

import com.aghni.tournament_scheduler.team.entity.Team;
import com.aghni.tournament_scheduler.team.exception.TeamNotFoundException;
import com.aghni.tournament_scheduler.team.mapper.TeamMapper;
import com.aghni.tournament_scheduler.team.model.SuccessResponse;
import com.aghni.tournament_scheduler.team.model.TeamDetailsResponse;
import com.aghni.tournament_scheduler.team.model.TeamRequestDTO;
import com.aghni.tournament_scheduler.team.repository.TeamRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public TeamDetailsResponse getTeamDetails(int teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException("Team Not Found for the mentioned id : "+teamId) );
        TeamDetailsResponse teamDetailsResponse = TeamMapper.teamToTeamDetailsResponse(team);
        logger.info("Team Details with team id : {}", teamId);
        return teamDetailsResponse;
    }

    @Override
    public SuccessResponse updateTeamDetails(int teamId, TeamRequestDTO teamRequestDTO) throws TeamNotFoundException{
        logger.info("Team id with direct teamId : {}", teamId);
        logger.info("Team id with teamRequestDTO : {}", teamRequestDTO.getTeamId());
        // getting updated team details and saving to db
        if(teamId != teamRequestDTO.getTeamId()){
            logger.error("Team Id and Team Id do not match");
            throw new TeamNotFoundException("Team Id and Team Id Not Match");
        }
        Team team = TeamMapper.teamRequestDTOToTeam(teamRequestDTO);
        Team optionalTeam = teamRepository.findById(teamId)
                .orElseThrow(() ->  new TeamNotFoundException("Team Not Found for the mentioned id : "+teamId));
        team.setTournament(optionalTeam.getTournament());

        Integer tournamentId = team.getTournament().getTournamentId();

        // saving team details
        teamRepository.save(team);

        teamRequestDTO.setTournamentId(tournamentId);

        SuccessResponse response = TeamMapper.teamRequestDTOToSuccessResponse(teamRequestDTO);
        response.setStatus("Success");
        response.setMessage("Successfully Updated Team");
        logger.info("Team updated with team id : {}", teamId);
        return response;
    }
}
