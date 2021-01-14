package com.example.sm;

import com.example.sm.model.UserRepository;
import com.example.sm.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CostumUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        user user = repo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Useri nuk u gjet!");
        }
        return new CostumUserDetails(user);
    }



}
