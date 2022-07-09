package JsonEx.entities.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.security.PublicKey;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserById(int id);

    @Query("""
            SELECT u
            FROM User u
            JOIN u.soldProducts s
            WHERE s.buyer IS NOT NULL
            """)
    Set<User> getAllSales();


    @Query("""
            SELECT u
            FROM User u
            JOIN u.soldProducts p
            WHERE p.size>0
            ORDER BY p.size,u.firstName
                        """)
    Set<User> getUserCountSales();

}
