package com.aghni.tournament_scheduler.config;

import com.aghni.tournament_scheduler.common.ErrorResponse;
import com.aghni.tournament_scheduler.match.exception.MatchNotFoundException;
import com.aghni.tournament_scheduler.team.exception.TeamNotFoundException;
import com.aghni.tournament_scheduler.tournament.exception.TournamentNameAlreadyExistsException;
import com.aghni.tournament_scheduler.tournament.exception.TournamentNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

         @ExceptionHandler(TournamentNameAlreadyExistsException.class)
         public ResponseEntity<ErrorResponse> handleTournamentNameAlreadyExistsException(TournamentNameAlreadyExistsException e) {
             ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),e.getMessage(),409);
             return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
         }

         @ExceptionHandler(TournamentNotFoundException.class)
         public ResponseEntity<ErrorResponse> handleTournamentNotFoundException(TournamentNotFoundException e) {
             ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),e.getMessage(),404);
             return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
         }

         @ExceptionHandler(MatchNotFoundException.class)
         public ResponseEntity<ErrorResponse> handleMatchNotFoundException(MatchNotFoundException e) {
             ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),e.getMessage(),404);
             return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
         }

         @ExceptionHandler(TeamNotFoundException.class)
         public ResponseEntity<ErrorResponse> handleTeamNotFoundException(TeamNotFoundException e) {
             ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),e.getMessage(),404);
             return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
         }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(LocalDateTime.now(),"Team name already exists in this tournament.",409));
    }
}
