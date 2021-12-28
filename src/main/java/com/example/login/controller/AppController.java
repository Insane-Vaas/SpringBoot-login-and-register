package com.example.login.controller;

import com.example.login.entity.User;
import com.example.login.entity.Users;
import com.example.login.handler.ResponseHandler;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class AppController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid User user){

        String msg = service.getUser(user);
        if(msg.equals("successful login")) return ResponseHandler.handleResponse(":User logged in Successfully", HttpStatus.OK,msg);

        return ResponseHandler.handleResponse(":Login Attempt Failed", HttpStatus.BAD_REQUEST,msg);


    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid User user){

        String added = service.addUser(user);

        return ResponseHandler.handleResponse("Product added Successfully", HttpStatus.OK,added);


    }

    @RequestMapping("/getusers")
    public Users getUser(){
        List<String> list = service.getAllUsers();

        Users users = new Users(list);

        return users;


    }



}
