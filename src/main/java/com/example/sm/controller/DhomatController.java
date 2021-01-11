package com.example.sm.controller;

import com.example.sm.dhomaService;
import com.example.sm.model.DhomaRepository;
import com.example.sm.model.dhoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DhomatController {

    @Autowired
    private DhomaRepository dRepo;

    @Autowired
    private dhomaService service;


    @GetMapping("/shtoDhome")
    public String shtoDhomeForm(Model model){

        model.addAttribute("dhoma",new dhoma());

        return "shto_dhoma";

    }

    @PostMapping("/shtimitTeDhomes")
    public String shtimiDhomes(dhoma dhoma){
        dRepo.save(dhoma);

                return "index";
    }

    @GetMapping("/lista_dhomave")
    public  String  viewDhomaList(Model model){

        String fjalKyqe= "Nr1";
        List<dhoma> dhomaList = dRepo.listAll(fjalKyqe);
        model.addAttribute("dhomaList", dhomaList);

        return "listaDhomave";
    }



}
