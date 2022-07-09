package cardealer.repositories;

import cardealer.dto.car.ExportCarJsonDto;
import cardealer.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> getCarByMakeOrderByModelAscTraveledDistanceDesc(String make);

    @Query("""
            SELECT c
            FROM Car c
            """)
    List<Car> getAllCars();
}
