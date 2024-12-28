package com.example.url.URLShortner.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Url {

    @Id
    private String shortUrl;
    private String longUrl;

    public Url() {}

    public Url(String shortUrl, String longUrl) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }

    // Getters and Setters
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}

