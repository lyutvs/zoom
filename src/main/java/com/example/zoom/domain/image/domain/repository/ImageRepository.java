package com.example.zoom.domain.feed.domain.repository;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByFeedById(Feed feedId);
}
