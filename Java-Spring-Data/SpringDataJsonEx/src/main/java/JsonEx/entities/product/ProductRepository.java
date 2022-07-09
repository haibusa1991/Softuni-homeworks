package JsonEx.entities.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("""
            SELECT new JsonEx.entities.product.SellingProductDto(p.name,p.price,s.lastName)
            FROM Product p
            JOIN p.seller s
            WHERE p.price BETWEEN :from AND :to
            """)
    Set<SellingProductDto> getSellingProductsInRange(BigDecimal from, BigDecimal to);

}
