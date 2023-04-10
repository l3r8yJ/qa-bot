package ru.volpi.qabot.web.controller;

import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import ru.volpi.qabot.web.TestcontainersTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.volpi.qabot.web.controller.util.TestUrls.CATEGORIES_URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
class CategoriesRestControllerTest extends TestcontainersTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test to get all categories")
    void getsAllCategories() throws Exception {
        this.mockMvc.perform(get(CATEGORIES_URL))
            .andExpect(status().is2xxSuccessful());
    }

}