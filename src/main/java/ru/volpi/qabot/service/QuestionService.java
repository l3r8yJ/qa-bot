package ru.volpi.qabot.service;

import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionRegistration;

public interface QuestionService extends CrudService<QuestionDto, Long> {

    void save(QuestionRegistration registration);
}
