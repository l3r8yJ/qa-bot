package ru.volpi.qabot.dto.message;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationMessages {
    public static final String CATEGORY_NAME_CANT_BE_EMPTY
        = "Название категории не может быть пустым!";

    public static final String QUESTION_TEXT_CANT_BE_EMPTY
        = "Текст вопроса не может быть пустым!";

    public static final String QUESTION_ANSWER_CANT_BE_EMPTY
        = "Текст ответа не может быть пустым!";

    public static final String TEXT_BOUND
        = "Недопустимый размер вопроса. Минимальный размер вопроса 10 символов, максимальный 255!";

    public static final String ANSWER_BOUND
        = "Недопустимый размер ответа, ответ должен содержать не менее 10 символов!";
}
