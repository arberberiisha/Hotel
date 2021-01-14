package com.example.sm.model;

import com.example.sm.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<user, Long> {

    @Query("SELECT u FROM user u WHERE u.email = ?1")
    user findByEmail(String email);

    @Query("SELECT u FROM user u WHERE u.roli = ?1")
    user findByRole(String role);

    @Query("SELECT u FROM user u WHERE " +
            "concat(u.id,u.firstName,u.lastName,u.email,u.roli)" +
            "LIKE %?1%")
    List<user> listAll(String fjalKyqe);

}
