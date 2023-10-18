package com.br.projeto.controller;

import com.br.projeto.domain.User;
import com.br.projeto.domain.UserEntity;
import com.br.projeto.repository.UserRepository;
import com.br.projeto.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldController {


    public String helloWorld(){
        return "hello world";
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public String register(@RequestBody User user){
        return userService.save(user);
    }


    @PutMapping(value = "/user")
    public Object update(@RequestBody User user){
        return userService.update(user);
    }


    @GetMapping(value = "/user")
    public Object findByName(@RequestParam("name") String name){
        return userService.findByName(name);
    }


    @GetMapping(value = "/user/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }



}
