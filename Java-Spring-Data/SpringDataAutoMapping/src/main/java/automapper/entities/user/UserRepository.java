package automapper.entities.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    int countUserByIdGreaterThan(int i);

    User findUserByEmail(String email);

    @Query("""
            SELECT g.title
            FROM User u
            JOIN u.games g
            WHERE u.email = :em
            """)
    List<String> getGamesByEmail(String em);
}
