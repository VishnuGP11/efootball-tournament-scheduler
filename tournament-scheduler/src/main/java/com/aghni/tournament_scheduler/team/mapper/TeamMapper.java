package com.aghni.tournament_scheduler.team.mapper;

import com.aghni.tournament_scheduler.team.entity.Team;
import com.aghni.tournament_scheduler.team.model.TeamDetailsResponse;
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
}
