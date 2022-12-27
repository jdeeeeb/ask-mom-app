package com.jdeeb.askmom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jdeeb.askmom.config.jwt.JwtFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private JwtFilter jwtFilter;
	
	
	//	/api/public/article/all
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeHttpRequests(authorize -> authorize
        		.requestMatchers("/api/auth/*", "/api/public/**").permitAll()
//        		.requestMatchers("/api/auth/login").permitAll()
//        		.requestMatchers("/api/public/**").permitAll()
        		.requestMatchers("/api/user/**", "/api/admin/**", "/api/article/**").authenticated()
        		//.anyRequest().authenticated()
        		.and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        		
        		);
		
		http.cors();
		
		return http.build();
	}
	   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
