package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.dto.CategoryDto;
import ru.volpi.qabot.exception.CategoryNotFoundException;
import ru.volpi.qabot.exception.CategoryWithNameAlreadyExistException;
import ru.volpi.qabot.mapper.CategoryMapper;
import ru.volpi.qabot.repository.CategoriesRepository;
import ru.volpi.qabot.service.CategoriesService;

import java.util.List;

import static ru.volpi.qabot.service.messages.DebugMessages.CATEGORY_WAS_SAVED_IN_SERVICE;
import static ru.volpi.qabot.service.messages.DebugMessages.CATEGORY_WAS_UPDATED_IN_SERVICE;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BaseCategoriesService implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    private final CategoryMapper categoryMapper;

    @Transactional
    @Override
    public CategoryDto findCategoryByName(final String name) {
        return this.categoriesRepository.findCategoryByName(name)
            .map(this.categoryMapper::toDto)
            .orElseThrow(() -> new CategoryNotFoundException(name));
    }

    @Transactional
    @Override
    public CategoryDto save(final CategoryDto dto) {
        if (this.categoriesRepository.existsByName(dto.getName())) {
            throw new CategoryWithNameAlreadyExistException(dto.getName());
        }
        final Category category = this.categoryMapper.toEntity(dto);
        this.categoriesRepository.save(category);
        BaseCategoriesService.log.debug(CATEGORY_WAS_SAVED_IN_SERVICE, category);
        return dto;
    }

    @Transactional
    @Override
    public CategoryDto update(final Long id, final CategoryDto dto) {
        final CategoryDto updated = this.categoriesRepository.findById(id).map(
            entity -> {
                final Category category = this.categoryMapper.toEntity(dto);
                category.setId(id);
                return category;
            }
        )
            .map(this.categoriesRepository::saveAndFlush)
            .map(this.categoryMapper::toDto)
            .orElseThrow(() -> new CategoryNotFoundException(id));
        BaseCategoriesService.log.debug(CATEGORY_WAS_UPDATED_IN_SERVICE, updated);
        return updated;
    }

    @Transactional
    @Override
    public Long deleteById(final Long id) {
        this.categoriesRepository.deleteById(id);
        return id;
    }

    @Transactional
    @Override
    public CategoryDto findById(final Long id) {
        return this.categoriesRepository.findById(id)
            .map(this.categoryMapper::toDto)
            .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Transactional
    @Override
    public List<CategoryDto> findAll() {
        return this.categoriesRepository.findAll()
            .stream()
            .map(this.categoryMapper::toDto)
            .toList();
    }
}
