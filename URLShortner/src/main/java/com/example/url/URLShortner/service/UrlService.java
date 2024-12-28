package com.example.url.URLShortner.service;

import com.example.url.URLShortner.UrlRepository.UrlRepository;
import com.example.url.URLShortner.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static final String BASE_URL = "http://localhost:8080/";

    public String generateShortUrl(String longUrl) {
        String shortUrl = generateRandomString();  // Generate a random short URL
        Url url = new Url(shortUrl, longUrl);
        urlRepository.save(url);  // Save it in the database (in-memory H2 in this case)
        return BASE_URL + shortUrl;  // Return the complete shortened URL
    }

    public String getLongUrl(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl);
        return (url != null) ? url.getLongUrl() : null;
    }

    private String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortUrl.toString();
    }
}

