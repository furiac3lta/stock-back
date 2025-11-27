package com.marcedev.stock.repository;

import com.marcedev.stock.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username); // ⬅️ AGREGAR ESTO

}
