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
            return dRepo.listAll(fjalKyqe);
        }
            return dRepo.findAll();
    }

    public void save(dhoma dhoma) {
        dRepo.save(dhoma);
    }

    public dhoma get(Long id) {
        return dRepo.findById(id).get();
    }

    public void delete(Long id) {
        dRepo.deleteById(id);
    }
}
