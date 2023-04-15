package com.leetcode.controller;

import com.leetcode.domain.User;
import com.leetcode.dto.GenerateTokenDTO;
import com.leetcode.dto.UserCreateDTO;
import com.leetcode.repository.UserRepository;
import com.leetcode.util.config.UserDetailsServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class UserController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserDetailsServiceImpl userDetailsServiceImpl,
                          UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/token")
    public String getToken(@RequestBody GenerateTokenDTO dto){
        return userDetailsServiceImpl.generateToken(dto);
    }
    @PostMapping
    public void register(UserCreateDTO dto){
        User user = User.childBuilder()
                .email(dto.email())
                .username(dto.username())
                        .
                password(passwordEncoder.encode(dto.password())).build();
        userRepository.save(user);

    }


//    @GetMapping("login")
//    public String register(){
//
//    }register



}
