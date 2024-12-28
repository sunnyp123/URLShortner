package com.example.url.URLShortner.controller;


import com.example.url.URLShortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String longUrl) {
        System.out.println("Received long URL: " + longUrl);  // Log received URL
        if (longUrl == null || longUrl.isEmpty()) {
            System.out.println("URL is empty!");
            return "Invalid URL!";
        }
        try {
            String shortUrl = urlService.generateShortUrl(longUrl);
            System.out.println("Generated Short URL: " + shortUrl);  // Log shortened URL
            return shortUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error shortening URL: " + e.getMessage();
        }
    }


    @GetMapping("/shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        String longUrl = urlService.getLongUrl(shortUrl);
        if (longUrl != null) {
            return "redirect:" + longUrl;
        } else {
            return "URL not found!";
        }
    }
}

