package problemSolutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class E04EmployeesWithSalaryOver50K {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = entityManagerFactory.createEntityManager();

        List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.salary>50000", Employee.class).getResultList();

        for (Employee e : employees) {
            System.out.println(e.getFirstName());
        }
    }
}
