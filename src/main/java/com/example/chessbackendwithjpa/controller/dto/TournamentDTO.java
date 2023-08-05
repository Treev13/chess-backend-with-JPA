package com.example.chessbackendwithjpa.controller.dto;

import java.sql.Date;

public record TournamentDTO(
        String name,
        String site,
        Date start,
        Date end,
        int numberOfPlayers
) {
}
