package com.example.zoom.domain.user.facade;

import com.example.zoom.domain.user.domain.repository.UserRepository;
import com.example.zoom.domain.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public boolean isAlreadyExists(String email) {
        if(userRepository.findByEmail(email).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
        return true;
    }

    public void existsUseridFilter(String userid) {
        if (userRepository.findByEmail(userid).isPresent())
            throw UserAlreadyExistsException.EXCEPTION;
    }

}
