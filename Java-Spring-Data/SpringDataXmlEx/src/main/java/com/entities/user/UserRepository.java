package com.entities.user;

import com.entities.product.ExportSoldProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserById(int id);

    @Query("""
            SELECT u
            FROM User u
            WHERE (SELECT COUNT(p)
                            FROM User u2
                            JOIN u2.listedProducts p
                            WHERE u=u2 AND p.buyer IS NOT NULL )>0
            """)
    List<User> getUsersWithSoldProducts();

}
