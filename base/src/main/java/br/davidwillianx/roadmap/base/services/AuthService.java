package br.davidwillianx.roadmap.base.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mock(username);
    }

    private UserDetails mock(String authUsername) {
        String username = "teste@teste.com";
        String password = "dosomething";

        if (!authUsername.equals(username)) {
            throw new UsernameNotFoundException("Got some error based on user not found");
        }

        return User.builder()
                .username(username)
                .password(password)
                .authorities(authorities())
                .build();
    }

    private List<SimpleGrantedAuthority> authorities() {
        return Collections.emptyList();
    }
}
