package com.kamilj.springjwtproject.services;

import com.kamilj.springjwtproject.dao.UserDAO;
import com.kamilj.springjwtproject.dao.UserDAOImpl;
import com.kamilj.springjwtproject.model.AuthenticationRequest;
import com.kamilj.springjwtproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
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

        if ((authentication.getPrincipal() != user.getUser().getUsername()) && (authentication.getCredentials() != user.getUser().getPassword())) authentication.setAuthenticated(false);
            return null;
    }
}
