package com.example.chessbackendwithjpa.controller.dto;

import java.util.Date;

public record PlayerDTO(
        String name,
        Integer fideId,
        String nationality,
        Date born,
        Integer earnGM,
        String country
) { }
