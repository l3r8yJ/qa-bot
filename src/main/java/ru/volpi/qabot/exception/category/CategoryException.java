package ru.volpi.qabot.exception.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 7678905234637313848L;

    public CategoryException(final String message) {
        super(message);
    }
}
