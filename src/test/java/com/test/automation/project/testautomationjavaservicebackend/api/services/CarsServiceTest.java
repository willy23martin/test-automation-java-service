package com.test.automation.project.testautomationjavaservicebackend.api.services;

import com.test.automation.project.testautomationjavaservicebackend.api.database.CarsDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CarsServiceTest {

    @Autowired
    private CarsDAO carsDAO;

    @Autowired
    private CarsService carsService;

    @Test
    void contextLoad_DebeCargarAlMenos_CarsDAO_Y_CarsService(){
        assertNotNull(carsDAO);
        assertNotNull(carsService);
    }

    @Test
    void EPCARS001_getCars_DebeDevolverNueveCarrosCargadosPreviamenteEnCarsDAO() {
        assertEquals(9, carsService.getCars().size());
    }

    @Test
    void EPSEARCHP001_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroNoSuperaLos100Millones() {
        assertEquals(3, carsService.searchCarsByPriceRange(0.0, 100000000.0).size());
    }

    @Test
    void EPSEARCHP002_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroEstribaEntre100MillonesY200Millones() {
        assertEquals(3, carsService.searchCarsByPriceRange(100000000.0, 200000000.0).size());
    }

    @Test
    void EPSEARCHP003_searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroSupereLos200Millones() {
        assertEquals(3, carsService.searchCarsByPriceRange(200000000.0, 1000000000.0).size());
    }

    @Test
    void EPSEARCHP004_searchCarsByPriceRange_DebeRetornarUnaListaCon6Carros_CuandoElPrecioDelCarroSupereLos100Millones() {
        assertEquals(6, carsService.searchCarsByPriceRange(100000000.0, 1000000000.0).size());
    }

    @Test
    void EPSEARCHP005_searchCarsByPriceRange_DebeRetornarUnaListaVacia_CuandoElPrecioDelCarroSeaInferiorA50Millones() {
        assertEquals(0, carsService.searchCarsByPriceRange(0.0, 50000000.0).size());
    }

    @Test
    void EPSEARCHP006_searchCarsByPriceRange_DebeRetornarUnaListaCon9Carros_CuandoElPrecioDelCarroSupereLos50Millones() {
        assertEquals(9, carsService.searchCarsByPriceRange(50000000.0, 1000000000.0).size());
    }

    @Test
    void EPSEARCHP007_searchCarsByPriceRange_DebeLanzarUnIllegalArgumentException_CuandoElPrecioInicialDelCarroSupereAlPrecioFinalParaFiltrar() {
        assertThrows(IllegalArgumentException.class, () -> {
            carsService.searchCarsByPriceRange(1000000000.0,  50000000.0);
        });

        try {
            carsService.searchCarsByPriceRange(1000000000.0,  50000000.0);
        } catch(IllegalArgumentException exception) {
            assertEquals(exception.getMessage(), "finalPrice should be greater than the initialPrice");
        }

    }

    @Test
    void EPSEARCHB001_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaBMW() {
        assertEquals(3, carsService.searchCarsByBrands("BMW").size());
    }

    @Test
    void EPSEARCHB002_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaKia() {
        assertEquals(3, carsService.searchCarsByBrands("Kia").size());
    }

    @Test
    void EPSEARCHB003_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaPorche() {
        assertEquals(3, carsService.searchCarsByBrands("Porche").size());
    }

    @Test
    void EPSEARCHB004_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia() {
        assertEquals(6, carsService.searchCarsByBrands("BMW,Kia").size());
    }

    @Test
    void EPSEARCHB005_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Porche() {
        assertEquals(6, carsService.searchCarsByBrands("BMW,Porche").size());
    }

    @Test
    void EPSEARCHB006_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaKia_Y_Porche() {
        assertEquals(6, carsService.searchCarsByBrands("Kia,Porche").size());
    }

    @Test
    void EPSEARCHB007_searchCarsByBrands_DebeDevolver9Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia_Y_Porche() {
        assertEquals(9, carsService.searchCarsByBrands("BMW,Kia,Porche").size());
    }

    @Test
    void searchCarsByBrands_NoDebeDevolverCarros_CuandoNoSeEspecifiqueNingunaMarca() {
        assertEquals(0, carsService.searchCarsByBrands("").size());
    }
}