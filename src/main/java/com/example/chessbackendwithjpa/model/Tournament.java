package com.example.chessbackendwithjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournaments")
public class Tournament {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private String shortName;
  private String site;
  private Date startDate;
  private Date endDate;
  private int numberOfPlayers;
  private String type;
  /*@ManyToMany(mappedBy = "tournaments")
  private Set<Player> players;*/
}
