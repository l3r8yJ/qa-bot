package ru.volpi.qabot.domain.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volpi.qabot.domain.question.Question;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "categories_storage", name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
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

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id) + Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        return this.id == ((Category) obj).id && this.name == ((Category) obj).name;
   }

    @Override
    public String toString() {
        return "Category { 'id' = %d, 'name' = %s".formatted(this.id, this.name);
    }
}
