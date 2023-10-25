package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        carroDerecha = new Car("imageURL.jpg", "CarroRaiz", 100.01, "Desc", "BMW");
        carroIzquierda = new Car("imageURL.jpg", "CarroRaiz", 99.999, "Desc", "BMW");
    }

    @Test
    void estaVacio_DebeRetornarVerdadero_CuandoSeHayaInicializadoSinElementos() {
        assertTrue(inventario.estaVacio());
    }

    @Test
    void estaVacio_DebeRetornarFalso_CuandoElInventarioTengaAlMenosUnCarro() {
        inventario.agregarElemento(carroRaiz);
        assertFalse(inventario.estaVacio());
    }

    @Test
    void agregarElemento_PorLaPrimeraVez_DebeAsignarloASuNodoRaiz() {
        ArbolBinario<Car> inventario = Mockito.spy(new ArbolBinario<>());
        inventario.agregarElemento(carroRaiz);
        Mockito.verify(inventario, Mockito.times(1)).setRaiz(Mockito.any());
        assertEquals(inventario.getRaiz().getElemento(), carroRaiz);
    }

    @Test
    void recorrerInorden() {
    }
}