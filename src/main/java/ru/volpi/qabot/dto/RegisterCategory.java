package ru.volpi.qabot.dto;

import jakarta.validation.constraints.NotNull;

public record RegisterCategory(
    @NotNull(message = "Название категории не может быть пустым") String name
) {
}
