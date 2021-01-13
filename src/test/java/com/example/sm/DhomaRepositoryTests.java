package com.example.sm;

import com.example.sm.model.DhomaRepository;
import com.example.sm.model.dhoma;
import com.example.sm.model.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.Query;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DhomaRepositoryTests {


    @Autowired
    private DhomaRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateDhome() {
        dhoma dhoma = new dhoma();
        dhoma.setEmertimi("Nr.1");
        dhoma.setNrShtreterve(2);
        dhoma.setKati(2);
        dhoma.setCmimi(25.0);


        dhoma savedUser = repo.save(dhoma);

        dhoma existUser = entityManager.find(dhoma.class, savedUser.getId());

        assertThat(existUser.getEmertimi()).isEqualTo(dhoma.getEmertimi());
    }


    @Test
    public void testFindUserByEmail() {
        String emertimi = "Nr1";

        dhoma dhoma = repo.findByEmertimi(emertimi);

        assertThat(dhoma).isNotNull();

        System.out.println(dhoma.getEmertimi());
    }

    @Test
    public void testGjejDhomatELira() {
        List<dhoma> dhomaList = repo.dhomatTeLira(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 5));
        //a pi kthen mir query e kom testu qit query mir o
        //veq tash kallzom qysh me thirr atje kur ta qet useri daten
        assertThat(dhomaList).isNotNull();
        System.out.println(dhomaList);

    }
}