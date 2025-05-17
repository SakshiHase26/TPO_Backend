package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.demo.security.JwtRequestFilter;

@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
   http
    .csrf().disable()
    .authorizeHttpRequests()
    .requestMatchers(
        "/api/auth/tpo/register",
        "/api/auth/tpo/login",
        "/api/auth/tpo/**",
        "/api/admin/**"
        
    ).permitAll() // ✅ This now matches your actual controller paths
    .anyRequest().authenticated()
    .and()
    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   return http.build();


}


}
