package ru.volpi.qabot.domain.category;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import ru.volpi.qabot.domain.question.Question;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(schema = "categories_storage", name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1767598689053486337L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {
        CascadeType.MERGE,
        CascadeType.REMOVE
    })
    @ToString.Exclude
    @Builder.Default
    private Set<Question> questions = new HashSet<>(0);

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        final Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
