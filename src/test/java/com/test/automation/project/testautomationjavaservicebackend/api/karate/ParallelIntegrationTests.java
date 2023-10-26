package com.test.automation.project.testautomationjavaservicebackend.api.karate;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.test.automation.project.testautomationjavaservicebackend.TestAutomationJavaServiceBackendApplication;
import com.test.automation.project.testautomationjavaservicebackend.api.controllers.CarsController;
import com.test.automation.project.testautomationjavaservicebackend.api.database.CarsDAO;
import com.test.automation.project.testautomationjavaservicebackend.api.services.CarsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(
        classes = TestAutomationJavaServiceBackendApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParallelIntegrationTests {

    @Autowired
    CarsController carsController;

    @Autowired
    CarsService carsService;

    @Autowired
    CarsDAO carsDAO;

    @BeforeAll
    void contextValidation(){
        assertNotNull(carsController);
        assertNotNull(carsService);
        assertNotNull(carsDAO);
    }

    @Test
    void testParallel() {
        Results results = Runner
                .path("classpath:com/test/automation/project/testautomationjavaservicebackend/api/karate")
                .parallel(8);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

}
