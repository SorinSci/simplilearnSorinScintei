package com.example.simplilearnSorinScintei.Security;

import com.example.simplilearnSorinScintei.Services.UserServiceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Autowired
    private  UserServiceDao userServiceDao;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserServiceDao userServiceDao) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userServiceDao);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/product/getAll").hasRole("CUSTOMER")
                                .requestMatchers("/product/getAllAdminDashboard").hasRole( "ADMIN")
                                .anyRequest().authenticated())
                .formLogin(form ->
                        form.loginPage("/showLoginPage")
                                .successForwardUrl("/home")
                                .loginProcessingUrl("/authenticateUser")
                                .permitAll())
                .logout(LogoutConfigurer::permitAll);

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
