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
    private Integer id;
    @Column(nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name="tournament_id")
    private Tournament tournament;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Team() {}

    public Team(String teamName) {

        this.teamName = teamName;
    }
}
