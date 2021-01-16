package com.example.sm.controller;

import com.example.sm.CostumUserDetails;
import com.example.sm.model.RezervimiRepository;
import com.example.sm.model.rezervimi;
import com.example.sm.model.user;
import com.example.sm.rezervimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class RezervoController {

    @Autowired
    private RezervimiRepository rRepo;

    @Autowired
    private rezervimiService service;

    @GetMapping("/rezervon")
    public String formaRezervimit(Model model){
        model.addAttribute("rezervimi",new rezervimi());
        return "/Client/indexClient.html";
    }

    @RequestMapping(value = "/procesi_rezervimit", method = RequestMethod.POST)
    public String processRegistration(rezervimi rezervimi){
//        rezervimi.setUserID();
        CostumUserDetails myUserDetails = (CostumUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user user = myUserDetails.getUser();
        rezervimi.setUserID(user);
        rRepo.save(rezervimi);

        return "redirect:/login";
    }

    @GetMapping("/lista_rezervimeve")
    public  String  viewRezervimetList(Model model,@Param("fjalKyqe") String fjalKyqe){

        List<rezervimi> listaRezervimeve = service.listAll(fjalKyqe);
        model.addAttribute("listaRezervimeve", listaRezervimeve);
        model.addAttribute("fjalKyqe",fjalKyqe);

        return "/Admin/listaR.html";

    }

//    @GetMapping("/lista_rezervimeve")
//    public  String  listaRezervimeve(Model model){
//
//        List<rezervimi> listaRezervimeve = rRepo.findAll();
//        model.addAttribute("listaRezervimeve", listaRezervimeve);
//        return "listaR";
//    }
}
