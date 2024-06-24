package com.manaCoulby.gestionTicket.Config;

import com.manaCoulby.gestionTicket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiuration {
    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return
        httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests( registry-> {
           registry.requestMatchers("user/**").permitAll();
           registry.requestMatchers("/base/**", "/ticket/**", "/categorie/**", "/prioriter/**",
                   "/statut/**").hasRole("ADMIN");
           registry.requestMatchers("/base/**","/reponse/**", "ticket/**", "statut/**").hasRole("FORMATEUR");
           registry.requestMatchers("/base/liste", "ticket/**").hasRole("APPRENANT");
           registry.anyRequest().authenticated();
        })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails normaluser = User.builder()
//                .username("root")
//                .password("$2a$12$1BKqagA5go2BxiOR6YURGeiDhImdzjXQmS3U1goSLGGlzYH52GiRa")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(normaluser);
//    }



    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
