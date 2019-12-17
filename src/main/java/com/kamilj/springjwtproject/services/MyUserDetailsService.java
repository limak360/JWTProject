package com.kamilj.springjwtproject.services;

import com.kamilj.springjwtproject.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO user;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        return new User(user.getUser().getUsername(),user.getUser().getPassword(), new ArrayList<>());
    }
}
