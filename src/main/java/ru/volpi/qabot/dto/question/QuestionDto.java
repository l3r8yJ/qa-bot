package ru.volpi.qabot.dto.question;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.volpi.qabot.dto.category.CategoryDto;
import ru.volpi.qabot.dto.message.ValidationMessages;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QuestionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6816787385388698692L;

    @Size(min = 10, max = 255, message = ValidationMessages.TEXT_BOUND)
    @NotNull(message = ValidationMessages.QUESTION_TEXT_CANT_BE_EMPTY)
    private String text;

    @Size(min = 10, message = ValidationMessages.ANSWER_BOUND)
    @NotNull(message = ValidationMessages.QUESTION_ANSWER_CANT_BE_EMPTY)
    private String answer;

    @Valid
    private CategoryDto category;
}
