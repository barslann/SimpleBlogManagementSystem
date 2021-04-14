package com.coderman.simpleblogmanagement.service;

import com.coderman.simpleblogmanagement.domain.User;
import com.coderman.simpleblogmanagement.repo.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
public class BlogReactiveUserDetailsService implements ReactiveUserDetailsService {
    private final UserRepository userRepository;

    public BlogReactiveUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // this method finds a user by username, encapsulates the inside of UserDetails and returns it as Mono.
    // Also configure the passwordEncoder to be used.
    @Override
    public Mono<UserDetails> findByUsername(String s) {
        User user = userRepository.findByUsername(s);
        if(user == null){
            return  Mono.empty();
        }
        return Mono.just(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole()))));
    }
}
