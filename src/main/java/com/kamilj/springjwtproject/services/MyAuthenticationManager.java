package com.kamilj.springjwtproject.services;

import com.kamilj.springjwtproject.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class MyAuthenticationManager
        implements AuthenticationManager {

    @Autowired
    UserDAO user;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (!((authentication.getPrincipal().equals(user.getUser().getUsername())) && (authentication.getCredentials().equals(user.getUser().getPassword()))))
            throw new BadCredentialsException("");

        return authentication;
    }
}
