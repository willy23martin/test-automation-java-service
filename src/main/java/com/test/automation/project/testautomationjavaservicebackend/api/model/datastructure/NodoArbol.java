package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import java.util.ArrayList;

public class NodoArbol<T> implements Comparable<NodoArbol<T>> {

	private T elemento;

	private NodoArbol<T> izq, der;

	public NodoArbol(T elemento) {
		this.elemento = elemento;
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

		if (izq != null) {

			izq.recorrerInorden(acumulado);

		}

		acumulado.add(elemento);

		if (der != null) {

			der.recorrerInorden(acumulado);

		}

		return acumulado;

	}

	public ArrayList<T> recorrerPreorden(ArrayList<T> acumulado) {

		acumulado.add(elemento);

		if (izq != null) {

			izq.recorrerInorden(acumulado);

		}

		if (der != null) {

			der.recorrerInorden(acumulado);

		}

		return acumulado;

	}

	public ArrayList<T> recorrerPostorden(ArrayList<T> acumulado) {

		if (izq != null) {

			izq.recorrerInorden(acumulado);

		}

		if (der != null) {

			der.recorrerInorden(acumulado);

		}

		acumulado.add(elemento);

		return acumulado;

	}

	public ArrayList<T> recorrerPorNiveles(ArrayList<T> lista) {

		NodoArbol<T> aux = this;

		ArrayList<NodoArbol<T>> cola = new ArrayList<NodoArbol<T>>();

		cola.add(aux);

		while (cola.size() != 0) {

			aux = cola.remove(0);

			lista.add(aux.elemento);

			if (aux.izq != null) {

				cola.add(aux.izq);

			}

			if (aux.der != null) {

				cola.add(aux.der);

			}

		}

		return lista;

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
				der = nodoNuevo;
			} else {
				izq = nodoNuevo;
			}
		} else if (esMenor(nodoNuevo)) {
			if (der == null) {
				der = nodoNuevo;
			} else {
				der.agregarElemento(elemento);
			}
		} else {
			if (izq == null) {
				izq = nodoNuevo;
			} else {
				izq.agregarElemento(elemento);
			}
		}
	}

	public NodoArbol<T> buscarNodo(T elemento) {
		NodoArbol<T> buscado = null;
		if (this.equals(new NodoArbol<T>(elemento))) {
			return this;
		} else if (esHoja()) {
			if (this.elemento.equals(elemento)) {
				buscado = this;
			} else {
				return null;
			}
		} else {
			if (esMenor(new NodoArbol<T>(elemento))) {
				if (der != null) {
					if (der.equals(new NodoArbol<T>(elemento))) {
						buscado = der;
					} else {
						buscado = der.buscarNodo(elemento);
					}
				} else {
					return null;
				}
			} else {
				if (izq != null) {
					if (izq.equals(new NodoArbol<T>(elemento))) {
						buscado = izq;
					} else {
						buscado = izq.buscarNodo(elemento);
					}
				} else {
					return null;
				}
			}
		}
		return buscado;
	}

	public NodoArbol<T> menor() {
		return izq == null ? this : izq.menor();
	}

	public NodoArbol<T> mayor() {
		return der == null ? this : der.mayor();
	}

	public NodoArbol<T> eliminarElemento(T elemento) throws Exception {
		if (esHoja()) {
			if (this.equals(new NodoArbol<T>(elemento))) {
				return null;
			} else {
				throw new Exception("El elemento no existe");
			}
		} else if (this.equals(new NodoArbol<T>(elemento))) {
			if (izq == null)
				return der;
			if (der == null)
				return izq;
			NodoArbol<T> sucesor = der.menor();
			der = der.eliminarElemento(sucesor.getElemento());
			sucesor.izq = izq;
			sucesor.der = der;
			return sucesor;
		} else if (!esMenor(new NodoArbol<T>(elemento)))
			izq = izq.eliminarElemento(elemento);
		else
			der = der.eliminarElemento(elemento);
		return this;
	}

	public int peso() {
		if (esHoja())
			return 1;
		int i = izq == null ? 0 : izq.peso();
		int d = der == null ? 0 : der.peso();

		return i + 1 + d;

	}

	public int altura() {
		if (esHoja())
			return 1;
		int i = izq == null ? 0 : 1 + izq.altura();
		int d = der == null ? 0 : 1 + der.altura();

		return Math.max(i, d);
	}

}
