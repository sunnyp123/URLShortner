package com.example.url.URLShortner.UrlRepository;


import com.example.url.URLShortner.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {
    Url findByShortUrl(String shortUrl);
}