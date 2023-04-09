package ru.volpi.qabot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volpi.qabot.dto.CategoryName;
import ru.volpi.qabot.repository.CategoriesRepository;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CategoriesService {

    private final CategoriesRepository repository;

    public List<CategoryName> allCategories() {
        return this.repository.findAll()
            .stream()
            .map(category -> new CategoryName(category.getName()))
            .toList();
    }
}
