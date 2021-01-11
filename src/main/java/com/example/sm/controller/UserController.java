package com.example.sm.controller;

import com.example.sm.exception.ResourceNotFoundException;
import com.example.sm.model.RezervimiRepository;
import com.example.sm.model.UserRepository;
import com.example.sm.model.rezervimi;
import com.example.sm.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository uRepo;

//    @Autowired
//    private RezervimiRepository rRepo;


    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new user());

                return "singup_form";
    }





    @PostMapping("/process_register")
    public String processRegistration(user user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        uRepo.save(user);

        return "register_succes";

    }





    @GetMapping("/list_users")
    public  String  viewUsersList(Model model){

        List<user> listUsers = uRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

}
