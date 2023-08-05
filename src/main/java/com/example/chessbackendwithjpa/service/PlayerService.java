package com.example.chessbackendwithjpa.service;

import com.example.chessbackendwithjpa.controller.dto.PlayerDTO;
import com.example.chessbackendwithjpa.model.Player;
import com.example.chessbackendwithjpa.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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

  public Player getPlayerById(Long id) {
    return playerRepository.getById(id);
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
    Player updatedPlayer = playerRepository.getById(id);
    updatedPlayer.setName(player.name());
    updatedPlayer.setFideId(player.fideId());
    updatedPlayer.setNationality(player.nationality());
    updatedPlayer.setBorn(player.born());
    updatedPlayer.setEarnGM(player.earnGM());
    updatedPlayer.setCountry(player.country());
  }

  public boolean deletePlayer(Long id) {
    if (playerRepository.findById(id).isPresent()) {
      playerRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
