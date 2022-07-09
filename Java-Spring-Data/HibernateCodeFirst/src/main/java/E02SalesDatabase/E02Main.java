package E02SalesDatabase;

import E02SalesDatabase.entites.Customer;
import E02SalesDatabase.entites.Product;
import E02SalesDatabase.entites.Sale;
import E02SalesDatabase.entites.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class E02Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateCodeFirst");
        EntityManager em = entityManagerFactory.createEntityManager();

        Customer customer1 = new Customer("Ivan", "1234 5678 9123 4567");
        Customer customer2 = new Customer("Dragan", "1234 5678 9123 4567");
        Product product1 = new Product("Cheese", 1, new BigDecimal("12.50"));
        Product product2 = new Product("Milk", 3, new BigDecimal("3.50"));

        StoreLocation location = new StoreLocation("Varna");

        Sale sale1 = new Sale(product1,customer1,location, LocalDate.now());
        Sale sale2 = new Sale(product1,customer2,location, LocalDate.now());
        Sale sale3 = new Sale(product2,customer2,location, LocalDate.now());

        em.getTransaction().begin();

        em.persist(customer1);
        em.persist(customer2);

        em.persist(product1);
        em.persist(product2);

        em.persist(location);

        em.persist(sale1);
        em.persist(sale2);
        em.persist(sale3);

        em.getTransaction().commit();

    }
}
