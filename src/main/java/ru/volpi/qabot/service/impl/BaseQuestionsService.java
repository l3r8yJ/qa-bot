package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.volpi.qabot.dto.QuestionDto;
import ru.volpi.qabot.mapper.QuestionMapper;
import ru.volpi.qabot.repository.QuestionsRepository;
import ru.volpi.qabot.service.QuestionService;
import ru.volpi.qabot.service.annotation.InternalService;

import java.util.List;

// @TODO: FINISH ME
@Slf4j
@InternalService
@RequiredArgsConstructor
public class BaseQuestionsService implements QuestionService {

    private final QuestionsRepository questionsRepository;

    private final QuestionMapper questionMapper;

    @Override
    public QuestionDto save(final QuestionDto dto) {
        this.questionsRepository.save(this.questionMapper.toEntity(dto));
        return dto;
    }

    @Override
    public QuestionDto update(final Long id, final QuestionDto dto) {
        return null;
    }

    @Override
    public Long deleteById(final Long id) {
        return null;
    }

    @Override
    public QuestionDto findById(final Long id) {
        return null;
    }

    @Override
    public List<QuestionDto> findAll() {
        return null;
    }
}
