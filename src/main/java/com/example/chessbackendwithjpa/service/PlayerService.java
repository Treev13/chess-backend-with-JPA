package com.example.chessbackendwithjpa.service;

import com.example.chessbackendwithjpa.controller.dto.PlayerDTO;
import com.example.chessbackendwithjpa.controller.dto.ScoresByPlayerDTO;
import com.example.chessbackendwithjpa.model.Player;
import com.example.chessbackendwithjpa.repository.PlayerRepository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
  private PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }


  public List<Player> getPlayers() {
    return playerRepository.findAll();
  }

  public PlayerDTO getPlayerById(Long id) {
    Player player = playerRepository.getReferenceById(id);
    return new PlayerDTO(
            player.getId(),
            player.getName(),
            player.getFideId(),
            player.getNationality(),
            player.getBorn(),
            player.getEarnGM(),
            player.getCountry()
    );
  }

  public List<ScoresByPlayerDTO> getToursByPlayer(Long id) {
    List<Tuple> result = playerRepository.getToursByPlayer(id);
    List<ScoresByPlayerDTO> matches = new ArrayList<>();
    for (Tuple tuple : result) {
      ScoresByPlayerDTO dto = new ScoresByPlayerDTO(
              tuple.get("id", Long.class),
              tuple.get("name", String.class),
              tuple.get("site", String.class),
              tuple.get("start_date", Date.class),
              tuple.get("end_date", Date.class),
              tuple.get("years", BigDecimal.class),
              tuple.get("months", BigDecimal.class),
              tuple.get("elo", BigDecimal.class),
              tuple.get("points", BigDecimal.class),
              tuple.get("games", Long.class),
              tuple.get("performance", BigDecimal.class)
      );
      matches.add(dto);
    }
    return matches;
  }

  public void addPlayer(PlayerDTO player) {
    Player newPlayer = Player.builder()
            .name(player.name())
            .fideId(player.fideId())
            .nationality(player.nationality())
            .born(player.born())
            .earnGM(player.earnGM())
            .country(player.country())
            .build();
    playerRepository.save(newPlayer);
  }

  public void updatePlayer(Long id, PlayerDTO player) {
    Player updatedPlayer = playerRepository.getReferenceById(id);
    updatedPlayer.setName(player.name());
    updatedPlayer.setFideId(player.fideId());
    updatedPlayer.setNationality(player.nationality());
    updatedPlayer.setBorn(player.born());
    updatedPlayer.setEarnGM(player.earnGM());
    updatedPlayer.setCountry(player.country());
    playerRepository.save(updatedPlayer);
  }

  public boolean deletePlayer(Long id) {
    if (playerRepository.findById(id).isPresent()) {
      playerRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
