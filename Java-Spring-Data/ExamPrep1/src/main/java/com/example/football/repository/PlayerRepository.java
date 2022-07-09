package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("""
            SELECT p
            FROM Player p
            JOIN p.stats s
            WHERE p.birthDate BETWEEN :from AND :to
            ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.lastName ASC
            """)
    List<Player> getBestPlayers(LocalDate from, LocalDate to);
}
