package com.aghni.tournament_scheduler.tournament.model;

public class AddTournamentRequest {

    private String tournamentName;
    private Integer numberOfTeams;
    private String typeOfSchedule;

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Integer getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(Integer numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getTypeOfSchedule() {
        return typeOfSchedule;
    }

    public void setTypeOfSchedule(String typeOfSchedule) {
        this.typeOfSchedule = typeOfSchedule;
    }
}
