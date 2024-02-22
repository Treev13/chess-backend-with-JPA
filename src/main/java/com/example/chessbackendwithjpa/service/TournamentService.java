package com.example.chessbackendwithjpa.service;

import com.example.chessbackendwithjpa.controller.dto.ScoresByTournamentDTO;
import com.example.chessbackendwithjpa.controller.dto.TournamentDTO;
import com.example.chessbackendwithjpa.model.Tournament;
import com.example.chessbackendwithjpa.repository.TournamentRepository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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

  public TournamentDTO getTournamentById(Long id) {
    Tournament tour = tournamentRepository.getReferenceById(id);
    return new TournamentDTO(
            tour.getId(),
            tour.getName(),
            tour.getShortName(),
            tour.getSite(),
            tour.getStartDate(),
            tour.getEndDate(),
            tour.getNumberOfPlayers(),
            tour.getType()
    );
  }
  public List<ScoresByTournamentDTO> getPlayersByTour(Long id) {
    List<Tuple> result = tournamentRepository.getPlayersByTour(id);
    List<ScoresByTournamentDTO> players = new ArrayList<>();
    for (Tuple tuple : result) {
      ScoresByTournamentDTO dto = new ScoresByTournamentDTO(
              tuple.get("id", Long.class),
              tuple.get("event", String.class),
              tuple.get("player", String.class),
              tuple.get("years", BigDecimal.class),
              tuple.get("months", BigDecimal.class),
              tuple.get("elo", BigDecimal.class),
              tuple.get("points", BigDecimal.class),
              tuple.get("games", Long.class),
              tuple.get("o_elo_avg", BigDecimal.class),
              tuple.get("performance", BigDecimal.class)
      );
      players.add(dto);
    }
    return players;
  }
  public void addTournament(TournamentDTO tour) {
    Tournament newTour = Tournament.builder()
            .name(tour.name())
            .site(tour.site())
            .shortName(tour.shortName())
            .startDate(tour.startDate())
            .endDate(tour.endDate())
            .numberOfPlayers(tour.numberOfPlayers())
            .type(tour.type())
            .build();
    tournamentRepository.save(newTour);
  }

  public void updateTournament(Long id, TournamentDTO tour) {
    Tournament updatedTour = tournamentRepository.getReferenceById(id);
    updatedTour.setName(tour.name());
    updatedTour.setSite(tour.site());
    updatedTour.setShortName(tour.shortName());
    updatedTour.setStartDate(tour.startDate());
    updatedTour.setEndDate(tour.endDate());
    updatedTour.setNumberOfPlayers(tour.numberOfPlayers());
    updatedTour.setType(tour.type());
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
