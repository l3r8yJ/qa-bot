package ru.volpi.qabot.dto.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.message.ValidationMessages;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6575828891374861627L;

    private Long id;

    @NotNull(message = ValidationMessages.CATEGORY_NAME_CANT_BE_EMPTY)
    private String name;

    @Builder.Default
    private Set<QuestionDto> questions = new HashSet<>(0);
}
