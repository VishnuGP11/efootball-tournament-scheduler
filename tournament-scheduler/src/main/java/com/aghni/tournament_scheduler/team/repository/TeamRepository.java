package com.aghni.tournament_scheduler.team.repository;

import com.aghni.tournament_scheduler.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
}
