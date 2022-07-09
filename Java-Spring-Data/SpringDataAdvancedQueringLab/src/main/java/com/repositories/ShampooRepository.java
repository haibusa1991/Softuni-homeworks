package com.repositories;

import com.entities.Shampoo;
import com.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPriceAsc(Size size, Long id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    long countByPriceLessThan(BigDecimal price);

    @Query("""
            SELECT s.brand
            FROM Shampoo s
            JOIN s.ingredients i
            WHERE i.name IN :ingredientsList
            """)
    Set<String> findAllBrandNamesContainingIngredients(Set<String> ingredientsList);

    @Query("""
            SELECT s.brand
            FROM Shampoo s
            WHERE s.ingredients.size < :ingredientCount
            """)
    Set<String> getAllShampoosWithIngredientsLessThan(int ingredientCount);
}
