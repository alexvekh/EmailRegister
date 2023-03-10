package com.boocrun.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

  
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /*  String[] staticResources  =  {
              "/css/**",
              "/images/**",
              "/fonts/**",
              "/scripts/**",
          };*/
    
        http
                .authorizeHttpRequests((requests) -> requests
                                //.requestMatchers(HttpMethod.POST, "/newsub").permitAll()
                                //.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                .requestMatchers("/", "/home", "/newsub", "/confirm", "/images/**").permitAll()
                                .anyRequest().authenticated()
                                
                )
                .formLogin((form) -> form
                                .loginPage("/login")
                                .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
    
    
  
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user =
       User.withDefaultPasswordEncoder()
        .username("admin")
        .password("superuser")
        .roles("USER", "ADMIN")
        .build();

    return new InMemoryUserDetailsManager(user);
  }
  
}
