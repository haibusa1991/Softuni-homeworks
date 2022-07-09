package L01vehicleHierarchy;

import L01vehicleHierarchy.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class L01Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateCodeFirst");
        EntityManager em = entityManagerFactory.createEntityManager();

        Car car = new Car(VehicleType.PASSENGER, "fiat tipo", new BigDecimal("35000"), FuelType.GASOLINE, 5);
        Car car2 = new Car(VehicleType.PASSENGER, "tesla", new BigDecimal("55000"), FuelType.ELECTRICITY, 5);
        Bike bike = new Bike(VehicleType.INDIVIDUAL, "some bike", new BigDecimal("500"), FuelType.OTHER);
        Plane plane = new Plane(VehicleType.PASSENGER, "Boeing 747", new BigDecimal("1000000"), FuelType.OTHER, 300);
        Truck truck = new Truck(VehicleType.CARGO, "Man", new BigDecimal("300000"), FuelType.DIESEL, 40000);


        em.getTransaction().begin();

        em.persist(car);
        em.persist(car2);
        em.persist(bike);
        em.persist(plane);
        em.persist(truck);

        em.getTransaction().commit();
    }
}
