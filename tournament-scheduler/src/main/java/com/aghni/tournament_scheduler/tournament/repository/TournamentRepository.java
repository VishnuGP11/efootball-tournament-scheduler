package com.aghni.tournament_scheduler.tournament.repository;

import com.aghni.tournament_scheduler.tournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Integer> {
    Tournament findTournamentByTournamentName(String tournamentName);
}
