package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.volpi.qabot.dto.CategoryDto;
import ru.volpi.qabot.exception.CategoryNotFoundException;
import ru.volpi.qabot.service.CategoriesService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/vi/categories")
@RequiredArgsConstructor
public class CategoriesRestController {

    private final CategoriesService service;

    @GetMapping
    public final List<CategoryDto> getAll() {
        return this.service.findAll();
    }

    @GetMapping("/{name}")
    public final ResponseEntity<?> getCategoryByName(@PathVariable final String name) {
        try {
            return ResponseEntity.ok(this.service.findCategoryByName(name));
        } catch (final CategoryNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
        }
    }
}
