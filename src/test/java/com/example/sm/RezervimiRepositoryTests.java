package com.example.sm;

import com.example.sm.model.DhomaRepository;
import com.example.sm.model.RezervimiRepository;
import com.example.sm.model.UserRepository;
import com.example.sm.model.rezervimi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RezervimiRepositoryTests {





    @Autowired
    private RezervimiRepository repo;
    @Autowired
    private DhomaRepository dhomaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreaterezervimi(){
        rezervimi rezervimi = new rezervimi();

        rezervimi.setNgaData(LocalDate.of(2021,1,1));
        rezervimi.setDeriMeDaten(LocalDate.of(2021,2,3));
        rezervimi.setDhomaID(dhomaRepository.getOne(5L));
        rezervimi.setUserID(userRepository.getOne(1L));


        rezervimi saved = repo.save(rezervimi);

        rezervimi existrezervimi = entityManager.find(rezervimi.class, saved.getId());

        assertThat(existrezervimi.getId()).isEqualTo(rezervimi.getId());
    }



}
