package com.aghni.tournament_scheduler.tournament.model;

public class Matchup {

    private String teamA;
    private String teamB;

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

    public Matchup() {}

    public Matchup(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }
}
