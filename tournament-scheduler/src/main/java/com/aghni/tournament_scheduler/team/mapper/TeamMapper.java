package com.aghni.tournament_scheduler.team.mapper;

import com.aghni.tournament_scheduler.team.entity.Team;
import com.aghni.tournament_scheduler.team.model.SuccessResponse;
import com.aghni.tournament_scheduler.team.model.TeamDetailsResponse;
import com.aghni.tournament_scheduler.team.model.TeamRequestDTO;
import com.aghni.tournament_scheduler.team.model.TournamentAssociatedWithTeamDTO;

public class TeamMapper {

    public static TeamDetailsResponse teamToTeamDetailsResponse(Team team) {
        TeamDetailsResponse teamDetailsResponse = new TeamDetailsResponse();
        teamDetailsResponse.setTeamId(team.getId());
        teamDetailsResponse.setTeamName(team.getTeamName());
        teamDetailsResponse.setOwner(team.getOwner());
        teamDetailsResponse.setPlayingStyle(team.getPlayingStyle());
        TournamentAssociatedWithTeamDTO teamToTeamDTO = new TournamentAssociatedWithTeamDTO();

        teamToTeamDTO.setTournamentId(team.getTournament().getTournamentId());
        teamToTeamDTO.setTournamentName(team.getTournament().getTournamentName());

        teamDetailsResponse.setTournamentAssociatedWithTeamDTO(teamToTeamDTO);
        return teamDetailsResponse;
    }
    public static Team teamRequestDTOToTeam(TeamRequestDTO teamRequestDTO) {
        Team team = new Team();
        team.setId(teamRequestDTO.getTeamId());
        team.setTeamName(teamRequestDTO.getTeamName());
        team.setPlayingStyle(teamRequestDTO.getPlayingStyle());
        team.setOwner(teamRequestDTO.getOwner());
        return team;
    }

    public static SuccessResponse teamRequestDTOToSuccessResponse(TeamRequestDTO teamRequestDTO) {
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setTeamRequestDTO(teamRequestDTO);
        return successResponse;
    }

}
