package com.leetcode;

import com.leetcode.domain.User;
import com.leetcode.repository.UserRepository;
import com.leetcode.service.UserService;
import com.leetcode.util.config.SessionUser;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.leetcode.repository")
@OpenAPIDefinition
@RequiredArgsConstructor
public class Main {
    private final SessionUser sessionUser;
    private final UserService userService;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
//    @Bean
//    CommandLineRunner runner(){
//        return args -> {
//          userRepository.save(User.childBuilder()
//                          .name("nodiracan")
//                          .username("nodiracan")
//                          .email("nodiracan@gmaiul.com")
//                          .password("111")
//                  .build());
//        };
//    }
    @Bean
    public AuditorAware<Integer> auditorAware() {
        return () -> Optional.of(1);
    }
}