package com.nikhil.maintainanceactivity.service;

import com.nikhil.maintainanceactivity.model.User;
import com.nikhil.maintainanceactivity.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

public class UserService {
@Autowired
    UserRepository userRepository;
@Autowired
    PasswordEncoder passwordEncoder;

    public HttpStatus saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return HttpStatus.OK;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserDetails loadByEmail(String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw  new UsernameNotFoundException("User not found: "+email);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getName(), user.getPassword(), new ArrayList<>()
        );
    }

}
