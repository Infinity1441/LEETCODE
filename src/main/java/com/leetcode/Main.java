package com.leetcode;

import com.leetcode.util.config.SessionUser;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition
@RequiredArgsConstructor
public class Main {
    private final SessionUser sessionUser;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(sessionUser.getId());
    }
}