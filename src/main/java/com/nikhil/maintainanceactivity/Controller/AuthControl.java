package com.nikhil.maintainanceactivity.Controller;

import com.nikhil.maintainanceactivity.dto.*;
import com.nikhil.maintainanceactivity.model.*;
import com.nikhil.maintainanceactivity.service.*;
import com.nikhil.maintainanceactivity.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthControl {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
       HttpStatus status = userService.saveUser(user);
           return ResponseEntity.ok("User Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto user){
        User user1 = userService.findByEmail(user.getEmail());
        if(user1!=null&&jwtUtil.validateToken(user.getPassword())){
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PostMapping("/private")
    @Secured("ROLE_USER")
    public ResponseEntity<String> adminLogic(@RequestBody User user){
        return ResponseEntity.ok("private");
    }
}
