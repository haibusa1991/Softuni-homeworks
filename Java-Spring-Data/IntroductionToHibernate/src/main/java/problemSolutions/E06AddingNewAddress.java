package problemSolutions;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class E06AddingNewAddress {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String employeeLastName = scanner.nextLine();

        Employee e = em.createQuery("""
                        SELECT e
                        FROM Employee e
                        WHERE e.lastName = :lastName
                        """, Employee.class)
                .setParameter("lastName", employeeLastName)
                .getSingleResult();

        Address address = new Address();
        address.setText("Vitoshka 15");

        em.getTransaction().begin();

        em.persist(address);

        e.setAddress(address);
        em.persist(e);

        em.getTransaction().commit();

    }
}
