package com.example.zoom.domain.feed.domain.repository;

import com.example.zoom.domain.feed.domain.FeedTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<FeedTag, Long> {
}
