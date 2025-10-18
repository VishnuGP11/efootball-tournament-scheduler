package com.aghni.tournament_scheduler.team.service;

import com.aghni.tournament_scheduler.team.entity.Team;
import com.aghni.tournament_scheduler.team.exception.TeamNotFoundException;
import com.aghni.tournament_scheduler.team.mapper.TeamMapper;
import com.aghni.tournament_scheduler.team.model.TeamDetailsResponse;
import com.aghni.tournament_scheduler.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public TeamDetailsResponse getTeamDetails(int teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException("Team Not Found for the mentioned id : "+teamId) );
        TeamDetailsResponse teamDetailsResponse = TeamMapper.teamToTeamDetailsResponse(team);
        return teamDetailsResponse;
    }
}
