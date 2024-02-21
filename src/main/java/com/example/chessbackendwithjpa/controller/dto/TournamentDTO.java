package com.example.chessbackendwithjpa.controller.dto;

import java.sql.Date;

public record TournamentDTO(
        String id,
        String name,
        String site,
        Date startDate,
        Date endDate,
        int numberOfPlayers
) {
}
