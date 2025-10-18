package com.aghni.tournament_scheduler.tournament.model;

import com.aghni.tournament_scheduler.match.model.Matchup;

import java.util.List;

public class TournamentDetailsResponse {

    private String tournamentName;
    private String tournamentType;
    private List<String> teams;
    private List<Matchup> matchUp;

    public String getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(String tournamentType) {
        this.tournamentType = tournamentType;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public List<Matchup> getMatchUp() {
        return matchUp;
    }

    public void setMatchUp(List<Matchup> matchUp) {
        this.matchUp = matchUp;
    }

    public TournamentDetailsResponse() {

    }

    public TournamentDetailsResponse(String tournamentName, String tournamentType, List<String> teams, List<Matchup> matchUp) {
        this.tournamentName = tournamentName;
        this.tournamentType = tournamentType;
        this.teams = teams;
        this.matchUp = matchUp;
    }
}
