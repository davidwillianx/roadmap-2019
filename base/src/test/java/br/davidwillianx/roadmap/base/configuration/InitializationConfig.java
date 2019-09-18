package br.davidwillianx.roadmap.base.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TestConfiguration
public class InitializationConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority admAuthority = new SimpleGrantedAuthority("ADMIN");
        authorities.add(admAuthority);
        User userAdminMock = new User("user@test.com", "password", authorities);
        return new InMemoryUserDetailsManager(userAdminMock);
    }
}
