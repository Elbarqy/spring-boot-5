package com.example.demo.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
public class JwtGenerator extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public JwtGenerator(AuthenticationManager authenticationManager1, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager1;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ServletInputStream requestStream = request.getInputStream();
            AuthenticationRequest authRequest = new ObjectMapper()
                    .readValue(requestStream, AuthenticationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword()
            );
            Authentication authenticate = authenticationManager.authenticate(authentication);
            System.out.println(authenticate);
            return authenticate;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        SecretKey key = Keys.hmacShaKeyFor("SECRETSECRETSECRETSECRETSECRETSECRETSECRETSECRET".getBytes());
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(key)
                .compact();
        System.out.println(token);
        response.addHeader("Authorization", "Bearer " + token);
//        super.successfulAuthentication(request, response, chain, authResult);
    }
}
