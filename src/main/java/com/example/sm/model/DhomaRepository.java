package com.example.sm.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DhomaRepository extends JpaRepository<dhoma, Long> {



  @Query("SELECT d FROM dhoma d WHERE " +
          "concat(d.cmimi,d.emertimi,d.kati,d.nrShtreterve)" +
          "LIKE %?1%")
     List<dhoma> listAll(String fjalKyqe);

    @Query("select d from dhoma d")
    List<dhoma> exist(dhoma dhoma);




    @Query("SELECT u FROM dhoma u WHERE u.emertimi = ?1")
    dhoma findByEmertimi(String emertimi);



}
