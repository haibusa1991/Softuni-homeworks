package E06FootballBettingDatabase.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class E06Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateCodeFirst");
        EntityManager em = entityManagerFactory.createEntityManager();
    }

}
