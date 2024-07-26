package com.yanader.mongodb.controller;

import com.yanader.mongodb.model.User;
import com.yanader.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photoleague/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> userControllerTest() {
        List<User> users = userService.getAllUsers();
        System.out.println("YES THIS DID THIS");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
