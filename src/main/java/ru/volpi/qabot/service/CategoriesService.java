package ru.volpi.qabot.service;

import ru.volpi.qabot.dto.category.CategoryDto;

public interface CategoriesService extends CrudService<CategoryDto, Long> {

    CategoryDto findCategoryByName(String name);

}
