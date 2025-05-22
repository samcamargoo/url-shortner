package com.sam.urlshortner.dtos;

import jakarta.validation.constraints.NotBlank;

public record UrlRequest(@NotBlank String url) {
}
