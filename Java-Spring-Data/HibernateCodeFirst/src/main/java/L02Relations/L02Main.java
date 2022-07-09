package L02Relations;

import L01vehicleHierarchy.entities.*;
import L02Relations.entities.Company;
import L02Relations.entities.Driver;
import L02Relations.entities.PlateNumber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class L02Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateCodeFirst");
        EntityManager em = entityManagerFactory.createEntityManager();

//        PlateNumber plateNumber = new PlateNumber("B 1111 BB");
//        Car car = new Car(VehicleType.PASSENGER, "fiat tipo", new BigDecimal("35000"), FuelType.GASOLINE, 5);
//        car.setPlateNumber(plateNumber);
//
//
//        Plane plane1 = new Plane(VehicleType.PASSENGER, "Boeing 747", new BigDecimal("1000000"), FuelType.OTHER, 300);
//        Plane plane2 = new Plane(VehicleType.INDIVIDUAL, "Chesna", new BigDecimal("100000"), FuelType.OTHER, 2);
//        Plane plane3 = new Plane(VehicleType.CARGO, "Antonov", new BigDecimal("500000"), FuelType.OTHER, 4);
//
//        Company company = new Company("BG Planes");
//
//        company.getPlanes().add(plane1);
//        company.getPlanes().add(plane2);
//        company.getPlanes().add(plane3);


        Truck truck1 = new Truck(VehicleType.CARGO, "Man", new BigDecimal("300000"), FuelType.DIESEL, 40000);
        Truck truck2 = new Truck(VehicleType.CARGO, "Volvo", new BigDecimal("400000"), FuelType.DIESEL, 30000);

        Driver driver1 = new Driver("Ivan");
        Driver driver2 = new Driver("Dragan");
        Driver driver3 = new Driver("Petkan");
        Driver driver4 = new Driver("Trifon");

        truck1.getDrivers().add(driver1);
        truck1.getDrivers().add(driver2);
        truck1.getDrivers().add(driver3);

        truck2.getDrivers().add(driver3);
        truck2.getDrivers().add(driver4);

        em.getTransaction().begin();
//
//        em.persist(plane1);
//        em.persist(plane2);
//        em.persist(plane3);
//
//        em.persist(company);

        em.persist(driver1);
        em.persist(driver2);
        em.persist(driver3);
        em.persist(driver4);

        em.persist(truck1);
        em.persist(truck2);

        em.getTransaction().commit();
    }
}
