package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import java.util.ArrayList;

public class NodoArbol<T> implements Comparable<NodoArbol<T>> {

	private T elemento;

	private NodoArbol<T> izq, der;

	public NodoArbol(T elemento) {
		setElemento(elemento);
		this.izq = null;
		this.der = null;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NodoArbol<T> getIzq() {
		return izq;
	}

	public void setIzq(NodoArbol<T> izq) {
		this.izq = izq;
	}

	public NodoArbol<T> getDer() {
		return der;
	}

	public void setDer(NodoArbol<T> der) {
		this.der = der;
	}

	// ---------------------------METDOS DEL NODO ARBOL-------------------//

	public String toString() {
		return elemento.toString();
	}

	public boolean equals(Object obj) {
		return this.elemento.equals(((NodoArbol)obj).getElemento());
	}

	public ArrayList<T> recorrerInorden(ArrayList<T> acumulado) {
		if (getIzq() != null) {
			izq.recorrerInorden(acumulado);
		}
		acumulado.add(elemento);
		if (getDer() != null) {
			der.recorrerInorden(acumulado);
		}
		return acumulado;
	}

	public int compareTo(NodoArbol<T> nodo) {
		if (nodo.getElemento().hashCode() == this.getElemento().hashCode()) {
			return 0;

		} else if (nodo.getElemento().hashCode() > this.getElemento()
				.hashCode()) {

			return -1;

		} else {

			return 1;

		}

	}

	public boolean esHoja() {
		return (izq == null && der == null);
	}

	public boolean esMenor(NodoArbol<T> arg0) {
		return (this.compareTo(arg0) < 0);
	}

	public void agregarElemento(T elemento) {
		NodoArbol<T> nodoNuevo = new NodoArbol<T>(elemento);
		if (esHoja()) {
			if (esMenor(nodoNuevo)) {
				setDer(nodoNuevo);
			} else {
				setIzq(nodoNuevo);
			}
		} else if (esMenor(nodoNuevo)) {
			if (der == null) {
				setDer(nodoNuevo);
			} else {
				der.agregarElemento(elemento);
			}
		} else {
			if (izq == null) {
				setIzq(nodoNuevo);
			} else {
				izq.agregarElemento(elemento);
			}
		}
	}

}
