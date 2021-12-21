package com.example.zoom.global.config;

import com.example.zoom.global.security.jwt.JwtTokenFilter;
import com.example.zoom.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JwtTokenFilter filter = new JwtTokenFilter(jwtTokenProvider);
        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

}
