package com.examprep1.battleships.repositories;

import com.examprep1.battleships.entities.Category;
import com.examprep1.battleships.enumeration.ShipCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findCategoryByName(ShipCategory category);
}
