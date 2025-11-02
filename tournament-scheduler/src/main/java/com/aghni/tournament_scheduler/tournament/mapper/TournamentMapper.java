package com.aghni.tournament_scheduler.tournament.mapper;

import com.aghni.tournament_scheduler.match.entity.Match;
import com.aghni.tournament_scheduler.match.model.Matchup;
import com.aghni.tournament_scheduler.team.entity.Team;

public class TournamentMapper {

    public static Match toMatchEntity(Matchup matchup, Team teamA, Team teamB) {
        Match match = new Match();
        match.setTeamA(teamA);
        match.setTeamB(teamB);
        match.setScoreOfTeamA(matchup.getGoalsScoredByTeamA());
        match.setScoreOfTeamB(matchup.getGoalsScoredByTeamB());
        return match;
    }

    // ✅ Reverse mapping (Match → Matchup DTO)
    public static Matchup toMatchupDTO(Match match) {
        Matchup dto = new Matchup();
        dto.setMatchId(match.getMatchId());
        dto.setTeamAId(match.getTeamA().getTeamId());
        dto.setTeamBId(match.getTeamB().getTeamId());
        dto.setTeamA(match.getTeamA().getTeamName());
        dto.setTeamB(match.getTeamB().getTeamName());
        dto.setGoalsScoredByTeamA(match.getScoreOfTeamA());
        dto.setGoalsScoredByTeamB(match.getScoreOfTeamB());
        return dto;
    }

}
