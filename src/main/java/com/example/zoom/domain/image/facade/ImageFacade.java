package com.example.zoom.domain.image.facade;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.image.domain.Image;
import com.example.zoom.domain.image.domain.repository.ImageRepository;
import com.example.zoom.global.util.aws.s3.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
public class ImageFacade {

    private final ImageRepository imageRepository;
    private final S3Util s3Util;

    public void addImages(Feed feed, List<MultipartFile> images) {
        for(MultipartFile image : images) {
            String fileName = s3Util.upload(image);

            imageRepository.save(Image.builder()
                    .path(fileName)
                    .imageUrl(s3Util.getFileUrl(fileName))
                    .feed(feed)
                    .build());
        }
    }

}
