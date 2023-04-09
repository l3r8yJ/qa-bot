package ru.volpi.qabot.exception;

import java.io.Serial;

public class CategoryWithNameAlreadyExistException extends CategoryException {

    @Serial
    private static final long serialVersionUID = 8636860680912755553L;

    public CategoryWithNameAlreadyExistException(final String name) {
        super("Категория с названием '%s' уже существует!".formatted(name));
    }
}
