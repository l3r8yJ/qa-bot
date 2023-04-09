package ru.volpi.qabot.dto;

import jakarta.validation.constraints.NotNull;

public record RegisterQuestion(
    @NotNull(message = "Текст вопроса не может быть пустым") String text,
    @NotNull(message = "Текст ответа не может быть пустым") String answer,
    @NotNull(message = "Название категории не может быть пустым") CategoryName category
) {
}
