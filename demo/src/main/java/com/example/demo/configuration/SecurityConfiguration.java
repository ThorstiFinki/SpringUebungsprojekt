package com.example.demo.configuration;

import com.example.demo.rest.filter.CsrfLoggerFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()  // Aktiviert HTTP Basic Authentication
                .and()
                .authorizeRequests()
                .anyRequest().authenticated() // Alle Anfragen müssen authentifiziert sein
                .and()
                .addFilterAfter(new CsrfLoggerFilter(), CsrfFilter.class); // Füge den benutzerdefinierten Filter hinzu

        return http.build();
    }
}