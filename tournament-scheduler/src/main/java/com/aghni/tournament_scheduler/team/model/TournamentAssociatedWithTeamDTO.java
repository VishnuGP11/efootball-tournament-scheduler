package com.aghni.tournament_scheduler.team.model;

public class TournamentAssociatedWithTeamDTO {

    private Integer tournamentId;
    private String tournamentName;

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public TournamentAssociatedWithTeamDTO() {

    }

    public TournamentAssociatedWithTeamDTO(Integer tournamentId, String tournamentName) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
    }
}
