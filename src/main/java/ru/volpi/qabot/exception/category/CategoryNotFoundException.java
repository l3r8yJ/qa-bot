package ru.volpi.qabot.exception.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
