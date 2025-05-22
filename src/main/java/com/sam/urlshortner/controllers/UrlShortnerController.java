package com.sam.urlshortner.controllers;

import com.sam.urlshortner.dtos.UrlRequest;
import com.sam.urlshortner.services.UrlShortenerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/urls")
public class UrlShortnerController {

    private final UrlShortenerService urlShortenerService;

    public UrlShortnerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping
    public ResponseEntity<Object> createShortenedUrl(@RequestBody UrlRequest request) throws URISyntaxException {
        return ResponseEntity.ok(urlShortenerService.shortUrl(request));
    }


    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> redirectShortUrl(@PathVariable("shortUrl")String shorUrl) {
        String urlToBeRedirect = urlShortenerService.redirectShortUrl(shorUrl);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, urlToBeRedirect)
                .build();
    }
}
