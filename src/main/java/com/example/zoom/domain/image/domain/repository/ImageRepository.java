package com.example.zoom.domain.image.domain.repository;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByFeedById(Feed feedId);
}
