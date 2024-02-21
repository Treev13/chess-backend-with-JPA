package com.example.chessbackendwithjpa.controller.dto;

import java.sql.Date;

public record TournamentDTO(
        Long id,
        String name,
        String shortName,
        String site,
        Date startDate,
        Date endDate,
        int numberOfPlayers,
        String type
) {
}
