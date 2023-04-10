package ru.volpi.qabot.exception.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -4393815882511321828L;

    public QuestionNotFoundException(Long id) {
        super("Вопрос с id '%d' не найден!".formatted(id));
    }
}
