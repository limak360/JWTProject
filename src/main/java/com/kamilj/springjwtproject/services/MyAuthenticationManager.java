package com.kamilj.springjwtproject.services;

import com.kamilj.springjwtproject.dao.UserDAO;
import com.kamilj.springjwtproject.dao.UserDAOImpl;
import com.kamilj.springjwtproject.model.AuthenticationRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class MyAuthenticationManager
        implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserDAO userDAO = new UserDAOImpl();
        AuthenticationRequest request = new AuthenticationRequest();

        if ((authentication.getPrincipal() != request.getUsername()) && (authentication.getCredentials() != request.getPassword())) authentication.setAuthenticated(false);
            return null;
    }
}
