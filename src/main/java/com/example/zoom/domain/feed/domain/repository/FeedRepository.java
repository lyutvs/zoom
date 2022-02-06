package com.example.zoom.domain.feed.domain.repository;

import com.example.zoom.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}
