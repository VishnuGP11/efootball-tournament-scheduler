package com.aghni.tournament_scheduler.tournament.model;

import com.aghni.tournament_scheduler.match.model.Matchup;

import java.util.List;

public class TournamentDetailsResponse {

    private Integer tournamentId;
    private String tournamentName;
    private String tournamentType;
    private List<TeamDetailsDTO> teams;
    private List<Matchup> matchUp;

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

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

    public List<TeamDetailsDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDetailsDTO> teams) {
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

    public TournamentDetailsResponse(String tournamentName, String tournamentType, List<TeamDetailsDTO> teams, List<Matchup> matchUp, Integer tournamentId) {
        this.tournamentName = tournamentName;
        this.tournamentType = tournamentType;
        this.teams = teams;
        this.matchUp = matchUp;
        this.tournamentId = tournamentId;
    }

    @Override
    public String toString() {
        return "TournamentDetailsResponse{" +
                "tournamentId=" + tournamentId +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentType='" + tournamentType + '\'' +
                ", teams=" + teams +
                ", matchUp=" + matchUp +
                '}';
    }
}
