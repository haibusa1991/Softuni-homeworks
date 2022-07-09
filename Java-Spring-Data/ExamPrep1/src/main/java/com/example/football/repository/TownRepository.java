package com.example.football.repository;


import com.example.football.models.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ToDo:
@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {

    Town getTownByName(String name);
}
