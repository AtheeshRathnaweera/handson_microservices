package com.atheesh.galleryservice.services.impl;

import com.atheesh.galleryservice.entities.Gallery;
import com.atheesh.galleryservice.services.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Gallery getById(int id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        // create gallery object
        Gallery gallery = new Gallery();
        gallery.setId(id);

        // get list of available images
        List<Object> images = circuitBreaker.run(() -> restTemplate.getForObject("http://image-service/images/all", List.class),
                throwable -> getDefaultAlbumList());
        gallery.setImages(images);

        return gallery;
    }

    private List<Object> getDefaultAlbumList() {
        return Arrays.asList();
    }
}
