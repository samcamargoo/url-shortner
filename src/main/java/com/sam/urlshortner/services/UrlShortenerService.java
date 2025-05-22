package com.sam.urlshortner.services;

import com.sam.urlshortner.dtos.UrlRequest;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UrlShortenerService {


    private final Map<String, String> longUrlDatabase;
    private final Map<String, String> shortenedUrlDatabase;

    public UrlShortenerService(Map<String, String> longUrlDatabase, Map<String, String> shortenedUrlDatabase) {
        this.longUrlDatabase = longUrlDatabase;
        this.shortenedUrlDatabase = shortenedUrlDatabase;
    }

    public String shortUrl(UrlRequest request) throws URISyntaxException {
        return generateUrl(request.url());
    }


    public String redirectShortUrl(String shortUrl) {
        String longUrl = shortenedUrlDatabase.get(shortUrl);

        if (longUrl != null) {
            return longUrl;
        }
        throw new IllegalArgumentException("Invalid shortened url");
    }


    private String generateUrl(String longUrl) {

        String formmatedUrl = normalizeUrl(longUrl);
        if (longUrlDatabase.containsKey(formmatedUrl)) {
            return longUrlDatabase.get(formmatedUrl);
        }

        String shortUrl;

        do {
            shortUrl = randomString(8);
        } while (shortenedUrlDatabase.containsKey(shortUrl));


        longUrlDatabase.put(formmatedUrl, shortUrl);
        shortenedUrlDatabase.put(shortUrl, formmatedUrl);
        return shortUrl;
    }

    private String normalizeUrl(String longUrl) {


        if (longUrl == null || longUrl.isBlank()) {
            throw new IllegalArgumentException("Url cannot be null or empty");
        }

        String url = longUrl.trim().toLowerCase();

        url = Normalizer.normalize(url, Normalizer.Form.NFD);
        url = url.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        while (url.length() > 1 && url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        boolean isValidUrl = isValidUrl(url);

        if (!isValidUrl) {
            throw new IllegalArgumentException("url not valid");
        }

        return url;
    }

    private boolean isValidUrl(String normalizedUrl) {
        try {
            URI uri = new URI(normalizedUrl);
            return uri.getScheme() != null && !uri.getScheme().isEmpty();
        } catch (URISyntaxException e) {
            return false;
        }
    }

    private String randomString(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> letterList = new ArrayList<>();

        for (char c : letters.toCharArray()) {
            letterList.add(String.valueOf(c));
        }

        for (int i = 0; i <= size; i++) {
            String letter = letterList.get(random.nextInt(letters.length()));
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

}
