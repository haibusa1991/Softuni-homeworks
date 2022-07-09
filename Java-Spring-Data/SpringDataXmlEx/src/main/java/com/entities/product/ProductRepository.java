package com.entities.product;

import com.entities.category.ExportCategoryStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query("""
            SELECT new com.entities.product.ExportProductDto (p.name, p.price, p.seller.firstName, p.seller.lastName)
            FROM Product p
            WHERE p.buyer IS NULL AND p.price BETWEEN :from AND :to
            """)
    List<ExportProductDto> getProductDtosInRange(BigDecimal from, BigDecimal to);


}
