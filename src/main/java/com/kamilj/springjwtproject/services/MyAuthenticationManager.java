package com.kamilj.springjwtproject.services;

import com.kamilj.springjwtproject.dao.UserDAOImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyAuthenticationManager
        implements AuthenticationManager {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if ((authentication.getPrincipal() != UserDAOImpl.getName()) && (authentication.getCredentials() != UserDAOImpl.getPassword())) authentication.setAuthenticated(false);
            return null;
    }
}
