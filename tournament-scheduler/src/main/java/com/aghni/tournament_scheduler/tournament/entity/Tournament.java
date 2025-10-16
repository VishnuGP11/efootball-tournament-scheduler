package com.aghni.tournament_scheduler.tournament.entity;

import com.aghni.tournament_scheduler.team.entity.Team;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tournamentId;
    @Column(name = "tournament_Name", nullable = false)
    private String tournamentName;
    @Column(name = "number_of_teams", nullable = false)
    private Integer numberOfTeams;
    @Column(name = "type_of_schedule", nullable = false)
    private String typeOfSchedule;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Team> teams = new ArrayList<>();


    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
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

    public List<Team> getTeams() {
        return teams;
    }
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Tournament() {

    }

    public Tournament(String tournamentName, Integer tournamentId, Integer numberOfTeams, String typeOfSchedule,List<Team> teams) {
        this.tournamentName = tournamentName;
        this.tournamentId = tournamentId;
        this.numberOfTeams = numberOfTeams;
        this.typeOfSchedule = typeOfSchedule;
        this.teams = teams;
    }
}
