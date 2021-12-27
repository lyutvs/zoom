package com.example.zoom.domain.user.domain;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.like.domain.Like;
import com.example.zoom.domain.question.domain.Question;
import com.example.zoom.domain.user.domain.types.Role;
import com.example.zoom.domain.user.presentation.dto.request.LoginRequest;
import com.example.zoom.domain.user.presentation.dto.request.SignUpRequest;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "zoom_user")
public class User implements UserDetails {

    @Id
    @Column(length = 20)
    private String email;

    @Column(length = 4)
    private String nickname;

    @Column(columnDefinition = "char(60)")
    private String password;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 3)
    private String roomNumber;

    @Column(length = 20)
    private String accountNumber;

    private LocalDate blackDate;

    @Builder
    public User(String email, String nickname,
                String roomNumber, String accountNumber, Role role, LocalDate blackDate) {

        this.email = email;
        this.nickname = nickname;
        this.roomNumber = roomNumber;
        this.accountNumber = accountNumber;
        this.role = role;
        this.blackDate = blackDate;

    }

    public User(SignUpRequest request) {
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.nickname = request.getNickname();
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Question> questions = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Like> likes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Feed> feeds = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
