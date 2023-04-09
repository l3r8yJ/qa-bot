package ru.volpi.qabot.exception;

import java.io.Serial;

public class CategoryNotFoundException extends CategoryException {

    @Serial
    private static final long serialVersionUID = 4687513999596619469L;

    public CategoryNotFoundException(final String name) {
        super("Категория с именем '%s' не найдена!".formatted(name));
    }

    public CategoryNotFoundException(final Long id) {
        super("Категория с id '%d' не найдена!".formatted(id));
    }
}
