package E01GringottsDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class E01Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateCodeFirst");
        EntityManager em = entityManagerFactory.createEntityManager();
    }
}
