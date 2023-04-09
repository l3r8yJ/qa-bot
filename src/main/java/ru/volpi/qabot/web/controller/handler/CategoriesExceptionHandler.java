package ru.volpi.qabot.web.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.volpi.qabot.exception.CategoryException;
import ru.volpi.qabot.exception.CategoryNotFoundException;
import ru.volpi.qabot.exception.CategoryWithNameAlreadyExistException;

@ControllerAdvice
public class CategoriesExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleCategoryNotFound(final CategoryNotFoundException exc) {
        return CategoriesExceptionHandler.errorResponse(exc, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryWithNameAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<?> handleCategoryNotFound(final CategoryWithNameAlreadyExistException exc) {
        return CategoriesExceptionHandler.errorResponse(exc, HttpStatus.CONFLICT);
    }

    private static ResponseEntity<String> errorResponse(
        final CategoryException exc,
        final HttpStatus status
    ) {
        return ResponseEntity.status(status).body(exc.getMessage());
    }
}
