package com.example.chessbackendwithjpa.model;

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
@Table(name= "players")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer fideId;
  private String nationality;
  private Date born;
  private Integer earnGM;
  private String country;
  /*@ManyToMany
  @JoinTable(
          name = "tournamentsByPlayer",
          joinColumns = @JoinColumn(name = "player_id"),
          inverseJoinColumns = @JoinColumn(name = "tournament_id")
  )
  private Set<Tournament> tournaments;*/
}
