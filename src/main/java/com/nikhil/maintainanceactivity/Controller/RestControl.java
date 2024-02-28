package com.nikhil.maintainanceactivity.Controller;

import com.nikhil.maintainanceactivity.model.*;
import com.nikhil.maintainanceactivity.service.*;
import com.nikhil.maintainanceactivity.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestControl {
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
    public ResponseEntity<String> login(@RequestBody User user){
        User user1 = userService.findByUserName(user.getName());
        if(user1!=null&&jwtUtil.validateToken(user.getPassword())){

        }
    }
}
