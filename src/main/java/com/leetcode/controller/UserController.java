package com.leetcode.controller;

import com.leetcode.dto.GenerateTokenDTO;
import com.leetcode.util.config.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class UserController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public UserController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @PostMapping("/token")
    public String getToken(@RequestBody GenerateTokenDTO dto){
        return userDetailsServiceImpl.generateToken(dto);
    }

//    @GetMapping("login")
//    public String register(){
//
//    }register



}
