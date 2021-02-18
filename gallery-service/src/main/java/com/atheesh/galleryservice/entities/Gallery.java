package com.atheesh.galleryservice.entities;

import java.util.List;

public class Gallery {

    private int id;
    private List<Object> images;

    public Gallery() {
    }

    public Gallery(int id, List<Object> images) {
        this.id = id;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "id=" + id +
                ", images=" + images +
                '}';
    }
}
