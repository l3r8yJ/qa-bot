package ru.volpi.qabot.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryName(
    @NotNull(message = "Имя категории не может быть пустым") String name
) {
}
