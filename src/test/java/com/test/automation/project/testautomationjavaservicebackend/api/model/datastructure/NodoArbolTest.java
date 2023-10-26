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
class NodoArbolTest {

    private NodoArbol<Car> nodoArbolRaiz, nodoArbolDerecha;
    private Car carroRaiz, carroDerecha;

    @BeforeAll
    void setUp(){
        carroRaiz = Mockito.spy(new Car("imageURL.jpg", "CarroRaiz", 100.00, "Desc", "BMW"));
        carroDerecha = Mockito.spy(new Car("imageURL.jpg", "CarroRaiz", 100.50, "Desc", "BMW"));
        nodoArbolRaiz = new NodoArbol<>(carroRaiz);
        nodoArbolDerecha = new NodoArbol<>(carroDerecha);
    }

    @Test
    void testToString_DebeRetornarLaRepresentacionToStringDelElemento() {
        assertEquals(nodoArbolRaiz.toString(), carroRaiz.toString());
    }

    @Test
    void testEquals_DebeRetornarFalso_CuandoElPrecioDeLosDosElementosDeCadaNodoACompararDifieren() {
        assertFalse(nodoArbolRaiz.equals(nodoArbolDerecha));
    }

    @Test
    void testEquals_DebeRetornarVerdadero_CuandoElPrecioDeLosDosElementosDeCadaNodoACompararSonExactamenteIguales() {
        NodoArbol<Car> nodoArbol = new NodoArbol<>(carroDerecha);
        assertTrue(nodoArbolDerecha.equals(nodoArbol));
    }

}