package com.example.sm.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RezervimiRepository extends JpaRepository<rezervimi, Long> {


    @Query("SELECT r FROM rezervimi r where r.userID.firstName LIKE %?1%")
    List<rezervimi> listAll(String fjalKyqe);



    @Query("SELECT u FROM rezervimi u WHERE u.id = ?1")
    rezervimi findById(int id);


}
