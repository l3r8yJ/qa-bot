package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.volpi.qabot.dto.category.CategoryDto;
import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionRegistration;
import ru.volpi.qabot.mapper.QuestionMapper;
import ru.volpi.qabot.service.CategoriesService;
import ru.volpi.qabot.service.QuestionService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminPanelController {

    private final CategoriesService categoriesService;

    private final QuestionService questionService;

    private final QuestionMapper questionMapper;

    @GetMapping
    public final String index(final Model model) {
        model.addAttribute("categories", this.categoriesService.findAll());
        return "admin";
    }

    @GetMapping("/new-category")
    public final String createCategory(final Model model) {
        model.addAttribute("category", new CategoryDto());
        return "category/category";
    }

    @GetMapping("/new-question")
    public final String createQuestion(final Model model) {
        model.addAttribute("question", new QuestionRegistration());
        model.addAttribute("categories", this.categoriesService.findAll());
        return "question/question";
    }

    @GetMapping("/update-category/{id}")
    public final String updateCategory(@PathVariable final Long id, final Model model) {
        model.addAttribute("category", this.categoriesService.findById(id));
        model.addAttribute("categories", this.categoriesService.findAll());
        return "category/category";
    }

    @GetMapping("/update-question/{id}")
    public final String updateQuestion(@PathVariable final Long id, final Model model) {
        model.addAttribute("question", new QuestionDto());
        model.addAttribute("old_question", this.questionService.findById(id));
        model.addAttribute("categories", this.categoriesService.findAll());
        return "question/question";
    }

    @PutMapping("categories")
    public final String createCategory(@ModelAttribute("category") final CategoryDto created) {
        this.categoriesService.save(created);
        return "redirect:/admin";
    }

    @PutMapping("questions")
    public final String createQuestionProcessing(@ModelAttribute("question") final QuestionRegistration registration) {
        final CategoryDto category = this.categoriesService.findCategoryByName(registration.getCategory());
        final QuestionDto question = this.questionMapper.toDto(registration);
        question.setCategory(category);
        this.questionService.save(question);
        return "redirect:/admin";
    }

    @DeleteMapping("/categories/{id}")
    public final String deleteCategoryByIdProcessing(@PathVariable final Long id) {
        this.categoriesService.deleteById(id);
        return "redirect:/admin";
    }

    @DeleteMapping("/questions/{id}")
    public final String deleteQuestionByIdProcessing(@PathVariable final Long id) {
        this.questionService.deleteById(id);
        return "redirect:/admin";
    }

    @PatchMapping("/categories/{id}")
    public final String updateCategoryProcessing(
        @PathVariable final Long id,
        @ModelAttribute("category") final CategoryDto category
    ) {
        this.categoriesService.update(id, category);
        return "redirect:/admin";
    }

    @PatchMapping("/questions/{id}")
    public final String updateQuestionProcessing(
        @PathVariable final Long id,
        @ModelAttribute("question") final QuestionDto category
    ) {
        this.questionService.update(id, category);
        return "redirect:/admin";
    }
}
