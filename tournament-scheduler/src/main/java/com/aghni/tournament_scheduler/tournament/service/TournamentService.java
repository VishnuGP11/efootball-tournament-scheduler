package com.aghni.tournament_scheduler.tournament.service;

import com.aghni.tournament_scheduler.tournament.exception.TournamentNameAlreadyExistsException;
import com.aghni.tournament_scheduler.tournament.exception.TournamentNotFoundException;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentRequest;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentResponse;
import com.aghni.tournament_scheduler.tournament.model.TournamentDetailsResponse;
import org.springframework.stereotype.Service;

@Service
public interface TournamentService {

    public AddTournamentResponse createTournament(AddTournamentRequest addTournamentRequest);

    public Integer returnTournamentIdUsingName(String tournamentName);

    TournamentDetailsResponse getTournamentDetails(Integer tournamentId) throws TournamentNotFoundException;
}
