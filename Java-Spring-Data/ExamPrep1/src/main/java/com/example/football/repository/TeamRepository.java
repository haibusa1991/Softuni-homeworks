package com.example.football.repository;

import com.example.football.models.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ToDo:
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    Team getTeamByName(String teamName);
}
