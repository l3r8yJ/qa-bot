package ru.volpi.qabot.exception.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryWithNameAlreadyExistException extends CategoryException {

    @Serial
    private static final long serialVersionUID = 8636860680912755553L;

    public CategoryWithNameAlreadyExistException(final String name) {
        super("Категория с названием '%s' уже существует!".formatted(name));
    }
}
