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

    @Karate.Test
    public Karate searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroNoSuperaLos100Millones(){
        return karateScenario("searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroNoSuperaLos100Millones");
    }

    @Karate.Test
    public Karate searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroEstribaEntre100MillonesY200Millones(){
        return karateScenario("searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroEstribaEntre100MillonesY200Millones");
    }

     @Karate.Test
     public Karate searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroSupereLos200Millones(){
        return karateScenario("searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroSupereLos200Millones");
     }

     @Karate.Test
     public Karate searchCarsByPriceRange_DebeRetornarUnaListaCon6Carros_CuandoElPrecioDelCarroSupereLos100Millones(){
        return karateScenario("searchCarsByPriceRange_DebeRetornarUnaListaCon6Carros_CuandoElPrecioDelCarroSupereLos100Millones");
     }

     @Karate.Test
     public Karate searchCarsByPriceRange_DebeRetornarUnaListaVacia_CuandoElPrecioDelCarroSeaInferiorA50Millones(){
        return karateScenario("searchCarsByPriceRange_DebeRetornarUnaListaVacia_CuandoElPrecioDelCarroSeaInferiorA50Millones");
     }

     @Karate.Test
     public Karate searchCarsByPriceRange_DebeRetornarUnaListaCon9Carros_CuandoElPrecioDelCarroSupereLos50Millones(){
        return karateScenario("searchCarsByPriceRange_DebeRetornarUnaListaCon9Carros_CuandoElPrecioDelCarroSupereLos50Millones");
     }

    private Karate karateScenario(String scenarioName) {
        return Karate.run()
                .scenarioName(scenarioName)
                .relativeTo(getClass())
                .systemProperty("karate.port", localServerPort)
                .karateEnv("dev");
    }

}
