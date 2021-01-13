package com.example.sm.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface DhomaRepository extends JpaRepository<dhoma, Long> {



  @Query("SELECT d FROM dhoma d WHERE " +
          "concat(d.cmimi,d.emertimi,d.kati,d.nrShtreterve)" +
          "LIKE %?1%")
     List<dhoma> listAll(String fjalKyqe);

    @Query("SELECT u FROM dhoma u WHERE u.emertimi = ?1")
        dhoma findByEmertimi(String emertimi);


    @Query(value = "SELECT d.* from dhomat d " +
            "where d.id not in (select r.dhoma_id" +
            " from rezervimi r " +
            "where (r.nga_data between ?1 and ?2)" +
            " or (r.deri_me_daten between ?1 and  ?2))",
                nativeQuery = true)
    List<dhoma> dhomatTeLira(LocalDate nga, LocalDate deri);



}
