package ru.volpi.qabot.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.volpi.qabot.integration.anntotaion.IntegrationTest;

@IntegrationTest
@Sql(value = "classpath:sql/data.sql")
public class TestcontainersTest {

    protected static final PostgreSQLContainer<?> CONTAINER
        = new PostgreSQLContainer<>("postgres:15.1");
    private static final String DATASOURCE_URL_PROPERTY = "spring.datasource.url";
    private static final String DATASOURCE_USERNAME_PROPERTY = "spring.datasource.username";
    private static final String DATASOURCE_PASSWORD_PROPERTY = "spring.datasource.password";

    @BeforeAll
    static void run() {
        TestcontainersTest.CONTAINER.start();
    }

    @DynamicPropertySource
    static void postgresProperties(final DynamicPropertyRegistry registry) {
        registry.add(TestcontainersTest.DATASOURCE_URL_PROPERTY, TestcontainersTest.CONTAINER::getJdbcUrl);
        registry.add(TestcontainersTest.DATASOURCE_USERNAME_PROPERTY, TestcontainersTest.CONTAINER::getUsername);
        registry.add(TestcontainersTest.DATASOURCE_PASSWORD_PROPERTY, TestcontainersTest.CONTAINER::getPassword);
    }
}
