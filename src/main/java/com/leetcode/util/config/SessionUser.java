package com.leetcode.util.config;

import com.leetcode.domain.User;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SessionUser {
    public Long getId() {
        //return new Random().nextLong(1, 20);
        return this.getId();
    }
}