package com.entities.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category getCategoryById(int id);

    //    public ExportCategoryStatisticsDto(String name, int count, double averagePrice, BigDecimal totalRevenue) {
    @Query("""
            SELECT new com.entities.category.ExportCategoryStatisticsDto
                       (c.name, c.productsInCategory.size, AVG (p.price), SUM (p.price))
            FROM Category c
            JOIN c.productsInCategory p
            GROUP BY c.name
            """)
    List<ExportCategoryStatisticsDto> getCategoryStatistics();
}
