package com.aghni.tournament_scheduler.team.model;

public class TeamDetailsResponse {

    private int teamId;
    private String teamName;
    private String playingStyle;
    private String Owner;
    private TournamentAssociatedWithTeamDTO tournamentAssociatedWithTeamDTO;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayingStyle() {
        return playingStyle;
    }

    public void setPlayingStyle(String playingStyle) {
        this.playingStyle = playingStyle;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public TournamentAssociatedWithTeamDTO getTournamentAssociatedWithTeamDTO() {
        return tournamentAssociatedWithTeamDTO;
    }

    public void setTournamentAssociatedWithTeamDTO(TournamentAssociatedWithTeamDTO tournamentAssociatedWithTeamDTO) {
        this.tournamentAssociatedWithTeamDTO = tournamentAssociatedWithTeamDTO;
    }

    public TeamDetailsResponse() {

    }
    public TeamDetailsResponse(int teamId, String teamName, String playingStyle, String owner, TournamentAssociatedWithTeamDTO tournamentAssociatedWithTeamDTO) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.playingStyle = playingStyle;
        this.Owner = owner;
        this.tournamentAssociatedWithTeamDTO = tournamentAssociatedWithTeamDTO;
    }
}
