package com.aghni.tournament_scheduler.team.service;

import com.aghni.tournament_scheduler.team.model.TeamDetailsResponse;
import com.aghni.tournament_scheduler.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface TeamService {


    TeamDetailsResponse getTeamDetails(int teamId);
}
