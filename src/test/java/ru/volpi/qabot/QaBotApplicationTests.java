package ru.volpi.qabot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.volpi.qabot.web.TestcontainersTest;

@AutoConfigureMockMvc
class QaBotApplicationTests extends TestcontainersTest {

    @Test
    void contextLoads() {
    }
}
