package com.example.chessbackendwithjpa.controller.dto;

import java.time.LocalDate;
import java.util.Date;

public record PlayerDTO(
        int id,
        String name,
        int fideId,
        String nationality,
        Date born,
        String born_place,
        int earnGM,
        String bornCountry
) { }
