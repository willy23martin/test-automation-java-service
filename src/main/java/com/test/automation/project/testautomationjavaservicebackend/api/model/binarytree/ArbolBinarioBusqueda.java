/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.test.automation.project.testautomationjavaservicebackend.api.model.binarytree;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;

/**
 *
 * @author thder
 */


class NodoArbol {
    Car car;
    NodoArbol izquierda, derecha;

    public NodoArbol(Car car) {
        this.car = car;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class ArbolBinarioBusqueda {
    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(Car car) {
        raiz = insertarRec(raiz, car);
    }

    private NodoArbol insertarRec(NodoArbol raiz, Car car) {
        if (raiz == null) {
            raiz = new NodoArbol(car);
            return raiz;
        }

        if (car.getPrice() < raiz.car.getPrice())
            raiz.izquierda = insertarRec(raiz.izquierda, car);
        else if (car.getPrice() > raiz.car.getPrice())
            raiz.derecha = insertarRec(raiz.derecha, car);

        return raiz;
    }

    public void imprimirInOrden() {
        imprimirInOrdenRec(raiz);
    }

    private void imprimirInOrdenRec(NodoArbol raiz) {
        if (raiz != null) {
            imprimirInOrdenRec(raiz.izquierda);
            System.out.println(raiz.car);
            imprimirInOrdenRec(raiz.derecha);
        }
    }

}
