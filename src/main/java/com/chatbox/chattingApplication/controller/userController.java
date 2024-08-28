package com.chatbox.chattingApplication.controller;

import com.chatbox.chattingApplication.dto.UserSignupDTO;
import com.chatbox.chattingApplication.model.Users;
import com.chatbox.chattingApplication.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class userController {
    @Autowired
    private UserServiceImpl userService;



    @PostMapping("api/signup")
    public ResponseEntity<String> userDetails( @RequestBody UserSignupDTO userSignupDTO) {
        String result = userService.signup(userSignupDTO);
        if (result.equals("User Inserted")) {
            return ResponseEntity.ok(result);
        } else if (result.equals("Email already exists")) {
            return ResponseEntity.status(409).body(result);
        } else if (result.equals("Passwords do not match")) {
            return ResponseEntity.status(409).body(result);
        } else{
            return ResponseEntity.status(409).body(result);
        }
    }




}
