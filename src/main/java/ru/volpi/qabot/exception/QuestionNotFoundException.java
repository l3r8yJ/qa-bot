package ru.volpi.qabot.exception;

import java.io.Serial;

public class QuestionNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -4393815882511321828L;

    public QuestionNotFoundException(Long id) {
        super("Вопрос с id '%d' не найден!".formatted(id));
    }
}
