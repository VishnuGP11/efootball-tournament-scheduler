package com.aghni.tournament_scheduler.team.model;

public class TeamRequestDTO {

    private Integer teamId;
    private String teamName;
    private String owner;
    private String playingStyle;
    private Integer tournamentId;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPlayingStyle() {
        return playingStyle;
    }

    public void setPlayingStyle(String playingStyle) {
        this.playingStyle = playingStyle;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public TeamRequestDTO() {

    }

    public TeamRequestDTO(Integer teamId, String teamName, String owner, String playingStyle, Integer tournamentId) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.owner = owner;
        this.playingStyle = playingStyle;
        this.tournamentId = tournamentId;
    }
}
