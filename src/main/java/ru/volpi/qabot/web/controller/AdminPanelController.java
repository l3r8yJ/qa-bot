package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.volpi.qabot.dto.category.CategoryDto;
import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionRegistration;
import ru.volpi.qabot.service.CategoriesService;
import ru.volpi.qabot.service.QuestionService;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminPanelController {

    private final CategoriesService categoriesService;

    private final QuestionService questionService;

    @GetMapping
    public String index(final Model model) {
        model.addAttribute("categories", this.categoriesService.findAll());
        return "admin";
    }

    @GetMapping("/new-category")
    public String newCategory(final Model model) {
        model.addAttribute("category", new CategoryDto());
        return "category/category";
    }

    @GetMapping("/new-question")
    public String newQuestion(final Model model) {
        final List<CategoryDto> categories = this.categoriesService.findAll();
        model.addAttribute("question", new QuestionRegistration());
        model.addAttribute("categories", categories);
        return "question/question";
    }

    @PutMapping("categories")
    public final String createCategory(@ModelAttribute("category") final CategoryDto created) {
        this.categoriesService.save(created);
        return "redirect:/admin";
    }

    @PutMapping("questions")
    public final String createQuestion(@ModelAttribute("question") final QuestionRegistration registration) {
        this.questionService.save(registration);
        return "redirect:/admin";
    }

    @DeleteMapping("/categories/{id}")
    public final String deleteCategoryById(@PathVariable final Long id) {
        this.categoriesService.deleteById(id);
        return "redirect:/admin";
    }
}
