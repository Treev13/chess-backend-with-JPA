package com.example.chessbackendwithjpa.model;

import com.example.chessbackendwithjpa.model.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tours")
public class Tournament {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private String site;
  private Date start;
  private Date end;
  private int numberOfPlayers;
  @ManyToMany(mappedBy = "tournaments")
  private Set<Player> players;
}
