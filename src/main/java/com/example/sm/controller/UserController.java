package com.example.sm.controller;

import com.example.sm.model.UserRepository;
import com.example.sm.model.user;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/")
    public String viewHomePage(){
        return "/Admin/index.html";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new user());

                return "/Client/singup_form.html";
    }


    @PostMapping("/process_register")
    public String processRegistration(user user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        uRepo.save(user);

        return "/Admin/index.html";

    }





    @GetMapping("/list_users")
    public  String  viewUsersList(Model model){

        List<user> listUsers = uRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "/Admin/users.html";
    }



}
