package com.example.chessbackendwithjpa.controller.dto;

public record ScoresByTournamentDTO(
        int id,
        String event,
        String player,
        int years,
        int months,
        int elo,
        double points,
        int games,
        int o_elo_avg,
        int performance) {
}
