package ru.volpi.qabot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.volpi.qabot.domain.question.Question;
import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionRegistration;
import ru.volpi.qabot.dto.question.QuestionResponse;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question toEntity(QuestionDto dto);

    QuestionResponse toResponseDto(Question question);

    QuestionDto toDto(Question question);

    @Mapping(target = "category", ignore = true)
    QuestionDto toDto(QuestionRegistration registration);
}
