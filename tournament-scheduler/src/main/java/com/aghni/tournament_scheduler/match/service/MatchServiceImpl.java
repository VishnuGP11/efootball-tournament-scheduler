package com.aghni.tournament_scheduler.match.service;

import com.aghni.tournament_scheduler.match.Mapper.MatchMapper;
import com.aghni.tournament_scheduler.match.entity.Match;
import com.aghni.tournament_scheduler.match.exception.MatchNotFoundException;
import com.aghni.tournament_scheduler.match.repository.MatchRepository;
import com.aghni.tournament_scheduler.match.model.Matchup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MatchServiceImpl implements MatchService {

    Logger logger = Logger.getLogger(MatchServiceImpl.class.getName());

    @Autowired
    private MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Matchup getMatchDetails(Integer matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new MatchNotFoundException("Match not found for the given id"));
        logger.info("Match found with match id " + matchId);

        Matchup matchup = MatchMapper.toMatchUp(match);
        return matchup;

    }
}
