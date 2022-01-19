package com.example.lab_2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Value("${app.user}")
    String login;

    @Value("${app.password}")
    String password;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User(login,password,new ArrayList<>());
    }
}
