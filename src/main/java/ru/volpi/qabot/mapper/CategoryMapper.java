package ru.volpi.qabot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.dto.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "questions", ignore = true)
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);
}
