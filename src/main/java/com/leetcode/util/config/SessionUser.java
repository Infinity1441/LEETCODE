package com.leetcode.util.config;

import com.leetcode.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SessionUser {
    public User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object authUserDetails = authentication.getPrincipal();
        if (authUserDetails instanceof UserDetailsImpl userDetails)
            return userDetails.getUser();
        return null;
    }

    public Integer getId() {
        User user = getUser();
        if (user != null)
            return user.getId();
        return null;
    }
}