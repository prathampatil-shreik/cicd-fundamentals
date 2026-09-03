package Ci_Cd_fundamentals.Ci_Cd_fundamentals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void healthEndpointShouldReturnOk() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/health", String.class);
        assertThat(response).isEqualTo("OK");
    }

    @Test
    void homeEndpointShouldReturnMessage() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertThat(response).isEqualTo("Hello from Spring Boot CI/CD Pipeline!");
    }
}
