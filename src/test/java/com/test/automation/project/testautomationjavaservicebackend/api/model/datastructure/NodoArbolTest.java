package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NodoArbolTest {

    private NodoArbol<Car> nodoArbolRaiz, nodoArbolDerecha;
    private Car carroRaiz, carroDerecha;

    @BeforeAll
    void setUp(){
        carroRaiz = new Car("imageURL.jpg", "CarroRaiz", 100.00, "Desc", "BMW");
        carroDerecha = new Car("imageURL.jpg", "CarroRaiz", 200.0, "Desc", "BMW");
        nodoArbolRaiz = new NodoArbol<>(carroRaiz);
        nodoArbolDerecha = new NodoArbol<>(carroDerecha);
    }

    @Test
    void NODAB01_ToString_DebeRetornarLaRepresentacionToStringDelElemento() {
        assertEquals(nodoArbolRaiz.toString(), carroRaiz.toString());
    }

    @Test
    void NODAB02_Equals_DebeRetornarFalso_CuandoElPrecioDeLosDosElementosDeCadaNodoACompararDifieren() {
        assertFalse(nodoArbolRaiz.equals(nodoArbolDerecha));
    }

    @Test
    void NODAB03_Equals_DebeRetornarVerdadero_CuandoElPrecioDeLosDosElementosDeCadaNodoACompararSonExactamenteIguales() {
        NodoArbol<Car> nodoArbol = new NodoArbol<>(carroDerecha);
        assertTrue(nodoArbolDerecha.equals(nodoArbol));
    }

}