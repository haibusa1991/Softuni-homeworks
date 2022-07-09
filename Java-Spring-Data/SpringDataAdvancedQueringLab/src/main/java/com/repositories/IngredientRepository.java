package com.repositories;

import com.entities.Ingredient;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String startsWith);

    List<Ingredient> findAllByNameIn(List<String> ingredientNames);

    @Transactional
    @Modifying
    @Query("""
            DELETE FROM Ingredient i
            WHERE i.name = :ingredientName
            """)
    int deleteIngredientByName(String ingredientName);

    @Transactional
    @Modifying
    @Query("""
            UPDATE Ingredient i
            SET i.price = i.price * :percentage
            """)
    int increaseIngredientPriceBy(BigDecimal percentage);

    @Transactional
    @Modifying
    @Query("""
            UPDATE Ingredient i
            SET i.price = i.price * :percentage
            WHERE i.name IN :ingredientNames
            """)
    int increaseIngredientPriceBy(BigDecimal percentage, Set<String> ingredientNames);

}
