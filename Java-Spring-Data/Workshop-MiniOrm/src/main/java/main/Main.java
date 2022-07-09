package main;

import entities.User;
import orm.EntityManager;
import orm.MyConnector;
import orm.PasswordHandler;

import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    private final static String DB_NAME = "mini_orm";

    public static void main(String[] args) throws SQLException, InvalidKeySpecException, IllegalAccessException {
        User testUser = new User("Haibusa2005", PasswordHandler.encodePassword("#sUperSeKret_P@ssWort"), 31, LocalDate.now());
        User testUser2 = new User("Haibusa2005-updated", PasswordHandler.encodePassword("#sUperSeKret_P@ssWort"), 31, LocalDate.now());
        testUser2.setId(6000);

        Connection c = MyConnector.getInstance().setConnection(DB_NAME);
        EntityManager em = new EntityManager(c);

        System.out.println("insert successful: " + em.persist(testUser));
        System.out.println("update successful: " + em.persist(testUser2));

    }


}
