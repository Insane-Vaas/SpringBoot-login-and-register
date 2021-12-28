package com.example.login.service.serviceimp;

import com.example.login.entity.User;
import com.example.login.entity.Users;
import com.example.login.repository.LoginRepository;

import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class UserServiceImp implements UserService {

    @Autowired
    private LoginRepository repo;

    public String addUser(User user){

        repo.save(user);
        return "User added successfully";

    }

    public String getUser(User user){

        for(User user1 : repo.findAll()){

            if(user.getEmail().equals(user1.getEmail())  && user.getPassword().equals(user1.getPassword()))return "successful login";

        }

        return "Please enter valid email or password";

    }

    @Override
    public List<String> getAllUsers() {

        List<String> list = new ArrayList<>();

        for(User user : repo.findAll())list.add(user.getEmail());

        return list;
    }


}
