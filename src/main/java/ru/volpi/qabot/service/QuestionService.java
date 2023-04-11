package ru.volpi.qabot.service;

import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionResponse;

import java.util.List;

public interface QuestionService {

    void save(QuestionDto dto);

    void update(Long id, QuestionDto dto);

    List<QuestionResponse> findAll();

    QuestionResponse findById(Long id);

    void deleteById(Long id);

}
