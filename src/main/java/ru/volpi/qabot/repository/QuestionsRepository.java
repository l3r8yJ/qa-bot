package ru.volpi.qabot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.volpi.qabot.domain.question.Question;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Long> {

    List<Question> getQuestionsByCategoryName(String name);

}
