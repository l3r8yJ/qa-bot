package ru.volpi.qabot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.volpi.qabot.domain.question.Question;
import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionRegistration;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question toEntity(QuestionDto questionDto);

    @Mapping(target = "category", ignore = true)
    Question toEntity(QuestionRegistration registration);

    QuestionDto toDto(Question question);
}
