package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ru.volpi.qabot.domain.question.Question;
import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionResponse;
import ru.volpi.qabot.exception.question.QuestionNotFoundException;
import ru.volpi.qabot.mapper.QuestionMapper;
import ru.volpi.qabot.repository.QuestionsRepository;
import ru.volpi.qabot.service.QuestionService;
import ru.volpi.qabot.service.annotation.TransactionalService;

import java.util.List;

import static ru.volpi.qabot.service.messages.DebugMessages.*;

@Slf4j
@TransactionalService
@RequiredArgsConstructor
public class BaseQuestionsService implements QuestionService {

    private final QuestionsRepository questionsRepository;

    private final QuestionMapper questionMapper;

    @Transactional
    @Override
    public void save(final QuestionDto dto) {
        this.questionsRepository.save(this.questionMapper.toEntity(dto));
    }

    @Transactional
    @Override
    public void update(final Long id, final QuestionDto dto) {
        final QuestionResponse updated = this.questionsRepository.findById(id).map(
            entity -> {
                final Question question = this.questionMapper.toEntity(dto);
                question.setId(id);
                return question;
            }
        )
            .map(this.questionsRepository::saveAndFlush)
            .map(this.questionMapper::toDto)
            .orElseThrow(() -> new QuestionNotFoundException(id));
        BaseQuestionsService.log.debug(QUESTION_WAS_UPDATED_IN_SERVICE, updated);
    }

    @Transactional
    @Override
    public void deleteById(final Long id) {
        BaseQuestionsService.log.debug(DELETION_CALL_IN_SERVICE, id);
        this.questionsRepository.deleteById(id);
    }

    @Transactional
    @Override
    public QuestionResponse findById(final Long id) {
        BaseQuestionsService.log.debug(FIND_BY_ID_CALL_IN_SERVICE, id);
        return this.questionsRepository.findById(id)
            .map(this.questionMapper::toDto)
            .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    @Transactional
    @Override
    public List<QuestionResponse> findAll() {
        BaseQuestionsService.log.debug(FIND_ALL_IN_SERVICE);
        return this.questionsRepository.findAll()
            .stream()
            .map(this.questionMapper::toDto)
            .toList();
    }
}
