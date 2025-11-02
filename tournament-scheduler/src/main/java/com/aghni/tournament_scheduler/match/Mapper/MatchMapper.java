package com.aghni.tournament_scheduler.match.Mapper;

import com.aghni.tournament_scheduler.match.entity.Match;
import com.aghni.tournament_scheduler.match.model.Matchup;

public class MatchMapper {

    public  static Matchup toMatchUp(Match match){
        Matchup matchup = new Matchup();
        matchup.setMatchId(match.getMatchId());
        matchup.setTeamAId(match.getTeamA().getTeamId());
        matchup.setTeamBId(match.getTeamB().getTeamId());
        matchup.setTeamA(match.getTeamA().getTeamName());
        matchup.setTeamB(match.getTeamB().getTeamName());
        matchup.setGoalsScoredByTeamA(match.getScoreOfTeamA());
        matchup.setGoalsScoredByTeamB(match.getScoreOfTeamB());
        return matchup;
    }
}
