package com.example.chessbackendwithjpa.repository;

import com.example.chessbackendwithjpa.controller.dto.ScoresByPlayerDTO;
import com.example.chessbackendwithjpa.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  /*@Query("""
          select tour.id, tour.name, site, start_date, end_date,
              extract(year from age(tour.start_date,players.born)) as years,
              extract(month from age(tour.start_date,players.born)) as months,
              elo,
              sum(result) as points,
              count(*) as games,
              round( avg(o_elo + 800 * result - 400) ) as performance
          from matches
              inner join tournaments tour on tour.short_name = matches.event
              inner join players on players.name = matches.player
            where players.id = id
            group by player,event,elo,years,months,tour.id, tour.name, site, start_date, end_date
          order by start_date
          """)
  List <ScoresByPlayerDTO> getToursByPlayer(Long id);*/
}
