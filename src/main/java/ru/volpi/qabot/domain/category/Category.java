package ru.volpi.qabot.domain.category;

import jakarta.persistence.*;
import lombok.*;
import ru.volpi.qabot.domain.question.Question;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "categories_storage", name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1767598689053486337L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private List<Question> questions;
}
