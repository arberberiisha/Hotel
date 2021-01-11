package com.example.sm.controller;

import com.example.sm.model.RezervimiRepository;
import com.example.sm.model.rezervimi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RezervoController {

    @Autowired
    private RezervimiRepository rRepo;


    @GetMapping("/rezervon")
    public String formaRezervimit(Model model){
        model.addAttribute("rezervimi",new rezervimi());

        return "rezervimi";
    }
    @RequestMapping(value = "/procesi_rezervimit", method = RequestMethod.POST)
    public String processRegistration(rezervimi rezervimi){
        rRepo.save(rezervimi);

        return "index";
    }

    @GetMapping("/lista_rezervimeve")
    public  String  listaRezervimeve(Model model){

        List<rezervimi> listaRezervimeve = rRepo.findAll();
        model.addAttribute("listaRezervimeve", listaRezervimeve);
        return "listaR";
    }
}
