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
        assertThat(response).isEqualTo("Welcome to my CI/CD Pipeline Project!");
    }

    @Test
    void errorTestEndpointShouldReturn500() {
        try {
            restTemplate.getForObject("http://localhost:" + port + "/error-test", String.class);
        } catch (org.springframework.web.client.HttpServerErrorException e) {
            assertThat(e.getStatusCode().value()).isEqualTo(500);
            assertThat(e.getResponseBodyAsString()).isEqualTo("Test error generated");
        }
    }
}
