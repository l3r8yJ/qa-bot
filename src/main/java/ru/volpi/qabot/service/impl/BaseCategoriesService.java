package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.dto.CategoryDto;
import ru.volpi.qabot.exception.CategoryNotFoundException;
import ru.volpi.qabot.exception.CategoryWithNameAlreadyExist;
import ru.volpi.qabot.mapper.CategoryMapper;
import ru.volpi.qabot.repository.CategoriesRepository;
import ru.volpi.qabot.service.CategoriesService;

import java.util.List;
import java.util.Optional;

import static ru.volpi.qabot.service.messages.DebugMessages.CATEGORY_WAS_SAVED_IN_SERVICE;
import static ru.volpi.qabot.service.messages.DebugMessages.CATEGORY_WAS_UPDATED_IN_SERVICE;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BaseCategoriesService implements CategoriesService {

    private final CategoriesRepository repository;

    private final CategoryMapper mapper;

    @Transactional
    @Override
    public CategoryDto findCategoryByName(final String name) {
        return this.repository.findCategoryByName(name)
            .map(this.mapper::toDto)
            .orElseThrow(() -> new CategoryNotFoundException(name));
    }

    @Transactional
    @Override
    public CategoryDto save(final CategoryDto dto) {
        if (this.repository.existsByName(dto.getName())) {
            throw new CategoryWithNameAlreadyExist(dto.getName());
        }
        final Category category = this.mapper.toEntity(dto);
        this.repository.save(category);
        BaseCategoriesService.log.debug(CATEGORY_WAS_SAVED_IN_SERVICE, category);
        return dto;
    }

    @Transactional
    @Override
    public CategoryDto update(final Long id, final CategoryDto dto) {
        final CategoryDto updated = this.repository.findById(id).map(
            entity -> {
                final Category category = this.mapper.toEntity(dto);
                category.setId(id);
                return category;
            }
        )
            .map(this.repository::saveAndFlush)
            .map(this.mapper::toDto)
            .orElseThrow(() -> new CategoryNotFoundException(id));
        BaseCategoriesService.log.debug(CATEGORY_WAS_UPDATED_IN_SERVICE, updated);
        return updated;
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
