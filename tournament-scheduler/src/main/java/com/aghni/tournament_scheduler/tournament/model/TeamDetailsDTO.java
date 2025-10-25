package com.aghni.tournament_scheduler.tournament.model;

import com.aghni.tournament_scheduler.match.model.Matchup;

public class TeamDetailsDTO {

    private Integer teamId;
    private String teamName;

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
    public TeamDetailsDTO() {

    }
    public TeamDetailsDTO(Integer teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }
}
