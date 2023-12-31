package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArbolBinarioTest {

    private Car carroRaiz, carroDerecha, carroIzquierda;

    private ArbolBinario<Car> inventario;

    @BeforeAll
    void setUp(){
        inventario = new ArbolBinario<>();
        carroRaiz = new Car("imageURL.jpg", "CarroRaiz", 100.0, "Desc", "BMW");
        carroDerecha = new Car("imageURL.jpg", "CarroRaiz", 200.0, "Desc", "BMW");
        carroIzquierda = new Car("imageURL.jpg", "CarroRaiz", 90.0, "Desc", "BMW");
    }

    @Test
    void ARB01_estaVacio_DebeRetornarVerdadero_CuandoSeHayaInicializadoSinElementos() {
        assertTrue(inventario.estaVacio());
    }

    @Test
    void ARB02_estaVacio_DebeRetornarFalso_CuandoElInventarioTengaAlMenosUnCarro() {
        inventario.agregarElemento(carroRaiz);
        assertFalse(inventario.estaVacio());
    }

    @Test
    void ARB03_agregarElemento_PorLaPrimeraVez_DebeAsignarloASuNodoRaiz() {
        ArbolBinario<Car> inventario = Mockito.spy(new ArbolBinario<>());
        inventario.agregarElemento(carroRaiz);
        Mockito.verify(inventario, Mockito.times(1)).setRaiz(Mockito.any());
        assertEquals(inventario.getRaiz().getElemento(), carroRaiz);
    }

    @Test
    void ARB04_recorrerInorden_DebeRetornarTodosLosElementosRecorridosDeIzqADer_EsDecir_EnOrdenAscendente() {
        ArbolBinario<Car> inventario = Mockito.spy(new ArbolBinario<>());
        inventario.agregarElemento(carroRaiz);
        inventario.agregarElemento(carroDerecha);
        inventario.agregarElemento(carroIzquierda);

        ArrayList<Car> inventarioRecorridoInorden = inventario.recorrerInorden();

        assertEquals(inventario.getRaiz().getElemento(), carroRaiz);
        assertEquals(inventario.getRaiz().getDer().getElemento(), carroDerecha);
        assertEquals(inventario.getRaiz().getIzq().getElemento(), carroIzquierda);
        assertEquals(inventarioRecorridoInorden.get(0), carroIzquierda);
        assertEquals(inventarioRecorridoInorden.get(1), carroRaiz);
        assertEquals(inventarioRecorridoInorden.get(2), carroDerecha);
    }
}