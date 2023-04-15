package com.leetcode.util.config;

import com.leetcode.domain.User;
import com.leetcode.dto.GenerateTokenDTO;
import com.leetcode.repository.UserRepository;
import com.leetcode.util.jwt.JWTUtils;
import lombok.NonNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final JWTUtils jwtUtils;

    public UserDetailsServiceImpl(UserRepository userRepository, @Lazy AuthenticationManager authenticationManager, JWTUtils jwtUtils) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        User authUser = userRepository.findByUsername(username)
                .orElseThrow(
                        ()-> new UsernameNotFoundException("User not found " + username)
                );
        return new UserDetailsImpl(authUser);
    }

    public String generateToken(@NonNull GenerateTokenDTO dto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                dto.username(), dto.password()
        );
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (!authentication.isAuthenticated()) {
            throw  new RuntimeException("Bad credentials");
        }
        return jwtUtils.generateToken(Map.of(), loadUserByUsername(dto.username()).authUser());
    }
}
