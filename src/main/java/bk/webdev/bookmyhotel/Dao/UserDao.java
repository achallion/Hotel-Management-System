package bk.webdev.bookmyhotel.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bk.webdev.bookmyhotel.Model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Query("SELECT user FROM User user WHERE user.email = ?1")
    Optional<User> existsByEmail(String email);
}
