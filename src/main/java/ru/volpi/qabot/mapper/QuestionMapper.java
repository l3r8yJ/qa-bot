package ru.volpi.qabot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.volpi.qabot.domain.question.Question;
import ru.volpi.qabot.dto.QuestionDto;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question toEntity(QuestionDto questionDto);

    QuestionDto toDto(Question question);

}
