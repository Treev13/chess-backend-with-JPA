package com.example.chessbackendwithjpa.service;

import com.example.chessbackendwithjpa.controller.dto.PlayerDTO;
import com.example.chessbackendwithjpa.controller.dto.ScoresByPlayerDTO;
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

  public PlayerDTO getPlayerById(Long id) {
    Player player = playerRepository.getReferenceById(id);
    return new PlayerDTO(
            player.getId(),
            player.getName(),
            player.getFideId(),
            player.getNationality(),
            player.getBorn(),
            player.getEarnGM(),
            player.getBornCountry()
      );
  }
  /*public List<ScoresByPlayerDTO> getToursByPlayer(Long id) {
    return playerRepository.getToursByPlayer(id);
  }*/

  public void addPlayer(PlayerDTO player) {
    Player newPlayer = Player.builder()
            .name(player.name())
            .fideId(player.fideId())
            .born(player.born())
            .earnGM(player.earnGM())
            .bornCountry(player.bornCountry())
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
    updatedPlayer.setBornCountry(player.bornCountry());
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
