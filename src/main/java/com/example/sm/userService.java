package com.example.sm;

import com.example.sm.model.UserRepository;
import com.example.sm.model.dhoma;
import com.example.sm.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class userService {


    @Autowired
    public UserRepository uRepo;

        public List<user> listAll(String fjalKyqe){
        if(fjalKyqe != null){
            return uRepo.listAll(fjalKyqe);
        }
        return uRepo.findAll();
    }

    public void save(user user) {
        uRepo.save(user);
    }



    public user get(Long id) {
        return uRepo.findById(id).get();
    }

    public void delete(Long id) {
        uRepo.deleteById(id);
    }





}
