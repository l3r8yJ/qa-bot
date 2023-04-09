package ru.volpi.qabot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Value
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QuestionDto {

    Long id;

    @NotNull(message = "Текст вопроса не может быть пустым")
    String text;
    @NotNull(message = "Текст ответа не может быть пустым")
    String answer;

    @NotNull(message = "Название категории не может быть пустым")
    CategoryName category;

}
