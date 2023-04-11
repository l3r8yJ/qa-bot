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
public class QuestionRegistration implements Serializable {
    @Serial
    private static final long serialVersionUID = -446702966423303522L;

    @Size(min = 10, max = 255, message = ValidationMessages.TEXT_BOUND)
    @NotNull(message = ValidationMessages.QUESTION_TEXT_CANT_BE_EMPTY)
    String text;

    @Size(min = 10, message = ValidationMessages.ANSWER_BOUND)
    @NotNull(message = ValidationMessages.QUESTION_ANSWER_CANT_BE_EMPTY)
    String answer;

    String category;
}
