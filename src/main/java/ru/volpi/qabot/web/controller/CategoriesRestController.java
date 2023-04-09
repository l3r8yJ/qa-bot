package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.volpi.qabot.dto.CategoryName;
import ru.volpi.qabot.service.CategoriesService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/vi/categories")
@RequiredArgsConstructor
public class CategoriesRestController {

    private final CategoriesService service;

    @GetMapping
    public List<CategoryName> getAll() {
        return this.service.allCategories();
    }
}
