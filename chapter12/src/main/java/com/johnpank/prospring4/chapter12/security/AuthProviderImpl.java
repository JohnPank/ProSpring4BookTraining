package com.johnpank.prospring4.chapter12.security;

import com.johnpank.prospring4.chapter12.entity.Worker;
import com.johnpank.prospring4.chapter12.service.WorkerService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(AuthProviderImpl.class);

    @Autowired
    WorkerService workerService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        Worker worker = workerService.findByName(name);
        if(worker == null){
            throw new UsernameNotFoundException("Worker not found");
        }
        String password = authentication.getCredentials().toString();
        if(!worker.getPassword().equals(password)){
            throw new BadCredentialsException("Invalid password");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new UsernamePasswordAuthenticationToken(worker, null, authorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
