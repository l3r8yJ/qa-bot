package ru.volpi.qabot.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(final String name) {
        super("Категория с именем '%s' не найдена!".formatted(name));
    }

    public CategoryNotFoundException(final Long id) {
        super("Категория с id '%d' не найдена!".formatted(id));
    }
}
