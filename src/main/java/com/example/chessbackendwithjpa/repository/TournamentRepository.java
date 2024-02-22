package com.example.chessbackendwithjpa.repository;

import com.example.chessbackendwithjpa.model.Tournament;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
  @Query(value = """
          select players.id, event, player,
              extract(year from age(tour.start_date,players.born)) years,
              extract(month from age(tour.start_date,players.born)) months,
              elo,
              sum(result) points,
              count(*) games,
              round( avg(o_elo) ) o_elo_avg,
              round( avg(o_elo + 800 * result - 400) ) performance
          from matches
              inner join tournaments tour on tour.short_name = matches.event
              inner join players on players.name = matches.player
          where tour.id = ?
          group by players.id,event,player,elo,years,months,tour.id, tour.name, site, start_date, end_date
          order by points desc, elo desc;
          """,
          nativeQuery = true)
  List<Tuple> getPlayersByTour(Long id);
}
