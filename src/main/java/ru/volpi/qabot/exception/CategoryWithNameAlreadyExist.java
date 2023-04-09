package ru.volpi.qabot.exception;

public class CategoryWithNameAlreadyExist extends RuntimeException {
    public CategoryWithNameAlreadyExist(String name) {
        super("Категория с названием '%s' уже существует!".formatted(name));
    }
}
