package com.aghni.tournament_scheduler.match.service;

import com.aghni.tournament_scheduler.match.model.Matchup;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {

    Matchup getMatchDetails(Integer matchId);
}
