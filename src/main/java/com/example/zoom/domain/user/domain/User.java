package com.example.zoom.domain.user.domain;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.like.domain.Like;
import com.example.zoom.domain.question.domain.Question;
import com.example.zoom.domain.user.domain.types.Role;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "zoom_user")
public class User {

    @Id
    @Column(length = 20)
    private String email;

    @Column(length = 4)
    private String name;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 3)
    private String roomNumber;

    @Column(length = 20)
    private String accountNumber;

    @Builder
    public User(String email, String name,
                String roomNumber, String accountNumber) {

        this.email = email;
        this.name = name;
        this.roomNumber = roomNumber;
        this.accountNumber = accountNumber;

    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Question> questions = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Like> likes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Feed> feeds = new HashSet<>();


}
