package com.example.chessbackendwithjpa.controller.dto;

import java.time.LocalDate;
import java.sql.Date;

public record PlayerDTO(
        Long id,
        String name,
        int fideId,
        String nationality,
        Date born,
        int earnGM,
        String country
) { }
