package ru.volpi.qabot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import ru.volpi.qabot.dto.message.ValidationMessages;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Value
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6575828891374861627L;

    Long id;

    @NotNull(message = ValidationMessages.CATEGORY_NAME_CANT_BE_EMPTY)
    String name;

    List<QuestionDto> questions;
}
