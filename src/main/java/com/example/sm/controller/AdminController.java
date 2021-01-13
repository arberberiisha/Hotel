package com.example.sm.controller;

import com.example.sm.model.UserRepository;
import com.example.sm.model.user;
import com.example.sm.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserRepository uRepo;

    @Autowired
    private userService service;

    @GetMapping("/shto")
    public String formaShtimiTeUserit(Model model){
        model.addAttribute("user",new user());

        return "shtoUser";
    }

    @PostMapping("/procesi_shtimi")
    public String processRegistration(user user, Model model){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        uRepo.save(user);
//
//        return "index";
        //===========================================================//

        user exists = uRepo.findByEmail(user.getEmail());
        if(exists == null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            uRepo.save(user);

            return "index";
        }

        model.addAttribute("user", user);
        model.addAttribute("error", "Useri me kete Email egziston, ju lutem provoni nje Email tjeter.");

        return "shtoUser";

    }

    @GetMapping("/lista_clienteve")
    public  String  viewUserList(Model model,@Param("fjalKyqe") String fjalKyqe){

        List<user> userList = service.listAll(fjalKyqe);
        model.addAttribute("userList", userList);
        model.addAttribute("fjalKyqe",fjalKyqe);

        return "/Admin/users.html";

    }

    @PostMapping("/updateUser")
    public String updateUser(user user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
            uRepo.save(user);
            return "/Admin/index.html";
    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView ndryshimiUserit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("/Admin/edit_user.html");
        user user = service.get(id);
        mav.addObject("user", user);

        return mav;

    }

    @RequestMapping("/deleteUser/{id}")
    public String fshijUserin(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/lista_clienteve";
    }

}