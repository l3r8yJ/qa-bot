package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.volpi.qabot.dto.CategoryDto;
import ru.volpi.qabot.service.CategoriesService;
import ru.volpi.qabot.web.controller.message.ControllerMessages;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/vi/categories")
@RequiredArgsConstructor
public class CategoriesRestController {

    private final CategoriesService service;

    @GetMapping
    public final List<CategoryDto> getAll() {
        CategoriesRestController
            .log.debug(ControllerMessages.REQUESTED_ALL_IN_CONTROLLER);
        return this.service.findAll();
    }

    @GetMapping("/{name}")
    public final ResponseEntity<?> getCategoryByName(@PathVariable final String name) {
        CategoriesRestController
            .log.debug(ControllerMessages.REQUESTED_CATEGORY_IN_CONTROLLER, name);
        return this.handleCategoryByName(name);
    }
    
    @PutMapping
    public final ResponseEntity<?> createCategory(@RequestBody final CategoryDto registration) {
        CategoriesRestController
            .log.debug(ControllerMessages.REGISTRATION_IN_CONTROLLER, registration);
        return this.handleCreateCategory(registration);
    }

    @PatchMapping("/{id}")
    public final ResponseEntity<?> updateCategoryById(
        @PathVariable final Long id,
        @RequestBody final CategoryDto update
    ) {
        CategoriesRestController
            .log.debug(ControllerMessages.UPDATE_IN_CONTROLLER, id, update);
        return this.handleUpdateCategoryById(id, update);
    }

    @DeleteMapping("/{id}")
    public final ResponseEntity<?> deleteCategoryById(@PathVariable final Long id) {
        CategoriesRestController
            .log.debug(ControllerMessages.DELETE_IN_CONTROLLER, id);
        return this.handleDeleteCategoryById(id);
    }

    private ResponseEntity<?> handleCategoryByName(final String name) {
        return ResponseEntity.ok(this.service.findCategoryByName(name));
    }

    private ResponseEntity<?> handleCreateCategory(final CategoryDto registration) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(registration));
    }

    private ResponseEntity<?> handleUpdateCategoryById(final Long id, final CategoryDto update) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body(this.service.update(id, update));
    }

    private ResponseEntity<?> handleDeleteCategoryById(final Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body(this.service.deleteById(id));
    }
}
