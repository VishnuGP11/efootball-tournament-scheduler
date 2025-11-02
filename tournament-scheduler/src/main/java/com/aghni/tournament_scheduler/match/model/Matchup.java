package com.aghni.tournament_scheduler.match.model;

public class Matchup {

    private Integer matchId;

    private Integer teamAId;
    private Integer teamBId;
    private String teamA;
    private String teamB;
    private Integer goalsScoredByTeamA;
    private Integer goalsScoredByTeamB;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Integer teamAId) {
        this.teamAId = teamAId;
    }

    public Integer getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Integer teamBId) {
        this.teamBId = teamBId;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Integer getGoalsScoredByTeamA() {
        return goalsScoredByTeamA;
    }
    public void setGoalsScoredByTeamA(Integer goalsScoredByTeamA) {
        this.goalsScoredByTeamA = goalsScoredByTeamA;
    }
    public Integer getGoalsScoredByTeamB() {
        return goalsScoredByTeamB;
    }
    public void setGoalsScoredByTeamB(Integer goalsScoredByTeamB) {
        this.goalsScoredByTeamB = goalsScoredByTeamB;
    }

    public Matchup() {}

    public Matchup(String teamA, String teamB, Integer goalsScoredByTeamA, Integer goalsScoredByTeamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsScoredByTeamA = goalsScoredByTeamA;
        this.goalsScoredByTeamB = goalsScoredByTeamB;
    }

    public Matchup(Integer matchId, Integer teamAId, Integer teamBId, String teamA, Integer goalsScoredByTeamA, String teamB, Integer goalsScoredByTeamB) {
        this.matchId = matchId;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.teamA = teamA;
        this.goalsScoredByTeamA = goalsScoredByTeamA;
        this.teamB = teamB;
        this.goalsScoredByTeamB = goalsScoredByTeamB;
    }

    public Matchup(Integer matchId, String teamA, String teamB, Integer goalsScoredByTeamA, Integer goalsScoredByTeamB) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsScoredByTeamA = goalsScoredByTeamA;
        this.goalsScoredByTeamB = goalsScoredByTeamB;
    }
}
