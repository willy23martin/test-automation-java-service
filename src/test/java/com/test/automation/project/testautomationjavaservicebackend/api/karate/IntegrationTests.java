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

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaBMW(){
        return karateScenario("searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaBMW");
    }

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaKia(){
        return karateScenario("searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaKia");
    }

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaPorche(){
        return karateScenario("searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaPorche");
    }

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia(){
        return karateScenario("searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia");
    }

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Porche(){
        return karateScenario("searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Porche");
    }

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaKia_Y_Porche(){
        return karateScenario("searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaKia_Y_Porche");
    }

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver9Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia_Y_Porche(){
        return karateScenario("searchCarsByBrands_DebeDevolver9Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia_Y_Porche");
    }

    @Karate.Test
    public Karate searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueNingunaMarca_DadoQuePorDefectoBuscaraLasTresDisponibles(){
        return karateScenario("searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueNingunaMarca_DadoQuePorDefectoBuscaraLasTresDisponibles");
    }

    private Karate karateScenario(String scenarioName) {
        return Karate.run()
                .scenarioName(scenarioName)
                .relativeTo(getClass())
                .systemProperty("karate.port", localServerPort)
                .karateEnv("dev");
    }

}
