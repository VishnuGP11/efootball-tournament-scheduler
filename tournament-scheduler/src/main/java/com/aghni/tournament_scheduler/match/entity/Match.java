package com.aghni.tournament_scheduler.match.entity;

import com.aghni.tournament_scheduler.tournament.entity.Tournament;
import jakarta.persistence.*;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;
    @Column(name = "team_A")
    private String teamA;
    @Column(name = "team_B")
    private String teamB;
    @Column(name = "score_Of_Team_A")
    private Integer scoreOfTeamA;
    @Column(name = "score_Of_Team_B")
    private Integer scoreOfTeamB;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Integer getScoreOfTeamA() {
        return scoreOfTeamA;
    }

    public void setScoreOfTeamA(Integer scoreOfTeamA) {
        this.scoreOfTeamA = scoreOfTeamA;
    }

    public Integer getScoreOfTeamB() {
        return scoreOfTeamB;
    }

    public void setScoreOfTeamB(Integer scoreOfTeamB) {
        this.scoreOfTeamB = scoreOfTeamB;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Match(){

    }

   public Match(Integer matchId,String teamA, String teamB, Integer scoreOfTeamA, Integer scoreOfTeamB, Tournament tournament) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreOfTeamA = scoreOfTeamA;
        this.scoreOfTeamB = scoreOfTeamB;
        this.tournament = tournament;
   }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", scoreOfTeamA=" + scoreOfTeamA +
                ", scoreOfTeamB=" + scoreOfTeamB +
                ", tournament=" + tournament +
                '}';
    }
}
