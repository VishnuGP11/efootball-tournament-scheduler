package com.aghni.tournament_scheduler.team.entity;

import com.aghni.tournament_scheduler.tournament.entity.Tournament;
import jakarta.persistence.*;

@Entity
@Table(
        name = "team",
        uniqueConstraints = @UniqueConstraint(columnNames = {"team_name", "tournament_id"})
)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;
    @Column(nullable = false)
    private String teamName;
    @Column(name = "owner")
    private String owner;
    @Column(name = "playing_style")
    private String playingStyle;


    @ManyToOne
    @JoinColumn(name="tournament_id")
    private Tournament tournament;

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

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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

    public Team() {}

    public Team(String teamName) {

        this.teamName = teamName;
    }

    public Team(Integer teamId, String teamName, String owner, String playingStyle, Tournament tournament) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.owner = owner;
        this.playingStyle = playingStyle;
        this.tournament = tournament;
    }
}
