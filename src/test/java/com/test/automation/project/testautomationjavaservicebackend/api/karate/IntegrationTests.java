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
    public Karate EPCARS001_elInventarioContieneUnListadoDeCarrosPrecargados() {
        return karateScenario("EPCARS001 el inventario contiene un listado de nueve carros precargados");
    }

    @Karate.Test
    public Karate EPSEARCHP001_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroNoSuperaLos100Millones(){
        return karateScenario("EPSEARCHP001_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroNoSuperaLos100Millones");
    }

    @Karate.Test
    public Karate EPSEARCHP002_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroEstribaEntre100MillonesY200Millones(){
        return karateScenario("EPSEARCHP002_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroEstribaEntre100MillonesY200Millones");
    }

     @Karate.Test
     public Karate EPSEARCHP003_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroSupereLos200Millones(){
        return karateScenario("EPSEARCHP003_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroSupereLos200Millones");
     }

     @Karate.Test
     public Karate EPSEARCHP004_searchCarsByPriceRange_DebeRetornarUnaListaCon6Carros_CuandoElPrecioDelCarroSupereLos100Millones(){
        return karateScenario("EPSEARCHP004_searchCarsByPriceRange_DebeRetornarUnaListaCon6Carros_CuandoElPrecioDelCarroSupereLos100Millones");
     }

     @Karate.Test
     public Karate EPSEARCHP005_searchCarsByPriceRange_DebeRetornarUnaListaVacia_CuandoElPrecioDelCarroSeaInferiorA50Millones(){
        return karateScenario("EPSEARCHP005_searchCarsByPriceRange_DebeRetornarUnaListaVacia_CuandoElPrecioDelCarroSeaInferiorA50Millones");
     }

     @Karate.Test
     public Karate EPSEARCHP006_searchCarsByPriceRange_DebeRetornarUnaListaCon9Carros_CuandoElPrecioDelCarroSupereLos50Millones(){
        return karateScenario("EPSEARCHP006_searchCarsByPriceRange_DebeRetornarUnaListaCon9Carros_CuandoElPrecioDelCarroSupereLos50Millones");
     }

     @Karate.Test
     public Karate EPSEARCHP007_searchCarsByPriceRange_DebeLanzarUnIllegalArgumentException_CuandoElPrecioInicialDelCarroSupereAlPrecioFinalParaFiltrar(){
        return karateScenario("EPSEARCHP007_searchCarsByPriceRange_DebeLanzarUnIllegalArgumentException_CuandoElPrecioInicialDelCarroSupereAlPrecioFinalParaFiltrar");
     }

    @Karate.Test
    public Karate EPSEARCHB001_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaBMW(){
        return karateScenario("EPSEARCHB001_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaBMW");
    }

    @Karate.Test
    public Karate EPSEARCHB002_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaKia(){
        return karateScenario("EPSEARCHB002_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaKia");
    }

    @Karate.Test
    public Karate EPSEARCHB003_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaPorche(){
        return karateScenario("EPSEARCHB003_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaPorche");
    }

    @Karate.Test
    public Karate EPSEARCHB004_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia(){
        return karateScenario("EPSEARCHB004_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia");
    }

    @Karate.Test
    public Karate EPSEARCHB005_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Porche(){
        return karateScenario("EPSEARCHB005_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Porche");
    }

    @Karate.Test
    public Karate EPSEARCHB006_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaKia_Y_Porche(){
        return karateScenario("EPSEARCHB006_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaKia_Y_Porche");
    }

    @Karate.Test
    public Karate EPSEARCHB007_searchCarsByBrands_DebeDevolver9Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia_Y_Porche(){
        return karateScenario("EPSEARCHB007_searchCarsByBrands_DebeDevolver9Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia_Y_Porche");
    }

    @Karate.Test
    public Karate EPSEARCHB008_searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueNingunaMarca_DadoQuePorDefectoBuscaraLasTresDisponibles(){
        return karateScenario("EPSEARCHB008_searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueNingunaMarca_DadoQuePorDefectoBuscaraLasTresDisponibles");
    }

    @Karate.Test
    public Karate EPSEARCHB009_searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueElParametroMarcas_DadoQuePorDefectoBuscaraLasTresDisponibles(){
        return karateScenario("EPSEARCHB009_searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueElParametroMarcas_DadoQuePorDefectoBuscaraLasTresDisponibles");
    }

    private Karate karateScenario(String scenarioName) {
        return Karate.run()
                .scenarioName(scenarioName)
                .relativeTo(getClass())
                .systemProperty("karate.port", localServerPort)
                .karateEnv("dev");
    }

}
