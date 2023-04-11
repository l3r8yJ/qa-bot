package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.volpi.qabot.dto.CategoryResponse;

@Service
@RequiredArgsConstructor
public class RestService {

    private static final String CATEGORIES_API = "/categories";

    private final RestTemplate restTemplate;

    public CategoryResponse[] allCategories() {
        return this.restTemplate.getForEntity(RestService.CATEGORIES_API, CategoryResponse[].class).getBody();
    }

}
