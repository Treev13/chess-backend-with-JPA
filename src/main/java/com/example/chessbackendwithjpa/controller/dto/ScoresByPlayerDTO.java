package com.example.chessbackendwithjpa.controller.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

public record ScoresByPlayerDTO(Long id,
                                String name,
                                String site,
                                Date start_date,
                                Date end_date,
                                BigDecimal years,
                                BigDecimal months,
                                BigDecimal elo,
                                BigDecimal points,
                                Long games,
                                BigDecimal performance) {
}
