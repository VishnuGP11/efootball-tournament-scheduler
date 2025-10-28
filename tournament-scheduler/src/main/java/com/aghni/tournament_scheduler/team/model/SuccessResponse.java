package com.aghni.tournament_scheduler.team.model;

public class SuccessResponse {

    private String status;
    private String message;
    private TeamRequestDTO teamRequestDTO;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TeamRequestDTO getTeamRequestDTO() {
        return teamRequestDTO;
    }

    public void setTeamRequestDTO(TeamRequestDTO teamRequestDTO) {
        this.teamRequestDTO = teamRequestDTO;
    }

    public SuccessResponse(){

    }

    public SuccessResponse(String status, String message, TeamRequestDTO teamRequestDTO) {
        this.status = status;
        this.message = message;
        this.teamRequestDTO = teamRequestDTO;
    }
}
