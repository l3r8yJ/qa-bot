package ru.volpi.qabot.domain.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.volpi.qabot.domain.question.Question;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "categories_storage", name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1767598689053486337L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Question> questions;

}
