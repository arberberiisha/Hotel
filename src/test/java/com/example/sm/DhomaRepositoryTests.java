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

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DhomaRepositoryTests {





    @Autowired
    private DhomaRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateDhome(){
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
    public void testFindUserByEmail(){
        String emertimi = "Nr1";

        dhoma dhoma =  repo.findByEmertimi(emertimi);

        assertThat(dhoma).isNotNull();


    }


}
