package com.example.chessbackendwithjpa.controller;

import com.example.chessbackendwithjpa.controller.dto.PlayerDTO;
import com.example.chessbackendwithjpa.model.Player;
import com.example.chessbackendwithjpa.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {
  private final PlayerService playerService;

  @Autowired
  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @GetMapping
  public List<Player> getPlayers() {
    return playerService.getPlayers();
  }

  @GetMapping("player/{id}")
  public Player getPlayerById(@PathVariable Long id) {
    return playerService.getPlayerById(id);
  }

  @PostMapping("player/new")
  public void addPlayer(@RequestBody PlayerDTO player) {
    playerService.addPlayer(player);
  }

  @PutMapping("player/{id}")
  public void updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO player) {
    playerService.updatePlayer(id, player);
  }

  @DeleteMapping("player/{id}")
  public boolean deletePlayer(@PathVariable Long id) {
    return playerService.deletePlayer(id);
  }
}
