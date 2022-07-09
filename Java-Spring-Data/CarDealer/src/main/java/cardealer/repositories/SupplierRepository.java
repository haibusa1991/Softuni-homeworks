package cardealer.repositories;

import cardealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Supplier getById(int id);

    List<Supplier> getSupplierByUsesImportedParts(boolean b);
}
