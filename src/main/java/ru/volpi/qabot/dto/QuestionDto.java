package ru.volpi.qabot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;

@Data
@Value
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QuestionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1061821276488072983L;

    Long id;

    @NotNull(message = "Текст вопроса не может быть пустым")
    String text;
    @NotNull(message = "Текст ответа не может быть пустым")
    String answer;

    @Valid
    CategoryDto category;

}
