package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.dto.CategoryDto;
import ru.volpi.qabot.dto.CategoryName;
import ru.volpi.qabot.dto.QuestionDto;
import ru.volpi.qabot.exception.CategoryNotFoundException;
import ru.volpi.qabot.mapper.CategoryMapper;
import ru.volpi.qabot.repository.CategoriesRepository;
import ru.volpi.qabot.service.CategoriesService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BaseCategoriesService implements CategoriesService {

    private final CategoriesRepository repository;

    private final CategoryMapper mapper;

    @Transactional
    @Override
    public CategoryDto findCategoryByName(final String name) {
        final Optional<Category> found = this.repository.findCategoryByName(name);
        if (found.isEmpty()) {
            throw new CategoryNotFoundException(name);
        }
        return this.mapper.toDto(found.get());
    }

    @Transactional
    @Override
    public CategoryDto save(final CategoryDto dto) {
        this.repository.save(this.mapper.toEntity(dto));
        return dto;
    }

    @Transactional
    @Override
    public CategoryDto update(final Long id, final CategoryDto dto) {
        // @TODO Refactor me
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
            .map(this.mapper::toDto);
    }

    @Transactional
    @Override
    public List<CategoryDto> findAll() {
        return this.repository.findAll()
            .stream()
            .map(this.mapper::toDto)
            .toList();
    }
}
