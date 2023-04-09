package ru.volpi.qabot.domain.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.volpi.qabot.domain.category.Category;

@Entity
@Table(schema = "questions_storage", name = "questions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Question.class)
    private Category category;

    @Column(name = "question_text")
    private String text;

    @Column(name = "question_answer")
    private String answer;
}
