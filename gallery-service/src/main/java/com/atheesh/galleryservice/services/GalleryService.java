package com.atheesh.galleryservice.services;

import com.atheesh.galleryservice.entities.Gallery;
import org.springframework.web.bind.annotation.PathVariable;

public interface GalleryService {
    Gallery getById(int id);

}
