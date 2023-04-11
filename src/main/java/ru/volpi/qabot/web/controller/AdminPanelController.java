package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.volpi.qabot.dto.category.CategoryDto;
import ru.volpi.qabot.service.impl.BaseCategoriesService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminPanelController {

    private final BaseCategoriesService categoriesService;

    @GetMapping
    public String index(final Model model) {
        model.addAttribute("categories", this.categoriesService.findAll());
        return "admin";
    }

    @GetMapping("/new-category")
    public String newCategory(final Model model) {
        model.addAttribute("category", new CategoryDto());
        return "category/new-category";
    }

    @PutMapping("categories")
    public final String createCategory(@ModelAttribute("category") final CategoryDto create) {
        this.categoriesService.save(create);
        return "redirect:/admin";
    }

    @DeleteMapping("/categories/{id}")
    public final String deleteCategoryById(@PathVariable final Long id) {
        this.categoriesService.deleteById(id);
        return "redirect:/admin";
    }
}
