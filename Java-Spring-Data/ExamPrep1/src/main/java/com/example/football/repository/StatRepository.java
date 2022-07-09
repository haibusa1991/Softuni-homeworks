package com.example.football.repository;

import com.example.football.models.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ToDo:
@Repository
public interface StatRepository extends JpaRepository<Stat, Integer> {

    Stat getByPassingAndShootingAndEndurance(double passing, double shooting, double endurance);
}
