package problemSolutions;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class E02ChangeCasing {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Town> resultList = em.createQuery("SELECT t from Town t", Town.class).getResultList();

        for (Town town : resultList) {
            if (town.getName().length() <= 5) {
                town.setName(town.getName().toUpperCase());
                em.persist(town);
            }
        }

        em.getTransaction().commit();

    }
}
