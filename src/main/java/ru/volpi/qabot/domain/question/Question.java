package ru.volpi.qabot.domain.question;

import jakarta.persistence.*;
import lombok.*;
import ru.volpi.qabot.domain.category.Category;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(schema = "questions_storage", name = "questions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Question implements Serializable {

    @Serial
    private static final long serialVersionUID = -8854744102717359228L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String text;

    @Column(name = "question_answer")
    private String answer;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
