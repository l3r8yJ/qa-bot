package ru.volpi.qabot.dto;

import jakarta.validation.constraints.NotNull;

public record QuestionText(
    @NotNull(message = "Текст вопроса не может быть пустым") String text
) {
}
