package ru.volpi.qabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class QaBotApplication {

    public static void main(final String[] args) {
        SpringApplication.run(QaBotApplication.class, args);
    }
}
