package problemSolutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class E11FindEmployeesByName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String beginsWith = scanner.nextLine();

        List<Employee> employees = em.createQuery(""" 
                SELECT e
                FROM Employee e
                WHERE e.firstName LIKE :name
                                """,Employee.class)
                .setParameter("name",beginsWith + "%")
                .getResultList();

        for (Employee e : employees) {
            System.out.printf("%s %s - %s - ($%.2f)%n",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getDepartment().getName(),
                    e.getSalary());
        }
    }
}
