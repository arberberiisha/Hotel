package com.example.sm.controller;

import com.example.sm.dhomaService;
import com.example.sm.model.DhomaRepository;
import com.example.sm.model.dhoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class DhomatController {

    @Autowired
    private DhomaRepository dRepo;

    @Autowired
    private dhomaService service;


    @GetMapping("/shtodhomeForm")
    public String shtoDhomeForm(Model model){
        model.addAttribute("dhoma", new dhoma());
        return "/Admin/shto_dhoma.html";
    }


    @GetMapping("/lista_dhomave")
    public  String  viewDhomaList(Model model,@Param("fjalKyqe") String fjalKyqe){

        List<dhoma> dhomaList = service.listAll(fjalKyqe);
        model.addAttribute("dhomaList", dhomaList);
        model.addAttribute("fjalKyqe",fjalKyqe);

            return "/Admin/listaDhomave.html";

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
        model.addAttribute("error", "Dhoma me kete emer egziston!!!");

        return "/Admin/shto_dhoma.html";

    }

    @RequestMapping(value = "/dhomaUpdate", method = RequestMethod.POST)
    public String dhomaUpdate(dhoma dhoma, Model model) {

            dRepo.save(dhoma);
            return "redirect:/lista_dhomave";

    }



    @RequestMapping("/edit/{id}")
    public ModelAndView ndryshoDhomen(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("/Admin/edit_dhoma.html");
        dhoma dhoma = service.get(id);
        mav.addObject("dhoma", dhoma);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String fshijDhomen(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/lista_dhomave";
    }


    @RequestMapping("/dhomatelira")
    public ModelAndView dhomaTeLira(@RequestParam(name = "nga", required = false) String nga,
                              @RequestParam(name = "deri", required = false) String deri) {
        if(nga == null || deri == null ){
            ModelAndView modelAndView =  new ModelAndView("redirect:/rezervon");
            return modelAndView;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        List<dhoma> teLira = dRepo.dhomatTeLira(
                LocalDate.parse(nga, dtf),
                LocalDate.parse(deri, dtf));

        ModelAndView mav = new ModelAndView("Client/indexDhomatELira.html");
        mav.addObject("teLira", teLira);
        return mav;
    }

//    @GetMapping("/dhomat_eLira")
//    public  String  dhomatELira(Model model){
//
//        List<dhoma> dhomaTeLira = service.dhomateLira(LocalDate.of(2020,01,01),LocalDate.of(2022,01,01));
//        model.addAttribute("dhomaTeLira", dhomaTeLira);
//
//
//        return "listaDomaveTeLira";
//
//    }





}
