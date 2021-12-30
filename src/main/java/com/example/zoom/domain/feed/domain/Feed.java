package com.example.zoom.domain.feed.domain;

import com.example.zoom.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "zoom_feed")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;


    @Column(length = 1000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private User user;

    private LocalDateTime create_time;
    private LocalDateTime update_time;


    @Builder
    public Feed(String title, String description, User user, LocalDateTime create_time, LocalDateTime update_time) {

        this.title = title;
        this.description = description;
        this.user = user;
        this.create_time = create_time;
        this.update_time = update_time;
    }


}
