package ru.volpi.qabot.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import ru.volpi.qabot.web.TestcontainersTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.volpi.qabot.web.controller.util.TestUrls.*;

@AutoConfigureMockMvc
final class CategoriesRestControllerTest extends TestcontainersTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getsAllCategories() throws Exception {
        this.mockMvc.perform(get(CATEGORIES))
            .andExpect(status().is2xxSuccessful());
        assertThat(
            this.mockMvc.perform(get(CATEGORIES))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString()
        ).contains("Test category", "Test text", "Test answer");
    }

    @Test
    void getsCategoryByName() throws Exception {
        assertThat(
            this.mockMvc.perform(get(TEST_CATEGORY))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString()
        ).contains("Test category", "Test text", "Test answer");
    }

    @Test
    void getsNotExistingCategoryByNameCorrectly() throws Exception {
        this.mockMvc.perform(get(NOT_EXISTING_CATEGORY_NAME))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    void putsCategory() throws Exception {
        this.mockMvc.perform(
            put(CATEGORIES)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Added category\"}")
            ).andExpect(status().isCreated()).andDo(print());
    }

    @Test
    void putsExistingCategory() throws Exception {
        this.mockMvc.perform(get(CATEGORIES)).andDo(print());
        this.mockMvc.perform(
            put(CATEGORIES)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Test category \"}")
            ).andExpect(status().isConflict()).andDo(print());
    }

    @Test
    void deletesCategory() throws Exception {
        this.mockMvc.perform(delete(CATEGORY_WITH_ID_102))
            .andExpect(status().isAccepted()).andDo(print());
    }

    @Test
    void deletesNotExistingCategoryCorrectly() throws Exception {
        this.mockMvc.perform(delete(NOT_EXISTING_CATEGORY_ID))
            .andExpect(status().isAccepted()).andDo(print());
    }

    @Test
    void patchesCategory() throws Exception {
        this.mockMvc.perform(
            patch(CATEGORY_WITH_ID_102)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"New name category\"}")
        ).andExpect(status().isAccepted()).andDo(print());
    }

    @Test
    void patchesNotExistingCategoryCorrectly() throws Exception {
        this.mockMvc.perform(
            patch(NOT_EXISTING_CATEGORY_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"New name category\"}")
        ).andExpect(status().isNotFound());
    }
}