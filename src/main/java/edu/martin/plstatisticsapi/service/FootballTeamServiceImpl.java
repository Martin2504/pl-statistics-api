package edu.martin.plstatisticsapi.service;

import edu.martin.plstatisticsapi.model.FootballTeam;
import edu.martin.plstatisticsapi.repository.FootballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballTeamServiceImpl implements FootballTeamService{

    @Autowired
    private FootballTeamRepository footballTeamRepository;

    @Override
    public FootballTeam saveTeam(FootballTeam footballTeam) {
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public List<FootballTeam> getAllFootballTeams() {
        return footballTeamRepository.findAll();
    }



    @Override
    public Optional<FootballTeam> getTeamByID(int id) {
        return footballTeamRepository.findById(id);
        //return null;
    }


}
