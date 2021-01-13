package com.example.sm;

import com.example.sm.model.user;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CostumUserDetails implements UserDetails{

    private user user;


    public CostumUserDetails(user user) {

        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
            return null;
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public user getUser() {
        return user;
    }



    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    public String fullName(){
        return user.getFirstName()+" "+user.getLastName();
    }

}
