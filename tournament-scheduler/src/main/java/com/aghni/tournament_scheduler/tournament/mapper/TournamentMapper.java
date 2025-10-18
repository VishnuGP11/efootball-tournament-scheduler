package com.aghni.tournament_scheduler.tournament.mapper;

import com.aghni.tournament_scheduler.match.entity.Match;
import com.aghni.tournament_scheduler.match.model.Matchup;

public class TournamentMapper {

    public static Match toMatchEntity(Matchup matchup) {
        Match match = new Match();
        match.setScoreOfTeamA(matchup.getGoalsScoredByTeamA());
        match.setScoreOfTeamB(matchup.getGoalsScoredByTeamB());
        match.setTeamA(matchup.getTeamA());
        match.setTeamB(matchup.getTeamB());
        return match;
    }
}
