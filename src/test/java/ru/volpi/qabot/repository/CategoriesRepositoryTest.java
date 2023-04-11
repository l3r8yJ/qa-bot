package ru.volpi.qabot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.volpi.qabot.domain.category.Category;
import ru.volpi.qabot.web.TestcontainersTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

final class CategoriesRepositoryTest extends TestcontainersTest {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Test
    void findsAllCategories() {
        assertThat(this.categoriesRepository.findAll()).hasSize(1);
    }

    @Test
    void findsCategoryByName() {
        final Optional<Category> actual = this.categoriesRepository.findCategoryByName("Test category");
        assertThat(actual).isPresent();
        assertThat(actual.get().getQuestions()).hasSize(1);
    }
}