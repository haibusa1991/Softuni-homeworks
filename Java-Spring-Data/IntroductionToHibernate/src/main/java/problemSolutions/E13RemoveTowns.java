package problemSolutions;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class E13RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        List<Employee> employees = em.createQuery("""
                        SELECT e
                        FROM Employee e
                        WHERE e.address.town.name = :town
                        """, Employee.class)
                .setParameter("town", townName)
                .getResultList();

        List<Address> addresses = em.createQuery("""
                        SELECT a
                        FROM Address a
                        WHERE a.town.name = :town
                        """, Address.class)
                .setParameter("town", townName)
                .getResultList();

        Town town;
        try {
            town = em.createQuery("""
                            SELECT t
                            FROM Town t
                            WHERE t.name = :town
                            """, Town.class)
                    .setParameter("town", townName)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.printf("%s does not exist in db.", townName);
            return;
        }

        em.getTransaction().begin();
        try {
            for (Employee e : employees) {
                if (e.getAddress().getTown().getName().equals(townName)) {
                    e.setAddress(null);
                }
            }

            for (Address a : addresses) {
                if (a.getTown().getName().equals(townName)) {
                    em.remove(a);
                }
            }

            em.remove(town);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.getTransaction().commit();

        String formatText =
                addresses.size() > 1 ?
                        "%d addresses in %s deleted" :
                        "%d address in %s deleted";

        System.out.printf(formatText, addresses.size(), townName);
    }
}
