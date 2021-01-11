package com.example.sm;

import com.example.sm.model.DhomaRepository;
import com.example.sm.model.dhoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dhomaService {

    @Autowired
    public DhomaRepository dRepo;

    public List<dhoma> listAll(String fjalKyqe){
        if(fjalKyqe != null){
            dRepo.listAll(fjalKyqe);
        }
        return dRepo.findAll();
    }
}
