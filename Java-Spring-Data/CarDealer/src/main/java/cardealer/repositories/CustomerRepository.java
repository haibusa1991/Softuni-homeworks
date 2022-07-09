package cardealer.repositories;

import cardealer.dto.customer.ExportTotalSalesJsonDto;
import cardealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> getCustomerByIdGreaterThanOrderByBirthDateAscIsYoungDriverDesc(int id);

    @Query("""
            SELECT c
            FROM Customer c
            WHERE c.sales.size>0
                         """)
    List<Customer> getAllCustomersWithSales();
}
