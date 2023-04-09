package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.dto.CategoryDto;
import ru.volpi.qabot.dto.CategoryName;
import ru.volpi.qabot.dto.QuestionDto;
import ru.volpi.qabot.exception.CategoryNotFoundException;
import ru.volpi.qabot.repository.CategoriesRepository;
import ru.volpi.qabot.service.CategoriesService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BaseCategoriesService implements CategoriesService {

    private final CategoriesRepository repository;

    @Transactional
    @Override
    public CategoryDto findCategoryByName(final String name) {
        final Optional<Category> found = this.repository.findCategoryByName(name);
        if (found.isPresent()) {
            return CategoryDto.builder()
                .id(found.get().getId())
                .name(found.get().getName())
                .questions(
                    found.get().getQuestions().stream().map(
                        question -> QuestionDto.builder()
                            .text(question.getText())
                            .answer(question.getAnswer())
                            .category(new CategoryName(found.get().getName()))
                            .build()
                    ).toList()
                )
                .build();
        }
        throw new CategoryNotFoundException(name);
    }

    @Transactional
    @Override
    public CategoryDto save(final CategoryDto dto) {
        this.repository.save(
            Category.builder()
                .name(dto.getName())
                .build()
        );
        return dto;
    }

    @Transactional
    @Override
    public CategoryDto update(final Long id, final CategoryDto dto) {
        this.repository.save(
            Category.builder()
                .id(id)
                .name(dto.getName())
                .build()
        );
        return dto;
    }

    @Transactional
    @Override
    public Long deleteById(final Long id) {
        this.repository.deleteById(id);
        return id;
    }

    @Transactional
    @Override
    public Optional<CategoryDto> findById(final Long id) {
        return this.repository.findById(id)
            .map(
                category -> CategoryDto.builder().name(category.getName()).build()
            );
    }

    @Transactional
    @Override
    public List<CategoryDto> findAll() {
        return this.repository.findAll().stream().map(
            category -> CategoryDto.builder().name(category.getName()).build()
        ).toList();
    }
}
