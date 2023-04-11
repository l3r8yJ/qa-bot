package ru.volpi.qabot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.domain.question.Question;
import ru.volpi.qabot.dto.question.QuestionDto;
import ru.volpi.qabot.dto.question.QuestionRegistration;
import ru.volpi.qabot.exception.category.CategoryNotFoundException;
import ru.volpi.qabot.exception.question.QuestionNotFoundException;
import ru.volpi.qabot.mapper.CategoryMapper;
import ru.volpi.qabot.mapper.QuestionMapper;
import ru.volpi.qabot.repository.CategoriesRepository;
import ru.volpi.qabot.repository.QuestionsRepository;
import ru.volpi.qabot.service.QuestionService;
import ru.volpi.qabot.service.annotation.TransactionalService;

import java.util.List;
import java.util.Optional;

import static ru.volpi.qabot.service.messages.DebugMessages.*;

@Slf4j
@TransactionalService
@RequiredArgsConstructor
public class BaseQuestionsService implements QuestionService {

    private final QuestionsRepository questionsRepository;

    private final CategoriesRepository categoriesRepository;

    private final QuestionMapper questionMapper;

    @Transactional
    @Override
    public QuestionDto save(final QuestionDto dto) {
        this.questionsRepository.save(this.questionMapper.toEntity(dto));
        return dto;
    }

    @Transactional
    @Override
    public void save(final QuestionRegistration registration) {
        this.categoriesRepository.findCategoryByName(registration.getCategory())
            .ifPresent(foundCategory -> {
                    final Question question = this.questionMapper.toEntity(registration);
                    question.setCategory(foundCategory);
                    this.questionsRepository.save(question);
            });
    }

    @Transactional
    @Override
    public QuestionDto update(final Long id, final QuestionDto dto) {
        final QuestionDto updated = this.questionsRepository.findById(id).map(
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
        return updated;
    }

    @Transactional
    @Override
    public Long deleteById(final Long id) {
        BaseQuestionsService.log.debug(DELETION_CALL_IN_SERVICE, id);
        this.questionsRepository.deleteById(id);
        return id;
    }

    @Transactional
    @Override
    public QuestionDto findById(final Long id) {
        BaseQuestionsService.log.debug(FIND_BY_ID_CALL_IN_SERVICE, id);
        return this.questionsRepository.findById(id)
            .map(this.questionMapper::toDto)
            .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    @Transactional
    @Override
    public List<QuestionDto> findAll() {
        BaseQuestionsService.log.debug(FIND_ALL_IN_SERVICE);
        return this.questionsRepository.findAll()
            .stream()
            .map(this.questionMapper::toDto)
            .toList();
    }
}
