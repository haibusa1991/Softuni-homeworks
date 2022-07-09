package cardealer.repositories;

import cardealer.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("""
            SELECT s
            FROM Sale s
            """)
    List<Sale> getAllSales();
}
