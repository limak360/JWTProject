package com.kamilj.springjwtproject;

import com.kamilj.springjwtproject.model.AuthenticationRequest;
import com.kamilj.springjwtproject.model.AuthenticationResponse;
import com.kamilj.springjwtproject.services.MyAuthenticationManager;
import com.kamilj.springjwtproject.services.MyUserDetailsService;
import com.kamilj.springjwtproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    @Autowired
    private MyAuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/welcome")
    public String hello() {
        return "WelcomePage";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password", e);
        }

        System.out.println(authenticationRequest.getUsername());
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
