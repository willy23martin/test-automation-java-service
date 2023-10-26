package com.test.automation.project.testautomationjavaservicebackend.api.karate;

import com.intuit.karate.junit5.Karate;
import com.test.automation.project.testautomationjavaservicebackend.TestAutomationJavaServiceBackendApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
        classes = TestAutomationJavaServiceBackendApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class IntegrationTests {

    @LocalServerPort
    private String localServerPort;

    @Karate.Test
    public Karate elInventarioContieneUnListadoDeCarrosPrecargados() {
        return karateScenario("el inventario contiene un listado de nueve carros precargados");
    }

    private Karate karateScenario(String scenarioName) {
        return Karate.run()
                .scenarioName(scenarioName)
                .relativeTo(getClass())
                .systemProperty("karate.port", localServerPort)
                .karateEnv("dev");
    }

}
