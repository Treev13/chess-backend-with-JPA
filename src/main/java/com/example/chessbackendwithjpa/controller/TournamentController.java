package com.example.chessbackendwithjpa.controller;

import com.example.chessbackendwithjpa.controller.dto.TournamentDTO;
import com.example.chessbackendwithjpa.model.Tournament;
import com.example.chessbackendwithjpa.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tours")
public class TournamentController {
  private final TournamentService tournamentService;

  @Autowired
  public TournamentController(TournamentService tournamentService) {
    this.tournamentService = tournamentService;
  }

  @GetMapping
  public List<Tournament> getTournaments() {
    return tournamentService.getTournaments();
  }

  @GetMapping("tour/{id}")
  public Tournament getTournamentById(@PathVariable Long id) {
    return tournamentService.getTournamentById(id);
  }

  @PostMapping("tour/new")
  public void addTournament(@RequestBody TournamentDTO tour) {
    tournamentService.addTournament(tour);
  }

  @PutMapping("player/{id}")
  public void updateTournament(@PathVariable Long id, @RequestBody TournamentDTO tour) {
    tournamentService.updateTournament(id, tour);
  }

  @DeleteMapping("player/{id}")
  public boolean deleteTournament(@PathVariable Long id) {
    return tournamentService.deleteTournament(id);
  }
}
