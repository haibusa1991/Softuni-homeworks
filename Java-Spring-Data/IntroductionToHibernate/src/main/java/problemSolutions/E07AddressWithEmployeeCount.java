package problemSolutions;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class E07AddressWithEmployeeCount {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = entityManagerFactory.createEntityManager();

        List<Address> addresses = em.createQuery("""
                        SELECT a
                        FROM Address a
                        ORDER BY SIZE(a.employees) DESC
                        """, Address.class)
                .setMaxResults(10)
                .getResultList();


        for (Address a : addresses) {
            StringBuilder sb = new StringBuilder(a.getText());

            if (a.getTown() != null) {
                sb.append(", ")
                        .append(a.getTown().getName());
            }

            System.out.printf("%s - %d employees%n", sb, a.getEmployees().size());
        }
    }
}
