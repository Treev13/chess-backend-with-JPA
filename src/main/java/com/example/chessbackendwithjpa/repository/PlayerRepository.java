package com.example.chessbackendwithjpa.repository;

import com.example.chessbackendwithjpa.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
