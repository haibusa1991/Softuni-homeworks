package JsonEx.entities.category;

import JsonEx.entities.product.ProductCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category getCategoryById(Integer id);

    //    public ProductCountDto(String category, int count, BigDecimal averagePrice, BigDecimal totalRevenue) {
    @Query("""
            SELECT new JsonEx.entities.product.ProductCountDto (
            c.name,
            COUNT (p.name),
            AVG (p.price),
            SUM (p.price))
            FROM Category c
            JOIN c.products p
            GROUP BY c.name
                        """)
    List<ProductCountDto> getProductCount();
}
