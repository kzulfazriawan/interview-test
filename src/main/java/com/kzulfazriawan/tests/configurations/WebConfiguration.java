package com.kzulfazriawan.tests.configurations;

import com.kzulfazriawan.tests.configurations.CorsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // enable CORS and disable csrf
        httpSecurity = httpSecurity.cors().and().csrf().disable();
        httpSecurity.addFilterBefore(new CorsConfiguration(), BasicAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
