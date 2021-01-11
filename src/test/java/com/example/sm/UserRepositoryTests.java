package com.example.sm;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.sm.model.UserRepository;
import com.example.sm.model.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {





    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        user user = new user();
        user.setEmail("arber@hotmail.com");
        user.setPassword("testtest");
        user.setFirstName("Arber");
        user.setLastName("Berisha");
        user.setRoli("ADMIN");


        user savedUser = repo.save(user);

        user existUser = entityManager.find(user.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "arber@hotmail.com";

       user user =  repo.findByEmail(email);

       assertThat(user).isNotNull();


    }

}
