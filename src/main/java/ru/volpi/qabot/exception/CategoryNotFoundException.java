package ru.volpi.qabot.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(final String name) {
        super("Категория с именем '%s' не найдена!".formatted(name));
    }
}
