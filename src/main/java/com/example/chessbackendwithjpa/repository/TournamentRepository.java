package com.example.chessbackendwithjpa.repository;

import com.example.chessbackendwithjpa.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
