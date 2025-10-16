package com.aghni.tournament_scheduler.tournament.exception;

public class TournamentNameAlreadyExistsException extends Exception{

    private String message;
    public TournamentNameAlreadyExistsException(String message) {
        super(message);
    }
}
