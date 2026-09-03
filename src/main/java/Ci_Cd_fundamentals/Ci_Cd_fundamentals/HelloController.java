package Ci_Cd_fundamentals.Ci_Cd_fundamentals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello from Spring Boot CI/CD Pipeline!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
