package com.nikhil.maintainanceactivity.service;

import com.nikhil.maintainanceactivity.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;

public class AuthService {
    @Autowired
    private JwtUtil jwtUtil;

    public Authentication getAuthentication(String token){
        String userName = jwtUtil.extractUserName(token);
        return new UsernamePasswordAuthenticationToken(userName,null,null);
    }

    public boolean validateToken(String token){
        return jwtUtil.validateToken(token);
    }
}
