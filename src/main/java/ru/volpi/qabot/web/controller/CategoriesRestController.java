package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.volpi.qabot.dto.CategoryDto;
import ru.volpi.qabot.exception.CategoryException;
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
        return this.handleCategoryByName(name);
    }
    
    @PutMapping
    public final ResponseEntity<?> createCategory(@RequestBody final CategoryDto registration) {
        return this.handleCreateCategory(registration);
    }

    @PatchMapping("/{id}")
    public final ResponseEntity<?> updateCategoryById(
        @PathVariable final Long id,
        @RequestBody final CategoryDto update
    ) {
        return this.handleUpdateCategoryById(id, update);
    }

    @DeleteMapping("/{id}")
    public final ResponseEntity<?> deleteCategoryById(@PathVariable final Long id) {
        return this.handleDeleteCategoryById(id);
    }

    private ResponseEntity<?> handleCategoryByName(final String name) {
        ResponseEntity<?> result;
        try {
            result = ResponseEntity.ok(this.service.findCategoryByName(name));
        } catch (final CategoryNotFoundException ex) {
            result = ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
        }
        return result;
    }

    private ResponseEntity<?> handleCreateCategory(final CategoryDto registration) {
        ResponseEntity<?> result;
        try {
            result = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.save(registration));
        } catch (final CategoryException ex) {
            result = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
        }
        return result;
    }

    private ResponseEntity<?> handleUpdateCategoryById(final Long id, final CategoryDto update) {
        ResponseEntity<?> result;
        try {
            result = ResponseEntity.ok(this.service.update(id, update));
        } catch (final CategoryException ex) {
            result = ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ex.getMessage());
        }
        return result;
    }

    private ResponseEntity<?> handleDeleteCategoryById(final Long id) {
        ResponseEntity<?> result;
        try {
            result = ResponseEntity.ok(this.service.deleteById(id));
        } catch (final CategoryException ex) {
            result = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
        }
        return result;
    }
}
