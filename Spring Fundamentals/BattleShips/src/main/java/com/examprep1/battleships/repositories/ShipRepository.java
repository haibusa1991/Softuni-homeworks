package com.examprep1.battleships.repositories;

import com.examprep1.battleships.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ShipRepository extends JpaRepository<Ship, UUID> {

    @Query("""
            SELECT s.name
            FROM Ship s
            JOIN User u on u.id = s.user
            WHERE u.username='haibusa3'
            """)
    String[] getOwnShipsNames(String currentUsername);

    @Query("""
            SELECT s.name
            FROM Ship s
            JOIN User u on u.id = s.user
            WHERE NOT u.username='haibusa3'
            """)
    String[] getEnemyShipsNames(String currentUsername);

    List<Ship> getAllByOrderByNameAscHealthAscPowerAsc();

    Ship getShipByName(String shipName);
}
