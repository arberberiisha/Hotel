package com.example.sm;

import com.example.sm.model.RezervimiRepository;
import com.example.sm.model.rezervimi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rezervimiService {

    @Autowired
    public RezervimiRepository rRepo;


    public List<rezervimi> listAll(String fjalKyqe){
        if(fjalKyqe != null){
            return rRepo.listAll(fjalKyqe);
        }
        return rRepo.findAll();
    }

    public void save(rezervimi rezervimi) {
        rRepo.save(rezervimi);
    }

    public rezervimi get(Long id) {
        return rRepo.findById(id).get();
    }

    public void delete(Long id) {
        rRepo.deleteById(id);
    }
}
