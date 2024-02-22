package com.example.chessbackendwithjpa.controller.dto;

import java.math.BigDecimal;

public record ScoresByTournamentDTO(
        Long id,
        String event,
        String player,
        BigDecimal years,
        BigDecimal months,
        BigDecimal elo,
        BigDecimal points,
        Long games,
        BigDecimal oEloAvg,
        BigDecimal performance) {
}
