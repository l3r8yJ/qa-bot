package ru.volpi.qabot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Data
@Value
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryDto implements Serializable {

    Long id;

    @NotNull(message = "Название категории не может быть пустым")
    String name;

    List<QuestionDto> questions;
}
