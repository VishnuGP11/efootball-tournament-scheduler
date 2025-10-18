package com.aghni.tournament_scheduler.match.Mapper;

import com.aghni.tournament_scheduler.match.entity.Match;
import com.aghni.tournament_scheduler.match.model.Matchup;

public class MatchMapper {

    public  static Matchup toMatchUp(Match match){
        Matchup matchup = new Matchup();
        matchup.setMatchId(match.getMatchId());
        matchup.setTeamA(match.getTeamA());
        matchup.setTeamB(match.getTeamB());
        matchup.setGoalsScoredByTeamA(match.getScoreOfTeamA());
        matchup.setGoalsScoredByTeamB(match.getScoreOfTeamB());
        return matchup;
    }
}
