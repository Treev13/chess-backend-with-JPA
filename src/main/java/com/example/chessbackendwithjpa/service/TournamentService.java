package com.example.chessbackendwithjpa.service;

import com.example.chessbackendwithjpa.controller.dto.TournamentDTO;
import com.example.chessbackendwithjpa.model.Player;
import com.example.chessbackendwithjpa.model.Tournament;
import com.example.chessbackendwithjpa.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
  TournamentRepository tournamentRepository;

  public TournamentService(TournamentRepository tournamentRepository) {
    this.tournamentRepository = tournamentRepository;
  }

  public List<Tournament> getTournaments() {
    return tournamentRepository.findAll();
  }

  public Tournament getTournamentById(Long id) {
    return tournamentRepository.getById(id);
  }

  public void addTournament(TournamentDTO tour) {
    Tournament newTour = Tournament.builder()
            .name(tour.name())
            .site(tour.site())
            .start(tour.start())
            .end(tour.end())
            .numberOfPlayers(tour.numberOfPlayers())
            .build();
    tournamentRepository.save(newTour);
  }

  public void updateTournament(Long id, TournamentDTO tour) {
    Tournament updatedTour = tournamentRepository.getById(id);
    updatedTour.setName(tour.name());
    updatedTour.setSite(tour.site());
    updatedTour.setStart(tour.start());
    updatedTour.setEnd(tour.end());
    updatedTour.setNumberOfPlayers(tour.numberOfPlayers());
    tournamentRepository.save(updatedTour);
  }

  public boolean deleteTournament(Long id) {
    if (tournamentRepository.findById(id).isPresent()) {
      tournamentRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
