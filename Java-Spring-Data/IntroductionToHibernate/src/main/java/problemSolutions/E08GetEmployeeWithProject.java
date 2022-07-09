package problemSolutions;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        Employee employee = em.createQuery("""
                        SELECT e
                        FROM Employee e
                        WHERE e.id = :employeeId
                                        """, Employee.class)
                .setParameter("employeeId", id)
                .getSingleResult();

        System.out.printf("%s %s - %s%n", employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        List<Project> projects = employee
                .getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .collect(Collectors.toList());

        projects.forEach(e -> System.out.println(e.getName()));


    }
}
