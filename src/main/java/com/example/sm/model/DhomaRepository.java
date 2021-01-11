package com.example.sm.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DhomaRepository extends JpaRepository<dhoma, Long> {


  @Query("SELECT d FROM dhoma d WHERE d.emertimi = ?1" +
          " or d.kati = ?1")
     List<dhoma> listAll(String fjalKyqe);



    @Query("SELECT u FROM dhoma u WHERE u.emertimi = ?1")
    dhoma findByEmertimi(String emertimi);



}
