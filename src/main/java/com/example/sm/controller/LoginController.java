package com.example.sm.controller;

import com.example.sm.CostumUserDetails;
import com.example.sm.model.dhoma;
import com.example.sm.model.user;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(user user){

        CostumUserDetails myUserDetails = (CostumUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String roli = myUserDetails.getUserRole();

        if(roli.equals("ADMIN")){
            return "/Admin/indexAdmin.html";
        }else {
            return "/Client/indexClient.html";
        }
    }


        @RequestMapping( "/logout")
        public String logout(HttpServletRequest request) {
            SecurityContextHolder.clearContext();
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            return "redirect:/";
        }



}
