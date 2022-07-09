package problemSolutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String[] employeeName = scanner.nextLine().split(" ");

        List<Employee> employeeResult = new ArrayList<>();

        switch (employeeName.length) {
            case 2 -> employeeResult = em.createQuery("""
                            SELECT e
                            FROM Employee e
                            WHERE e.firstName = :firstName
                            AND e.lastName = :lastName
                            """, Employee.class)
                    .setParameter("firstName", employeeName[0])
                    .setParameter("lastName", employeeName[1])
                    .setMaxResults(1)
                    .getResultList();

            case 3 -> employeeResult = em.createQuery("""
                            SELECT e
                            FROM Employee e
                            WHERE e.firstName = :firstName
                            AND e.middleName = :middleName
                            AND e.lastName = :lastName
                            """, Employee.class)
                    .setParameter("firstName", employeeName[0])
                    .setParameter("middleName", employeeName[1])
                    .setParameter("lastName", employeeName[2])
                    .setMaxResults(1)
                    .getResultList();
        }
        System.out.println(employeeResult.isEmpty() ? "No" : "Yes");
    }
}
