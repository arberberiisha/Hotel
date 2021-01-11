package com.example.sm.controller;

import com.example.sm.dhomaService;
import com.example.sm.exception.ResourceNotFoundException;
import com.example.sm.model.DhomaRepository;
import com.example.sm.model.dhoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class DhomatController {

    @Autowired
    private DhomaRepository dRepo;

    @Autowired
    private dhomaService service;


    @GetMapping("/shtodhomeForm")
    public String shtoDhomeForm(Model model){
        model.addAttribute("dhoma", new dhoma());
        return "shto_dhoma";
    }

//    @PostMapping("/shtohetDhoma")
    @RequestMapping(value = "/shtohetDhoma", method = RequestMethod.POST)
    public String shtimiDhomes(dhoma dhoma, Model model) {
        dhoma exists = dRepo.findByEmertimi(dhoma.getEmertimi());
        if(exists == null){
            dRepo.save(dhoma);
            return "redirect:/lista_dhomave";
        }
        model.addAttribute("dhoma", dhoma);
        model.addAttribute("error", "dhoma me kete emer egziston!!!");

        return "shto_dhoma";

    }
    @GetMapping("/lista_dhomave")
    public  String  viewDhomaList(Model model,@Param("fjalKyqe") String fjalKyqe){

        List<dhoma> dhomaList = service.listAll(fjalKyqe);
        model.addAttribute("dhomaList", dhomaList);
        model.addAttribute("fjalKyqe",fjalKyqe);

            return "listaDhomave";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView ndryshimiDhomes(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_dhoma");
        dhoma dhoma = service.get(id);
        mav.addObject("dhoma", dhoma);

        return mav;

    }

    @RequestMapping("/delete/{id}")
    public String fshijDhomen(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/lista_dhomave";
    }



}
