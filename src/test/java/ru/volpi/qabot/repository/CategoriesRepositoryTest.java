package ru.volpi.qabot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.web.TestcontainersTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CategoriesRepositoryTest extends TestcontainersTest {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Test
    void findsAllCategories() {
        assertThat(this.categoriesRepository.findAll()).hasSize(4);
    }

    @Test
    void findsCategoryByName() {
        final Optional<Category> actual = this.categoriesRepository.findCategoryByName("Тестовая категория");
        assertThat(actual).isPresent();
        assertThat(actual.get().getQuestions().get(0).getText()).isEqualTo("Текст тестового вопроса");
    }
}