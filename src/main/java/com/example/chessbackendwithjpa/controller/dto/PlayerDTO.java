package com.example.chessbackendwithjpa.controller.dto;

import java.time.LocalDate;
import java.util.Date;

public record PlayerDTO(
        String name,
        int fide_id,
        LocalDate born,
        String born_place,
        int earn_gm,
        String country,
        int id
) { }
