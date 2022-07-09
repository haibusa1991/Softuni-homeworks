package problemSolutions;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class E10IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = emf.createEntityManager();

        List<String> departments = new ArrayList<>() {{
            add("Engineering");
            add("Tool Design");
            add("Marketing");
            add("Information ;Services");
        }};

        List<Employee> employees = new ArrayList<>();

        for (String d : departments) {
            List<Employee> e = em.createQuery("""
                            SELECT e
                            FROM Employee e
                            WHERE e.department.name = :dptName
                            """, Employee.class)
                    .setParameter("dptName", d)
                    .getResultList();

            employees.addAll(e);
        }


        em.getTransaction().begin();
        try {
            for (Employee e : employees) {
                e.setSalary(e.getSalary().multiply(new BigDecimal("1.12")));
                em.persist(e);
                System.out.printf("%s %s ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary());
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.getTransaction().commit();
    }
}
