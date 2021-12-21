package com.example.zoom.global.security.auth;

import com.example.zoom.domain.user.domain.User;
import com.example.zoom.domain.user.domain.repository.UserRepository;
import com.example.zoom.domain.user.exception.BlackException;
import com.example.zoom.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userRepository.findById(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if(user.getBlackDate() != null && user.getBlackDate().isAfter(LocalDate.now()))
            throw new BlackException();
        return user;
    }
}
