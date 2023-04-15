package com.leetcode.util.jwt;

import com.leetcode.util.config.UserDetailsImpl;
import com.leetcode.util.config.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final JWTUtils jwtUtils;

    public JWTFilter(UserDetailsServiceImpl userDetailsServiceImpl, JWTUtils jwtUtils) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authorization = request.getHeader(AUTHORIZATION);

        if (Objects.isNull(authorization) || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
        }

        final String token = authorization.substring(7);
        final String username = jwtUtils.extractUsername(token);

        if (username != null) {
            UserDetailsImpl userDetails = userDetailsServiceImpl.loadUserByUsername(username);
            if (jwtUtils.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
                WebAuthenticationDetails webAuthenticationDetails =
                        new WebAuthenticationDetailsSource().buildDetails(request);
                usernamePasswordAuthenticationToken.setDetails(webAuthenticationDetails);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
