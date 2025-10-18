package com.aghni.tournament_scheduler.match.repository;

import com.aghni.tournament_scheduler.match.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Integer> {
}
