package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import java.util.ArrayList;


public class ArbolBinario<T> {

	private NodoArbol<T> raiz;
	
	public ArbolBinario(){
		raiz=null;
	}

	public NodoArbol<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}
	
	//---------------METODOS DEL ARBOL BINARIO-------//
	
	public boolean estaVacio(){
		return (raiz==null);
	}
	
	public void agregarElemento(T elemento){
		if(estaVacio()){
			raiz=new NodoArbol<T>(elemento);
		}else{
			raiz.agregarElemento(elemento);
		}
	}
	
	public ArrayList<T> recorrerInorden(){
		ArrayList<T> inorden=new ArrayList<T>();
		return raiz.recorrerInorden(inorden);
	}
	
}
