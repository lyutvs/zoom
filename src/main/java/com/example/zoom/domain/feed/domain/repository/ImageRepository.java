package com.example.zoom.domain.feed.domain.repository;

import com.example.zoom.domain.feed.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
