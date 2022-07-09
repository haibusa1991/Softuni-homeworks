package problemSolutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class E05EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = entityManagerFactory.createEntityManager();

        List<Employee> employees = em.createQuery("""
                SELECT e
                FROM Employee e
                WHERE e.department.name = :department
                ORDER BY e.salary,e.id
                """,Employee.class)
                .setParameter("department","Research and Development")
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }
    }

}
