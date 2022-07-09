package E05BillsPaymentSystem;

import E05BillsPaymentSystem.entites.BankAccount;
import E05BillsPaymentSystem.entites.CreditCard;
import E05BillsPaymentSystem.entites.CreditCardType;
import E05BillsPaymentSystem.entites.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Month;
import java.time.Year;

public class E05Main {
    public static void main(String[] args) {

        CreditCard cc1 = new CreditCard("1234 5678 9123 4567", CreditCardType.MASTERCARD, Month.JANUARY, Year.of(2024));
        CreditCard cc2 = new CreditCard("5678 9123 4567 1234", CreditCardType.VISA, Month.DECEMBER, Year.of(2025));
        CreditCard cc3 = new CreditCard("9123 4567 1234 5678", CreditCardType.AMERICAN_EXPRESS, Month.JUNE, Year.of(2022));

        BankAccount ba1 = new BankAccount("12345678900","DSK","01DSK");
        BankAccount ba2 = new BankAccount("45678910111","ExpressBank","03EXB");

        User user1 = new User("Ivan","Ivanov","123TotallySafePass");
        User user2 = new User("Dragan","Draganov","SafeAFpassword");
        User user3 = new User("Petkan","Petkov","PetkanNaTriMoreta!!!");

        user1.addBillingDetail(cc1);
        user1.addBillingDetail(cc2);

        user2.addBillingDetail(cc3);
        user2.addBillingDetail(ba1);

        user3.addBillingDetail(ba2);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateCodeFirst");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        em.persist(cc1);
        em.persist(cc2);
        em.persist(cc3);

        em.persist(ba1);
        em.persist(ba2);

        em.persist(user1);
        em.persist(user2);
        em.persist(user3);

        em.getTransaction().commit();
    }

}
